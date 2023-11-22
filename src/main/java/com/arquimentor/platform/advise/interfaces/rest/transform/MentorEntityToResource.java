package com.arquimentor.platform.advise.interfaces.rest.transform;

import com.arquimentor.platform.advise.domain.model.aggregates.Mentor;
import com.arquimentor.platform.advise.interfaces.rest.resources.MentorResource;

public class MentorEntityToResource {
    public static MentorResource EntityToResource(Mentor mentor){
        return new MentorResource (mentor.getId(),mentor.getSubscription(),mentor.getStudent());
    }
}
