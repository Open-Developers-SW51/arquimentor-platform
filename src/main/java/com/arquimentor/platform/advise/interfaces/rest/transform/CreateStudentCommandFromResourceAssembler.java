package com.arquimentor.platform.advise.interfaces.rest.transform;

import com.arquimentor.platform.advise.domain.model.commands.CreateStudentCommand;
import com.arquimentor.platform.advise.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {
    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource){
        return new CreateStudentCommand(
                resource.firstName(),
                resource.lastname(),
                resource.email(),
                resource.password());
    }
}
