/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapetest;

/**
 *
 * @author User
 */
public abstract class Shape {
    protected String name;
    
    public Shape(String name){
        this.name=name;
    }
    
    public abstract double calculateArea();
    public abstract double calculateVolume();
    
    public String toString(){
        return String.format("\n------------------------------\n"
                + "Shape Name:%-10s%n",this.name);
    }
}
