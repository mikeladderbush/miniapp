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
import jakarta.persistence.GeneratedValue;

@Entity(name = "Miniature")
@Table(name = "miniatures")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Miniature {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Progress")
    private String progress;

    @Column(name = "Scale")
    private int scale;

    @Column(name = "Page")
    private String page;

    @Lob
    @Column(name = "Image")
    private byte[] image;

}
