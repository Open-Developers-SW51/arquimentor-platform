package com.arquimentor.platform.arquimentor.interfaces.rest.transform;

import com.arquimentor.platform.arquimentor.domain.model.commands.CreateMentorCommand;
import com.arquimentor.platform.arquimentor.interfaces.rest.resources.CreateMentorResource;

public class CreateMentorCommandFromResource {
    public static CreateMentorCommand resourceToCommand(CreateMentorResource resource){
        return new CreateMentorCommand(resource.subscription(),resource.idStudent());
    }
}
