package com.example.demo;

import com.example.demo.model.Category;
import com.example.demo.model.Electronics;
import com.example.demo.model.Root;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RootTest {

    @Test
    public void existNodeTest(){
        Root root = new Root();
        assertEquals(false, root.existNode(null, "Test"));
    }

    @Test
    public void doesNotExistNodeTest(){
        Root root = new Root();
        Category category = new Electronics("Refrigerator", 1, null);
        assertEquals(true, root.existNode(category, "Refrigerator"));
    }

    @Test
    public void createStructureTest(){
        Root root = new Root();
        List<Category> manualAir = List.of(new Electronics("Abanico", 3, null));
        List<Category> electricAir = List.of(new Electronics("airCondition", 3, null));
        List<Category> airCondition = List.of(new Electronics("Manual", 2, manualAir)
                                            , new Electronics("Electric", 2, electricAir));
        Category category = new Electronics("Air",1,airCondition);
        root.insertCategory(category);
        assertNotNull(root.getRoot());
    }

    @Test
    public void getStructureFromKeyWords(){
        List<String> keyWords = List.of("Nevera", "Congelador", "Refrigerador");
        Root root = new Root();
        List<Category> manualAir = List.of(new Electronics("Abanico", 3, null));
        List<Category> electricAir = List.of(new Electronics("airCondition", 3, null));
        List<Category> airCondition = List.of(new Electronics("Manual", 2, manualAir)
                , new Electronics("Electric", 2, electricAir));
        Category category = new Electronics("Air",1,airCondition);
        root.insertCategory(category);
        for (String key:keyWords) {
            root.existNode(root.getRoot(), key);
        }
    }
}
