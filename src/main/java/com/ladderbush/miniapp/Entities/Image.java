package com.ladderbush.miniapp.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity(name = "Image")
@Table(name = "images")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {

    @Lob
    @Column(name = "image")
    private String image;

    @Id
    @Column(name = "miniatureId")
    private Long miniatureId;

    public Image(String image) {
        this.image = image;
    }

}
