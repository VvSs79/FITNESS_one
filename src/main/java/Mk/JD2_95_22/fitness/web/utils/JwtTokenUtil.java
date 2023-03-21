package Mk.JD2_95_22.fitness.web.utils;

import Mk.JD2_95_22.fitness.config.properties.JWTProperty;
import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
@Component
public class JwtTokenUtil {

//    private static final String jwtSecret = "NDQ1ZjAzNjQtMzViZi00MDRjLTljZjQtNjNjYWIyZTU5ZDYw";
//    private static final String jwtIssuer = "ITAcademy";

    private final JWTProperty property;
    public JwtTokenUtil(JWTProperty property) {
        this.property = property;
    }

//    public static String generateAccessToken(UserJsonModel user) {
//        return generateAccessToken(user.getMail());
//    }

//    public static String generateAccessToken(String name) {
//        return Jwts.builder()
//                .setSubject(name)
//                .setIssuer(jwtIssuer)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(7))) // 1 week
//                .signWith(SignatureAlgorithm.HS512, jwtSecret)
//                .compact();
//    }
    public String generateAccessToken(UserJsonModel user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("fio", user.getFio());
        claims.put("mail", user.getMail());
        claims.put("role", user.getRole());
        claims.put("uuid", user.getUuid());
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer(property.getIssuer())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(7))) // 1 week
                .signWith(SignatureAlgorithm.HS512, property.getSecret())
                .compact();
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(property.getSecret())
                .parseClaimsJws(token)
                .getBody();

        return claims.get("fio", String.class);
    }
    public  String getUserMail(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(property.getSecret())
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
    public String getUserRole(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(property.getSecret())
                .parseClaimsJws(token)
                .getBody();

        return claims.get("role", String.class);
    }
    public String getUserUUDI(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(property.getSecret())
                .parseClaimsJws(token)
                .getBody();

        return claims.get("uuid", String.class);
    }


    public  Date getExpirationDate(String token) {
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
