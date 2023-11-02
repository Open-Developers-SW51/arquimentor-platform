package com.arquimentor.platform.arquimentor.domain.model.aggregates;

import com.arquimentor.platform.arquimentor.domain.model.valueobjects.Subscription;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;


    @Getter
    @Embedded
    private Subscription subscription;

    @ManyToOne
    @Getter
    @JoinColumn(name = "mentor_id")
    private Student student;

    public Mentor(String subscription, Student student){
        this.subscription= new Subscription(subscription);
        this.student=student;
    }

    public Mentor(){}
}
