package com.foo.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * service for get or verify a token
 *
 */
public class TokenService {

    //The JWT signature algorithm we will be using to sign the token
    private SignatureAlgorithm signatureAlgorithm;

    //We will sign our JWT with our ApiKey secret
    private Key signingKey;

    /**
     * token for 120 min
     */
    private static final long EXPIRATION_DELAIS_MS = 120 * 60 * 1000;

    private static final long REFRESH_TIME_MS = 10 * 60 * 1000;

    private static final String ISSUER = "DojoFrameWork";

    public void init() {
        String keySecretBytes = "super$Dojo123456789";

        //The JWT signature algorithm we will be using to sign the token
        signatureAlgorithm = SignatureAlgorithm.HS256;

        //We will sign our JWT with our ApiKey secret
        signingKey = new SecretKeySpec(keySecretBytes.getBytes(), signatureAlgorithm.getJcaName());

    }

    public String createJWT(...) {

        //set refresh time
        Map<String, Object> mapClaim = new HashMap<>();

        //Let's set the JWT Claims
        return Jwts.builder()
                .setClaims(mapClaim)
                .setHeaderParam("type", "JWT bearer")
                .setIssuer(ISSUER)
                .setIssuedAt(nowDate)
                .setExpiration(expDate)
                //.setSubject()
                .signWith(signatureAlgorithm, signingKey)
                .compact();
    }


    public Claims verifyToken(String compactJwt) {
        Claims claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(compactJwt).getBody();
        return claims;
    }

}
