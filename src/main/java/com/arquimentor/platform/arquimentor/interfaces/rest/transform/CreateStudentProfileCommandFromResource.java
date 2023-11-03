package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentProfileCommand;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateStudentProfileResource;

public class CreateStudentProfileCommandFromResource {
    public static CreateStudentProfileCommand resourceToCommand(CreateStudentProfileResource resource) {
        PhoneNumber phoneNumber = resource.phonenumber();
        return new CreateStudentProfileCommand(
                phoneNumber.phonenumber(), // Accede directamente al campo 'phonenumber'
                resource.description(),
                resource.userprofilephoto().imageUrl(),
                resource.idStudent()
        );
    }
}


