package com.arquimentor.platform.arquimentor.domain.model.aggregates;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Time;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Appointment extends AbstractAggregateRoot<Appointment> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    private Date date;

    @Setter
    @Getter
    private Time time;

    @ManyToOne
    @Getter
    @JoinColumn(name = "architecture_student_id")
    private Student student;

    @ManyToOne
    @Getter
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    public Appointment ( String description, Date date, Time time, Student student)

}
