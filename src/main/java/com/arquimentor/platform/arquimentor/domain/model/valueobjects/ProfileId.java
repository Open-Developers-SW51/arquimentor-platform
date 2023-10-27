package com.arquimentor.platform.arquimentor.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProfileId(Long profileId) {
    public ProfileId(){
        this(0L);
    }
}
