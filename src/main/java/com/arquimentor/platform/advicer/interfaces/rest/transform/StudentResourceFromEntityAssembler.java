package com.arquimentor.platform.advicer.interfaces.rest.transform;

import com.arquimentor.platform.advicer.domain.model.aggregates.Student;
import com.arquimentor.platform.advicer.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student entity){
        return new StudentResource(entity.getId(),entity.getStudentName(),entity.getEmailAddress(),entity.getPassword());
    }
}
