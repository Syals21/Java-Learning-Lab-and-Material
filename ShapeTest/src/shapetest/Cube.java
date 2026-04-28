/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapetest;

/**
 *
 * @author User
 */
public class Cube extends Shape {
    private double side;
    
    public Cube(String name,double side){
        super(name);
        this.side=side;
    }
    
    public double calculateArea(){
        return 6*side*side;
    }
    
    public double calculateVolume(){
        return side*side*side;
    }
    
    public String toString(){
        return super.toString()+ String.format("side:%.2f \nArea:%.2f \nVolume:%.2f",this.side,this.calculateArea(),this.calculateVolume());
    }
}
