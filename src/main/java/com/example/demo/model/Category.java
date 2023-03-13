package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class to define the node behaviour inn the tree
 */
public abstract class Category {

    /**
     * Category name
     */
    protected String name;

    /**
     *
     */
    protected List<Category> categories = new ArrayList<>();

    /**
     *Node parent
     */
    protected Category parent;

    public String getName() {
        return name;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    protected Category(String name, List<Category> categories){
        this.name = name;
        this.categories = categories;
    }

    protected Category(Category category){
        this.name = category.getName();
    }


    public List<Category> getCategories() {
        return categories;
    }

    /**
     * Add a new category on the tree. As assumption I will to add the node to the current category
     * @param sonCategory
     * New Category to add
     */
    public void addCategory(Category sonCategory){
        sonCategory.setParent(this);
        categories.add(sonCategory);
    }


}
