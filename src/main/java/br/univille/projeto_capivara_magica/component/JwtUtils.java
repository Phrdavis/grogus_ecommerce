package br.univille.projeto_capivara_magica.component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

import javax.crypto.SecretKey;

@Component
public class JwtUtils {

    @Autowired
    @Value("${jwt.secret}")
    private String jwtSecret;
    
    @Value("${jwt.expirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(String email, long id, String tipo) {
        SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

        return Jwts.builder()
                .claim("id", id)
                .claim("tipo", tipo)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

    }
    
}
