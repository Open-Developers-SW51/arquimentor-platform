package com.arquimentor.platform.advise.interfaces.rest.transform;

import com.arquimentor.platform.advise.domain.model.commands.CreateMentorCommand;
import com.arquimentor.platform.advise.interfaces.rest.resources.CreateMentorResource;

public class CreateMentorCommandFromResource {
    public static CreateMentorCommand resourceToCommand(CreateMentorResource resource){
        return new CreateMentorCommand(resource.subscription(),resource.idStudent());
    }
}
