package com.example.demo.model;


/**
 * Structure to hold the categories
 */
public class Tree {

    private Category root;

    private int count = 0;
    private int lvl = 0;

    public Tree(Category root){
        this.root = root;
    }

    public Category getRoot() {
        return root;
    }

    public void setRoot(Category root) {
        this.root = root;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    /**
     *
     * @param nameToSearch
     * Name to be found
     * @return
     */
    public boolean exist(String nameToSearch){
        return find(root, nameToSearch);
    }

    /**
     * Recursive method to find if the node value exist. This search on all the children nodes
     *
     * @param node
     * @param nameToSearch
     * Value to be found it
     * @return
     * Boolean value wich indicate if the node exists
     */
    private  boolean find(Category node, String nameToSearch){
        boolean existNode = false;
        if(node.getName().equals(nameToSearch)){
            return true;
        }
        else {
            if(null != node.getCategories()){
                for (Category children : node.getCategories()){
                    count +=1;
                    if(find(children, nameToSearch)){
                        existNode = true;
                        setLvl(count);
                    }
                }
            }
        }
        return existNode;
    }
}
