package com.arquimentor.platform.arquimentor.domain.model.aggregates;

import com.arquimentor.platform.arquimentor.domain.model.valueobjects.Carousel;
import com.arquimentor.platform.arquimentor.domain.model.valueobjects.EmailAddress;
import com.arquimentor.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.arquimentor.platform.arquimentor.domain.model.aggregates.Student;

import java.util.List;


@EntityListeners(AuditingEntityListener.class)
@Entity
public class Publication extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Setter
    @Getter
    private String title;

    @Setter
    @Getter
    private String description;

    @Getter
    private String image;

    @Setter
    @Getter
    private String telephone;


    @Getter
    private Integer views;

    @ManyToOne
    @Getter
    @JoinColumn(name = "mentor_id")
    private Student student;

    public Publication(String title,String description,String image,String telephone,Student student){
        this.title=title;
        this.description=description;
        this.image=image;
        this.telephone=telephone;
        this.views=0;
        this.student=student;
    }
    public Publication(){}

    public void incrementView(){
        this.views = views+1;
    }

    /*public void addImage(String image){this.carousel.addImage(image);}
    public void deleteImage(String image){this.carousel.deleteImage(image);}*/

    /*public List<String> getCarruselString(){
        return this.carousel.getImages();
    }*/
}
