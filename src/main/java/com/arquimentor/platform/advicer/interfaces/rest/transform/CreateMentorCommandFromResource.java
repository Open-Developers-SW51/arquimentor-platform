package com.arquimentor.platform.advicer.interfaces.rest.transform;

import com.arquimentor.platform.advicer.domain.model.commands.CreateMentorCommand;
import com.arquimentor.platform.advicer.interfaces.rest.resources.CreateMentorResource;

public class CreateMentorCommandFromResource {
    public static CreateMentorCommand resourceToCommand(CreateMentorResource resource){
        return new CreateMentorCommand(resource.subscription(),resource.idStudent());
    }
}
