package org.sails.security.service;

import io.jsonwebtoken.*;
import org.sails.entity.DomainUser;
import org.sails.security.SecurityUser;
import org.sails.security.rest.JSONTokenAuthentication;
import org.springframework.security.core.Authentication;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.*;

/**
 * Created by Nodirbek on 18.09.2015.
 */
public class TokenService {
    private String encodedSecretKey; /* ihSAUFhrCVW0XzPZJ4UWGw== */
    private String secretKeyAlgorithm; /* AES */
    private SignatureAlgorithm signatureAlgorithm;
    private Key key;


    public TokenService(String encodedSecretKey, String secretKeyAlgorithm, SignatureAlgorithm signatureAlgorithm) {
        this.encodedSecretKey = encodedSecretKey;
        this.secretKeyAlgorithm = secretKeyAlgorithm;
        this.signatureAlgorithm = signatureAlgorithm;
    }

    public String generateToken(DomainUser domainUser) {
        JwtBuilder jwtBuilder = Jwts.builder().setSubject(domainUser.getEmail());
        Map<String, Object> map = new HashMap<>();
        map.put("login", domainUser.getEmail());
        map.put("authorities", domainUser.getAuthorities());
        jwtBuilder.setClaims(map);
        jwtBuilder.signWith(signatureAlgorithm, getSecretKey());
        return jwtBuilder.compact();
    }

    public Authentication getAuthentication(String jwtString) {
        DomainUser outToken = this.getOutToken(jwtString);
        if (outToken != null) {
            return new JSONTokenAuthentication(outToken.getAuthorities(), new SecurityUser(outToken));
        }
        return null;
    }

    public DomainUser getVerified(String email, String password) {
        return null;
    }

    public DomainUser getOutToken(String jwtString) {
        if (isSigned(jwtString)) {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(jwtString);
            /*
            user info from token
             */
            List<String> authorities = (List<String>) claimsJws.getBody().get("authorities");
            String login = (String) claimsJws.getBody().get("login");
            /*
            user info from token
             */
            DomainUser domainUser = new DomainUser();
            domainUser.setEmail(login);
            domainUser.setRoles(authorities);

            return domainUser;
        }
        return null;
    }

    public boolean isSigned(String JWToken) {
        return Jwts.parser().setSigningKey(getSecretKey()).isSigned(JWToken);
    }

    private Key getSecretKey() {
        if (key == null) {
            byte[] decodedKey = Base64.getDecoder().decode(encodedSecretKey);
            this.key = new SecretKeySpec(decodedKey, 0, decodedKey.length, this.secretKeyAlgorithm);
        }
        return this.key;
    }

}
