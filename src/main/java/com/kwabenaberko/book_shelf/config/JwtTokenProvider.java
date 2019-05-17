package com.kwabenaberko.book_shelf.config;

import com.kwabenaberko.book_shelf.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    private String jwtSecret = "secretKey";
    private int jwtExpirationInMs = ((86400 * 1000) * 14);

    public String generateToken(Authentication authentication){
        User user = (User) authentication.getPrincipal();
        Date expiryDate = new Date(new Date().getTime() + jwtExpirationInMs);
        return Jwts.builder()
                .setSubject(String.valueOf(user.getId()))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public long getUserIdFromJWT(String token){
        Jws<Claims> claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token);

        return Long.parseLong(claims.getBody().getSubject());
    }

}
