package cogent.demo.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import cogent.demo.security.services.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${cogent.demo.jwtSecret}")
	private String jwtSecret;

	@Value("${cogent.demo.jwtExpirationMs}")
	private int jwtExpirationMs;

	//generate token for user
	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		//while creating the token -
	
		//   compaction of the JWT to a URL-safe string 
		
		return Jwts.builder().setSubject((userPrincipal.getUsername()))//Defines subject of the token
				.setIssuedAt(new Date()) //Defines time of issue the token
				
				.setExpiration(new Date((new Date())//Defines expiration of the token
						.getTime() + jwtExpirationMs))
				
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
		
	}			//Sign the JWT using the HS512 algorithm and secret key.
				//  compaction of the JWT to a URL-safe string 
	
	//retrieve username from jwt token
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser()
				.setSigningKey(jwtSecret)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	//validate token
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser()
			.setSigningKey(jwtSecret)
			.parseClaimsJws(authToken);
			
			return true;
			
			//Exception for error messages
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}