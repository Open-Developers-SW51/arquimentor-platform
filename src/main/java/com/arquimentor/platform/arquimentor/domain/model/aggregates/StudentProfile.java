package com.arquimentor.platform.arquimentor.domain.model.aggregates;


import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.UserProfilePhoto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class StudentProfile extends AbstractAggregateRoot<StudentProfile> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;


    @Setter
    @Getter
    @Embedded
    private PhoneNumber phonenumber;

    @Setter
    @Getter
    private String description;

    @Setter
    @Getter
    @Embedded
    private UserProfilePhoto userprofilephoto;



    @ManyToOne
    @Getter
    @JoinColumn(name = "student_id")
    private Student student;


    public StudentProfile(PhoneNumber phonenumber, String description, UserProfilePhoto userprofilephoto, Student student){
        this.phonenumber=phonenumber;
        this.description=description;
        this.userprofilephoto= userprofilephoto;
        this.student=student;
    }
    public StudentProfile(){}

    public StudentProfile updateDescription(String description){
        this.description=description;
        return this;
    }
    public void updatePhoneNumber(PhoneNumber phonenumber) {
        this.phonenumber = phonenumber;
    }
    public void updateUserProfilePhoto(UserProfilePhoto userprofilephoto) {
        this.userprofilephoto = userprofilephoto;
    }
}