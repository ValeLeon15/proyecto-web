package com.example.demo.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.example.demo.CustomUserDetailsService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class demoAuthorizationFilter {

 public static final String HEADER = "Authorization";
	public static final String PREFIX = "Bearer ";

    @Autowired
	private CustomUserDetailsService userDetailsService;

    @Autowired
    private demoTokenService demoTokenService;

	

	@Override
	protected void doFilterInternal( @NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain chain) throws ServletException, IOException {

		try {
			if (existeJWTToken(request)) {
				Claims claims = validarToken(request);
				if (claims.get("authorities") != null) {
					String username = getUsername(request);
					UserDetails userDetails = userDetailsService.loadUserByUsername(username);
					UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, userDetails, null);
					auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
           			SecurityContextHolder.getContext().setAuthentication(auth);
				} else {
					SecurityContextHolder.clearContext();
				}
			} else {
				SecurityContextHolder.clearContext();
			}
			chain.doFilter(request, response);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException | SignatureException e) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
		}
	}	

	private Claims validarToken(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		return jwtTokenService.decodificarToken(jwtToken);
	}
	private String getUsername(HttpServletRequest request) {
		String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		return jwtTokenService.getUsername(jwtToken);
	}
	private boolean existeJWTToken(HttpServletRequest request) {
		String authenticationHeader = request.getHeader(HEADER);
		return !(authenticationHeader == null || !authenticationHeader.startsWith(PREFIX));
	}
}
