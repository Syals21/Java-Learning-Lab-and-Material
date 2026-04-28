/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapetest;

/**
 *
 * @author User
 */
public class Rectangle extends Shape {
    private double length;
    private double width;
    
    public Rectangle(String name,double length, double width){
        super(name);
        this.length=length;
        this.width=width;
    }
    
    @Override
    public double calculateArea(){
        return this.length*this.width;
    }
    
    public double calculateVolume(){
        return 0;
    }
    
    public String toString(){
        return super.toString() + String.format("Area Rectangle:%-5.2f \nVolume Rectangle: %.2f",calculateArea(),calculateVolume());
    }
}
