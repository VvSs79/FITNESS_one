package Mk.JD2_95_22.fitness.security.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import Mk.JD2_95_22.fitness.core.dto.model.UserModel;
import org.springframework.stereotype.Component;
import org.springframework.security.core.GrantedAuthority;
import java.util.function.Function;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {
  private static final String jwtSecret = "B1yCyWipHOa6PZk6WpCBe";
  private static final String jwtIssuer = "MJITAcademy";

  public static String generateAccessToken(UserModel user) {
    Map<String, Object> claims = new HashMap<>();
    String commaSeparatedListOfAuthorities=  user.getAuthorities().stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(","));
    claims.put("authorities", commaSeparatedListOfAuthorities);
    return generateAccessToken(claims , user.getMail());
  }

  public static String generateAccessToken(Map<String, Object> claims, String subject ) {
    return Jwts.builder().setClaims(claims)
            .setSubject(subject)
            .setIssuer(jwtIssuer)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(7))) // 1 week
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact();
  }    //извлечение имени пользователя из токена (внутри валидация токена)
  public static String extractUsername(String token) {
    return extractClaim(token, Claims::getSubject);
  }

  //извлечение authorities (внутри валидация токена)
  public  static String extractAuthorities(String token) {
    Function<Claims, String> claimsListFunction = claims -> (String)claims.get("authorities");
    return extractClaim(token, claimsListFunction);
  }

  private static  <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(token);
    return claimsResolver.apply(claims);
  }

  private static Claims extractAllClaims(String token) {
    return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
  }
  public static Date getExpirationDate(String token) {
    Claims claims = Jwts.parser()
            .setSigningKey(jwtSecret)
            .parseClaimsJws(token)
            .getBody();

    return claims.getExpiration();
  }

  public static boolean validate(String token) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
      return true;
    } catch (SignatureException ex) {
      //logger.error("Invalid JWT signature - {}", ex.getMessage());
    } catch (MalformedJwtException ex) {
      //logger.error("Invalid JWT token - {}", ex.getMessage());
    } catch (ExpiredJwtException ex) {
      //logger.error("Expired JWT token - {}", ex.getMessage());
    } catch (UnsupportedJwtException ex) {
      //logger.error("Unsupported JWT token - {}", ex.getMessage());
    } catch (IllegalArgumentException ex) {
      //logger.error("JWT claims string is empty - {}", ex.getMessage());
    }
    return false;
  }
}
