package com.arquimentor.platform.advicer.domain.model.queries;

import com.arquimentor.platform.advicer.domain.model.valueobjects.EmailAddress;

public record GetStudentByEmailQuery(EmailAddress emailAddress) {

}
