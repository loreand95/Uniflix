package it.univaq.disim.sose.rest.utils;

import java.security.NoSuchAlgorithmException;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import it.univaq.disim.sose.rest.model.User;

public class JWTHelpers {

    private static JWTHelpers instance = null;
    
    private SecretKey jwtKey = null;
    
    private String DEFAULT_SECRET_WORD = "VF8fbVLiHfvsRiCMBDbTXPN3xIMaGguT2941gFaGgxQ=";

    private JWTHelpers() {}
    
    public static JWTHelpers getInstance() {
        if (instance == null) {
            instance = new JWTHelpers();
        }
        return instance;
    }
    
    private String generateSecretWord() {
        KeyGenerator keyGenerator;
        try {
            keyGenerator = KeyGenerator.getInstance("HmacSha256");
            jwtKey = keyGenerator.generateKey();
            
            return Encoders.BASE64.encode(jwtKey.getEncoded());
        } catch (NoSuchAlgorithmException ex) {
            //System.out.println("ERRORE");
        }
		return DEFAULT_SECRET_WORD;
    }

    public SecretKey getJwtKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(DEFAULT_SECRET_WORD));
    }
    
    
    //TODO  verificare
    public static String generateToken(User user) {
    	return Jwts.builder()
		.setId(user.getId())
		.signWith(JWTHelpers.getInstance().getJwtKey())
		.compact();
    }
}
