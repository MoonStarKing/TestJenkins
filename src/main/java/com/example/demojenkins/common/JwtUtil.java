package com.example.demojenkins.common;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class JwtUtil {

    @Value("${secret}")
    private String secret;

    public String token(String id){
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256,this.secret)
                .setId(id)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 36000))
                .compact();
    }

    public String parseToken(String token){
        Claims body = Jwts.parser().setSigningKey("abdsdsd").parseClaimsJws(token).getBody();
        return body.getId();
    }

    public boolean isExpire(String token){
        Claims body = Jwts.parser().setSigningKey("sfs").parseClaimsJwt(token).getBody();
        Date expiration = body.getExpiration();
        return expiration.before(new Date());
    }

}
