package com.br.csousa.organizationForAll.configurations;

import com.br.csousa.organizationForAll.models.response.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import org.springframework.security.core.AuthenticationException;

import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        String errorMessage = "Autenticação necessária: " + authException.getMessage();
        if (authException instanceof InsufficientAuthenticationException) {
            errorMessage = "TOKEN INVÁLIDO";
        }

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        errorResponse.setMessage(errorMessage);

        ObjectMapper objectMapper = new ObjectMapper();
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));

    }
}




