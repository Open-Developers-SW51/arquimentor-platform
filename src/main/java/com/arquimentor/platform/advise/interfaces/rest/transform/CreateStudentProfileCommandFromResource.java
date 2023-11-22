package com.arquimentor.platform.advise.interfaces.rest.transform;

import com.arquimentor.platform.advise.domain.model.commands.CreateStudentProfileCommand;
import com.arquimentor.platform.advise.interfaces.rest.resources.CreateStudentProfileResource;

public class CreateStudentProfileCommandFromResource {
    public static CreateStudentProfileCommand resourceToCommand(CreateStudentProfileResource resource) {
        return new CreateStudentProfileCommand(
                resource.nick(),
                resource.phoneNumber(), // Accede directamente al campo 'phonenumber'
                resource.slogan(),
                resource.userProfilePhoto(),
                resource.idStudent()
        );
    }
}


