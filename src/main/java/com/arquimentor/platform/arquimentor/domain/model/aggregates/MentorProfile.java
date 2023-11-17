package com.arquimentor.platform.arquimentor.domain.model.aggregates;


import com.arquimentor.platform.arquimentor.domain.model.valueobjects.PhoneNumber;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.UserProfilePhoto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Arrays;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class MentorProfile extends AbstractAggregateRoot<MentorProfile> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;


    @Setter
    @Embedded
    private PhoneNumber phonenumber;

    @Setter
    @Getter
    private String description;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String certificates;

    @Setter
    @Embedded
    private UserProfilePhoto userprofilephoto;



    @ManyToOne
    @Getter
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;


    public MentorProfile(PhoneNumber phonenumber, String description, UserProfilePhoto userprofilephoto, List<String> certificates, Mentor mentor){
        this.phonenumber=phonenumber;
        this.description=description;
        this.userprofilephoto= userprofilephoto;
        this.certificates=String.join(",", certificates);
        this.mentor=mentor;
    }
    public MentorProfile(){}

    public MentorProfile updateDescription(String description){
        this.description=description;
        return this;
    }

    public void updatePhoneNumber(String phonenumber) {
        this.phonenumber = new PhoneNumber(phonenumber);
    }
    public List<String> getCertificates() {
        return Arrays.asList(certificates.split(","));
    }
    public void updateUserProfilePhoto(UserProfilePhoto userprofilephoto) {
        this.userprofilephoto = userprofilephoto;
    }
    public String getPhoneNumber(){
        return this.phonenumber.phonenumber();
    }
    public  String getUserProfilePhoto(){
        return this.userprofilephoto.imageUrl();
    }

}