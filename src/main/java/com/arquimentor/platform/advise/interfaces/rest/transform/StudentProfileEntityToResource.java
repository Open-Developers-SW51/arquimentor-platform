package com.arquimentor.platform.advise.interfaces.rest.transform;

import com.arquimentor.platform.advise.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.advise.interfaces.rest.resources.StudentProfileResource;

public class StudentProfileEntityToResource {
    public static StudentProfileResource toResourceFromEntity(StudentProfile entity) {
        return new StudentProfileResource(
                entity.getId(),
                entity.getNick(),
                entity.getPhoneNumber(),
                entity.getSlogan(),
                entity.getUserProfilePhoto(),
                entity.getStudent()
        );
    }
}
