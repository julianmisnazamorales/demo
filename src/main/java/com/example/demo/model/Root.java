package com.example.demo.model;


import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Structure to hold the categories
 */
public class Root {

    /**
     * TreeRoot
     */
    private Category root;

    public Category getRoot() {
        return root;
    }

    public Root(){
        /**
         * Constructor class
         */
    }

    public boolean existNode(Category category, String value){
        return walkTree(category, value);
    }

    /**
     * This method going to walk the tree, and after it will discover if the node
     * exist
     * @param category
     * @param nodeName
     * @return
     */
    private boolean walkTree(Category category, String nodeName){
        if(null == category){
            return false;
        }
        if(null!= category.getCategories() && !category.getCategories().isEmpty()){
            walkTree(category.categories.get(0), nodeName);
        }
        else{
            return category.getName().equals(nodeName);
        }
        return false;
    }

    public void insertCategory(Category category){
        if(null == this.root){
            this.root = category;
        }
        else{
            this.root.getCategories().add(category);
        }
    }

    public void insertCategory(Category category, Category childCategory){
        category.getCategories().add(childCategory);
    }
}
