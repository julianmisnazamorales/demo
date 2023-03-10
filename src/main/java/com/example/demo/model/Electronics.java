package com.example.demo.model;

import java.util.List;

public class Electronics extends Category{
    public Electronics(String name, int level, List<Category> categories) {
        super();
        this.name = name;
        this.level = level;
        this.categories = categories;
    }
}
