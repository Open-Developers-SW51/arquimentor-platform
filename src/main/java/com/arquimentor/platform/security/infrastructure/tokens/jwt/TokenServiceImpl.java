package com.arquimentor.platform.security.infrastructure.tokens.jwt;

import com.arquimentor.platform.security.application.internal.outboundservices.tokens.TokenService;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String generateToken(String username) {
        return null;
    }

    @Override
    public String getUsernameFromToken(String token) {
        return null;
    }

    @Override
    public boolean validateToken(String token) {
        return false;
    }
}