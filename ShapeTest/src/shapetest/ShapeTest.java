/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package shapetest;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class ShapeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in= new Scanner(System.in);
        String name,next;
        double side,radius,height,length,width;
        
        System.out.print("================ Welcome to Shape Test App ================\n ");
        while(true){
            System.out.print("Input name of Shape (Rectangle/Cube/Cylinder): ");
            name=in.nextLine();
            if (name.equalsIgnoreCase("Rectangle")){
                System.out.println("------------ Details ------------ ");
                System.out.print("Input Length: ");
                length=in.nextDouble();
                System.out.print("Input Width: ");
                width=in.nextDouble();
                in.nextLine();
                
                Shape sh= new Rectangle(name,length,width);
                sh.calculateArea();
                sh.calculateVolume();
                System.out.println(sh.toString());
            }else if(name.equalsIgnoreCase("Cube")){
                System.out.println("------------ Details ------------ ");
                System.out.print("Input Side: ");
                side=in.nextDouble();
                in.nextLine();
                
                Shape sh= new Cube (name,side);
                sh.calculateArea();
                sh.calculateVolume();
                System.out.println(sh.toString());
            }else if(name.equalsIgnoreCase("Cylinder")){
                System.out.println("\n------------ Details ------------ ");
                System.out.print("Input Radius: ");
                radius=in.nextDouble();
                System.out.print("Input Height: ");
                height=in.nextDouble();
                in.nextLine();
                
                Shape sh= new Cylinder (name,radius,height);
                sh.calculateArea();
                sh.calculateVolume();
                System.out.println(sh.toString());
            }else
                System.out.println("\nInvalid Shape name. Please Enter Rectangle/Cube/Cylinder");
            
            System.out.print("\nContinue?(yes or no): ");
            next=in.nextLine();
            
            if(next.equalsIgnoreCase("No")){
                System.out.println("\n============= Thank You for using our System =============");
                break;
            }
        }
        
    }
    
}
