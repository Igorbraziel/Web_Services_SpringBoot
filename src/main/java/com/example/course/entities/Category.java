package com.example.course.entities;

import jakarta.persistence.*;

import java.util.Objects;

import java.io.Serializable;
import java.io.Serial;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Category(){}

    public Category(Long id, String name){
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(id);
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null || obj.getClass() != getClass()) return false;
        Category category = (Category) obj;
        return Objects.equals(id, category.id);
    }
}
