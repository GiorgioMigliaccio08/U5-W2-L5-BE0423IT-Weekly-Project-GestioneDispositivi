package giorgiomigliaccio.U5W1L5.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import giorgiomigliaccio.U5W1L5.entities.utente;

import java.util.Date;

@Component
public class JWTTools {

    public String createToken() {
        return "accesstoken";
        @Value("${spring.jwt.secret}")
        private String secret;

        public String createToken(User user) {
            return Jwts.builder().subject(String.valueOf(user.getId())) // Subject <-- A chi appartiene il token (id dell'utente)
                    .issuedAt(new Date(System.currentTimeMillis())) // Data di emissione (IAT - Issued At)
                    .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)) // Data di scadenza (Expiration Date)
                    .signWith(Keys.hmacShaKeyFor(secret.getBytes())) // Firmo il token
                    .compact();
        }

        public void verifyToken() {
        }
    }