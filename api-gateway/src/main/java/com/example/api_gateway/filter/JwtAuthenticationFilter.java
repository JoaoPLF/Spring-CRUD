package com.example.api_gateway.filter;

import java.io.IOException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
  private final String SECRET_KEY = "SECRET_KEY";
  
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
    String token = extractJwtFromRequest(request);

    if (token != null && validateToken(token)) {
      UserDetails userDetails = getUserDetails(token);

      JwtAuthenticationToken authentication = new J
    }
  }

  private String extractJwtFromRequest(HttpServletRequest request) {
    request.getHeader(ALREADY_FILTERED_SUFFIX)
    return "AAA";
  }

  private boolean validateToken(String token) {
    return true;
  }

  private UserDetails getUserDetails(String token) {
    return null;
  }
}
