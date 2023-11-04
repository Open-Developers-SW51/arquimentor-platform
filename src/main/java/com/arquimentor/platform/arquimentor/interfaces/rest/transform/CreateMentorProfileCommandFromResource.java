package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.commands.CreateMentorProfileCommand;
import com.arquimentor.platform.arquimentor.domain.model.commands.CreateStudentProfileCommand;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateMentorProfileResource;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateStudentProfileResource;

public class CreateMentorProfileCommandFromResource {
    public static CreateMentorProfileCommand resourceToCommand(CreateMentorProfileResource resource) {
        PhoneNumber phoneNumber = resource.phonenumber();
        return new CreateMentorProfileCommand(
                phoneNumber.phonenumber(), // Accede directamente al campo 'phonenumber'
                resource.description(),
                resource.userprofilephoto().imageUrl(),
                resource.certificates(),
                resource.idMentor()
        );
    }
}


