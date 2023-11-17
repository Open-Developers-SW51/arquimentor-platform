package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.aggregates.StudentProfile;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.StudentProfileResource;

public class StudentProfileEntityToResource {
    public static StudentProfileResource toResourceFromEntity(StudentProfile entity) {
        return new StudentProfileResource(
                entity.getNick(),
                entity.getId(),
                entity.getPhoneNumber(),
                entity.getSlogan(),
                entity.getUserProfilePhoto(),
                entity.getStudent()
        );
    }
}
