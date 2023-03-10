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
     * Node level
     */
    protected int level;

    /**
     *
     */
    protected List<Category> categories = new ArrayList<>();

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public List<Category> getCategories() {
        return categories;
    }

    /**
     *
     * @param keyWords
     * Keywords to be search
     * @return
     */
    protected Category findCategoryFromKeyWords(List<String> keyWords){
        return null;
    }

    /**
     * Get node level
     * @return
     */
    protected int  getLevelFromRoot(){
        return 0;
    }

}
