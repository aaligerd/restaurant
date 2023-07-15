package com.enterprise.restaurant.security;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtHandler {
    @Value("${spring.jwt.secret}")
    private static String srcKey="myFullySecretKeyForRestaruntApplication";

    @Value("${spring.jwt.expire}")
    private static long expTime=86400;//time in ms



    public static final String genToken(int id,String email,String jobrole){
        Key secretKey = Keys.hmacShaKeyFor(srcKey.getBytes());
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expTime);
        return Jwts.builder()
                .claim("email",email)
                .claim("id",id)
                .claim("jobrole",jobrole)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(secretKey, SignatureAlgorithm.HS256)
                .compact();
    }

    public static String verifyToken(String token){

//        String payload=decodedJWT.getPayload();
//        System.out.println(payload);
//        return payload;
//        Verification verification=JWT.require(algo);
//        JWTVerifier build = verification.build();
//        DecodedJWT verify = build.verify(token);
//        System.out.println(verify.getToken());
//        System.out.println(verify.getHeader());
//        System.out.println(verify.getPayload());
//        System.out.println(verify.getSignature());
//        JWTPartsParser jwtPartsParser=new JWTParser();
//        Payload payload = jwtPartsParser.parsePayload(token);
//        Map<String, Claim> claims = payload.getClaims();
//        System.out.println(claims);



        return "";

    }
}
