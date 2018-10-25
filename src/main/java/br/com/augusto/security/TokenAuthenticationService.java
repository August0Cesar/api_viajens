package br.com.augusto.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.fasterxml.jackson.databind.util.JSONPObject;

import br.com.augusto.models.Token;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
	// EXPIRATION_TIME = 10 dias
	static final long EXPIRATION_TIME = 860_000_000;
	static final String SECRET = "MySecret";
	static final String TOKEN_PREFIX = "Bearer";
	static final String HEADER_STRING = "Authorization";

	static void addAuthentication(HttpServletResponse response, String username) throws IOException {
		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();

		response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
		/*response.setHeader("Content-Type", "application/json");

		PrintWriter writer = response.getWriter();
		Token token = new Token(HEADER_STRING, TOKEN_PREFIX + " " + JWT);

		writer.write(token.toString());*/

	}

	public static String getAuthenticatioTeste(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);

		if (token != null) {
			// faz parse do token
			String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
					.getSubject();

			if (user != null) {
				return user;
			}
		}
		return null;
	}

	static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);

		if (token != null) {
			// faz parse do token
			String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
					.getSubject();

			if (user != null) {
				return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
			}
		}
		return null;
	}

}
