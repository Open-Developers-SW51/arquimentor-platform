package com.arquimentor.platform.security.infrastructure.hashing.bcrypt;

import com.arquimentor.platform.security.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}
