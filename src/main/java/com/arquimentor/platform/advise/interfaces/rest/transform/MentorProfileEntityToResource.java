package com.arquimentor.platform.advise.interfaces.rest.transform;

import com.arquimentor.platform.advise.domain.model.aggregates.MentorProfile;
import com.arquimentor.platform.advise.interfaces.rest.resources.MentorProfileResource;

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
