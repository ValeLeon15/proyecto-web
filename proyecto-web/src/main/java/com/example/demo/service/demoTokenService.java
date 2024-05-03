package com.example.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;

import com.example.demo.dto.ArrendadorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class demoTokenService {
// @Value("${jwt.secret}")
    // private String secret = "DES6123";

    // @Value("${jwt.expiration}")
    private long demoExpiration = 99999999;
    private Key demoKey = Keys.secretKeyFor(SignatureAlgorithm.HS512);; // You need to set this key appropriately

    public String generarToken(ArrendadorDTO usuario) {

        // byte[] secretBytes = secret.getBytes();
        // Key jwtKey = new SecretKeySpec(secretBytes, SignatureAlgorithm.HS512.getJcaName());
        ObjectMapper objectMapper = new ObjectMapper();
        String username = "";
        try {
            username = objectMapper.writeValueAsString(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println(username  );

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + demoExpiration);

        Collection<? extends GrantedAuthority> authorities = new ArrayList<>();

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .claim("authorities", authorities.stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .signWith(demoKey, SignatureAlgorithm.HS512) // Use your appropriate signing algorithm
                .compact();
    }

    public String getUsername(String jwtToken){
        return decodificarToken(jwtToken).getSubject();
    }

    public Date getFechaExpiracion(String jwtToken){
        return decodificarToken(jwtToken).getExpiration();
    }

    public Claims decodificarToken(String jwtToken) {
        // byte[] secretBytes = secret.getBytes();
        // Key jwtKey = new SecretKeySpec(secretBytes, SignatureAlgorithm.HS512.getJcaName());

        return Jwts.parserBuilder()
                            .setSigningKey(jwtKey)
                            .build()
                            .parseClaimsJws(jwtToken)
                            .getBody();
    }
}
