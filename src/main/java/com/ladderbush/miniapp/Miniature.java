package com.ladderbush.miniapp;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;

@Entity(name = "Miniature")
@Table(name = "miniatures")
public class Miniature {

    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private String progress;

    private int scale;
    
    @Lob
    private byte[] image;

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] bs) {
        this.image = bs;
    }

    public Miniature() {
    }

    public Miniature(String name, int scale, String progress) {
        this.name = name;
        this.scale = scale;
        this.progress = progress;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Miniature miniature = (Miniature) o;
        return Objects.equals(id, miniature.id) &&
                Objects.equals(name, miniature.name) &&
                Objects.equals(scale, miniature.scale) &&
                Objects.equals(progress, miniature.progress);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, scale, progress);
    }

    @Override
    public String toString() {
        return "Miniature{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", scale='" + scale + '\'' +
                ", progress='" + progress + '\'' +
                '}';
    }

}
