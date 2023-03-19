package Mk.JD2_95_22.fitness.web.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import Mk.JD2_95_22.fitness.config.properites.JWTProperty;
import Mk.JD2_95_22.fitness.core.dto.model.UserJsonModel;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

@Component
public class JwtTokenHandler {
   private final JWTProperty property;
   public JwtTokenHandler(JWTProperty property) {
    this.property = property;
  }

   public  String generateAccessToken(UserJsonModel user) {
       Map<String, Object> claims = new HashMap<>();
       claims.put("fio",user.getName());
       claims.put("mail",user.getMail());
       claims.put("role",user.getRole());

       return Jwts.builder()
            .setClaims(claims)
            .setIssuer(property.getIssuer())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30))) //30 days
            .signWith(SignatureAlgorithm.ES512,property.getSecret())
            .compact();
   }

   public  String getUserName(String token){
       Claims claims=Jwts.parser()
            .setSigningKey(property.getSecret())
            .parseClaimsJws(token)
            .getBody();
       return claims.get("fio", String.class);
   }

   public  String getUserMail(String token){
       Claims claims=Jwts.parser()
            .setSigningKey(property.getSecret())
            .parseClaimsJws(token)
            .getBody();
       return claims.get("mail", String.class);
   }
    public  String getUserRole(String token){
       Claims claims=Jwts.parser()
            .setSigningKey(property.getSecret())
            .parseClaimsJws(token)
            .getBody();
       return claims.get("role", String.class);
    }

    public Date getExpirationDate(String token) {
        Claims claims = Jwts.parser()
              .setSigningKey(property.getSecret())
              .parseClaimsJws(token)
              .getBody();

        return claims.getExpiration();
    }
    public  boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(property.getSecret()).parseClaimsJws(token);
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
