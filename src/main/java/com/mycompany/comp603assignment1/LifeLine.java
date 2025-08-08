package com.mycompany.comp603assignment1;

/**
 * base class for all lifelines
 * @author Jesse
 */
public abstract class LifeLine {
    private String name;
    
    public LifeLine(String name){
        this.name = name;
    }
    
    public abstract void use(Question q);
    
    public String getName(){
        return name;
    }
}
