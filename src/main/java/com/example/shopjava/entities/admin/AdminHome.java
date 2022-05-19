package com.example.shopjava.entities.admin;

import javax.persistence.*;
import java.util.Date;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "admin_home")
public class AdminHome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer imageNumber;

    private String link;

    private String text;

    private Date date = Date.from(Instant.now());

    public AdminHome() {
    }

    public AdminHome(Integer imageNumber, String link, String text) {
        this.imageNumber = imageNumber;
        this.link = link;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getImageNumber() {
        return imageNumber;
    }

    public void setImageNumber(Integer imageNumber) {
        this.imageNumber = imageNumber;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdminHome adminHome = (AdminHome) o;
        return Objects.equals(imageNumber, adminHome.imageNumber) && Objects.equals(link, adminHome.link) && Objects.equals(text, adminHome.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageNumber, link, text);
    }
}
