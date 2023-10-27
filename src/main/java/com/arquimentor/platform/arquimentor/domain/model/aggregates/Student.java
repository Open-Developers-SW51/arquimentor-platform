package com.arquimentor.platform.arquimentor.domain.model.aggregates;

import jakarta.persistence.Id;

public class Student {

    @Id
    private Long id;

    private String name;


}
