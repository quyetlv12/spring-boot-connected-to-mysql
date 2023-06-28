package com.example.easynotes.model;

import javax.persistence.*;

@Entity
@Table(name = "categoriesProduct")
public class CategoriesProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    public CategoriesProduct() {
    }

    public CategoriesProduct(long id, String title) {
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
