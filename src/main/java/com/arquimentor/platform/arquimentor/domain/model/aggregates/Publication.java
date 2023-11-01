package com.arquimentor.platform.arquimentor.domain.model.aggregates;

import com.arquimentor.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Arrays;
import java.util.List;


@EntityListeners(AuditingEntityListener.class)
@Entity
public class Publication extends AbstractAggregateRoot<Publication> {
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

    @Lob
    @Column(columnDefinition = "TEXT")
    private String images;

    @Setter
    @Getter
    private String telephone;


    @Getter
    private Integer views;

    @Getter
    private Integer likes;

    @ManyToOne
    @Getter
    @JoinColumn(name = "mentor_id")
    private Student student;


    public Publication(String title,String description,List<String> image,String telephone,Student student){
        this.title=title;
        this.description=description;
        this.images=String.join(",", image);
        this.telephone=telephone;
        this.views=0;
        this.likes=0;
        this.student=student;
    }
    public Publication(){}

    public void incrementView(){
        this.views = views+1;
    }
    public void incrementLike(){
        this.likes = likes+1;
    }
    public List<String> getImages() {
        return Arrays.asList(images.split(","));
    }

}
