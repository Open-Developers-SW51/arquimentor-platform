package com.arquimentor.platform.advicer.domain.model.commands;

import java.util.List;

public record UpdateMentorProfileCommand(
        Long id,
        String nick,
        String phoneNumber,
        String slogan,
        String userProfilePhoto,
        List<String> certificates
) {
}
