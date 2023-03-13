package com.example.demo;

import com.example.demo.model.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RootTest {

    private Tree tree;
    private Category category;
    private List<Category> children;

    @Test
    public void existNodeTest(){
        children = new ArrayList<>(){{add(new Electronics("fridge",  null));
                                      add(new Electronics("icebox",  null));}};
        category =  new Electronics("refrigeration",  children);
        tree = new Tree(category);
        Category newCategory = new Furniture("couch", null);
        Category newCategoryHome = new HomeAppliances("phone", null);
        category.addCategory(newCategory);
        category.addCategory(newCategoryHome);
        assertEquals(true, tree.exist("couch"));
    }

    @Test
    public void doesNotExistNodeTest(){
        children = new ArrayList<>(){{add(new Electronics("fridge",  null));
                                      add(new Electronics("icebox",  null));}};
        category =  new Electronics("refrigeration",  children);
        tree = new Tree(category);
        Category newCategory = new Furniture("phone", null);
        category.addCategory(newCategory);
        assertEquals(false, tree.exist("couch"));
    }

    @Test
    public void getLvlNodeTest(){
        List<Category> bigRefrigeration = new ArrayList<>(){{add(new Electronics("big refrigeration", null));}};
        children = new ArrayList<>(){{add(new Electronics("fridge",  bigRefrigeration));
            add(new Electronics("icebox",  null));}};
        category =  new Electronics("refrigeration",  children);
        tree = new Tree(category);
        tree.exist("big refrigeration");
        assertEquals(2, tree.getLvl());
    }

}
