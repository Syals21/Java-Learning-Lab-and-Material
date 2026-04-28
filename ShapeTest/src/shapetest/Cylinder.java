/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shapetest;

/**
 *
 * @author User
 */
public class Cylinder extends Shape {
    private double radius;
    private double height;
    
    public Cylinder(String name,double radius,double height){
        super(name);
        this.radius=radius;
        this.height=height;
    }
    
    @Override
    public double calculateArea() {
        return 2*(Math.PI)*this.radius*(this.radius*this.height);
    }

    @Override
    public double calculateVolume() {
        return Math.PI*(Math.pow(this.radius,2))*this.height;
    }
    
    public String toString(){
        return super.toString() + String.format("Area Cylinder:%-5.2f \nVolume Cylinder: %.2f",calculateArea(),calculateVolume());
    }
}
