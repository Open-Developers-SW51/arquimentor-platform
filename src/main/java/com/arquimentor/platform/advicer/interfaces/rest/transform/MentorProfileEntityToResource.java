package com.arquimentor.platform.advicer.interfaces.rest.transform;

import com.arquimentor.platform.advicer.domain.model.aggregates.MentorProfile;
import com.arquimentor.platform.advicer.interfaces.rest.resources.MentorProfileResource;

public class MentorProfileEntityToResource {
    public static MentorProfileResource toResourceFromEntity(MentorProfile entity) {
        return new MentorProfileResource(
                entity.getId(),
                entity.getNick(),
                entity.getPhoneNumber(),
                entity.getSlogan(),
                entity.getUserProfilePhoto(),
                entity.getCertificates(),
                entity.getMentor()
        );
    }
}
