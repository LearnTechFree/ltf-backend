package com.learntechfree.ltf.security;

import com.learntechfree.ltf.config.AppConfig;
import com.learntechfree.ltf.redis.AuthTokenService;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;


@Service
public class TokenProvider {
    private static final Logger logger = LoggerFactory.getLogger(TokenProvider.class);

    private AppConfig appConfig;

    @Autowired
    private AuthTokenService authTokenService;

    public TokenProvider(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public String createAccessToken(Long userId) {
        logger.info("Generating JWT access token");
        String token = generateJWTToken(userId);

        return authTokenService.create(token, userId);
    }

    public String generateJWTToken(Long userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + appConfig.getAuth().getTokenExpirationMsec());

        return Jwts.builder()
                .setSubject(Long.toString(userId))
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, appConfig.getAuth().getTokenSecret())
                .compact();
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(appConfig.getAuth().getTokenSecret())
                .build()
                .parseClaimsJws(token)
                .getBody();

        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parserBuilder().setSigningKey(appConfig.getAuth().getTokenSecret()).build().parseClaimsJws(authToken);
            return true;
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.");
        }
        return false;
    }
}
