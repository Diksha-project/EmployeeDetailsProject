package com.infy.project.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	
	private String secretkey = "";
	
  public JWTService(){
	  
	  try {
		  KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
		  
		  SecretKey sk = keyGen.generateKey();
		  
		  secretkey = Base64.getEncoder().encodeToString(sk.getEncoded());
		  
	  }catch( NoSuchAlgorithmException e) {
		   throw new RuntimeException(e);
	  }
		
	}

	public String generateToken(String userId) {

		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder().claims().add(claims).subject(userId).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 60 * 60 * 10)).and().signWith(getKey()).compact();

		// TODO Auto-generated method stub

	}

	private SecretKey getKey() {
	byte[] KeyByte = Decoders.BASE64.decode(secretkey);
	
		return Keys.hmacShaKeyFor(KeyByte);
	}

	public String getUsernamefromToken(String token) {
		// TODO Auto-generated method stub
		return extractClaim(token, Claims::getSubject);
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		 final String userName = getUsernamefromToken(token);
	        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	   
	}
	
	

	    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimResolver.apply(claims);
	    }

	    private Claims extractAllClaims(String token) {
	        return Jwts.parser()
	                .verifyWith(getKey())
	                .build()
	                .parseSignedClaims(token)
	                .getPayload();
	    }

	  
	    private boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    private Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }


}
