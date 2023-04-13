package Mk.JD2_95_22.fitness.web.utils;

import Mk.JD2_95_22.fitness.config.properties.JWTProperty;
import Mk.JD2_95_22.fitness.core.dto.j_model.UserJsonModel;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;

@Component
public class JwtTokenUtil {

    private final JWTProperty property;
    public JwtTokenUtil(JWTProperty property) {
        this.property = property;
    }

public String generateAccessToken(Map<String, Object> claims, String name) {
    return Jwts.builder().setClaims(claims)
            .setSubject(name)
            .setIssuer(property.getIssuer())
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(7))) // 1 week
            .signWith(SignatureAlgorithm.HS512, property.getSecret())
            .compact();
}

    public String generateToken(UserJsonModel user) {
        Map<String, Object> claims = new HashMap<>();
        String commaSeparatedListOfAuthorities = user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
        claims.put("authorities", commaSeparatedListOfAuthorities);
        claims.put("uuid", user.getUuid());
        claims.put("fio", user.getFio());
        return generateAccessToken(claims, user.getUsername());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(property.getSecret()).parseClaimsJws(token).getBody();
    }


    public boolean validate(String token) {
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
