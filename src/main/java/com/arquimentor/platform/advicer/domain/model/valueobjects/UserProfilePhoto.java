package com.arquimentor.platform.advicer.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NonNull;


@Embeddable

public record UserProfilePhoto(
        @NonNull @Column(name = "profile_photo") String imageUrl
) {
    public UserProfilePhoto() {
        this(null);
    }


}