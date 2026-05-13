/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package task2lambdaexp;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Task2LambdaExp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in=new Scanner(System.in);
        //Celsius to Fahrenheit
        TemperatureConverter a = x -> {
            double cf = (x * 9 / 5.0) + 32;
            return cf;
        };
        //Fahrenheit to Celsius 
        TemperatureConverter b=x->{
            double fc= (x-32)*5/9.0;
            return fc;
        };
        
        //Celsius to Kelvin
        TemperatureConverter c = x ->{
            double ck=x+273.15;
            //buat kt luar
            if (ck<0){
                System.out.println("Result is absolute zero for Celcius to Kelvin");
            }
            return ck;
        };
        
        //Kelvin to Celcius
        TemperatureConverter d = x ->{
            double kc = x-273.15;
            // buat kt luar if statement
            if(kc<-273.15){
                System.out.println("The result is Absolute Zero for Kelvin to Celcius");
            }
            return kc;
        };
        
        System.out.print("Enter Temperature: ");
        double tmp=in.nextDouble();
        System.out.println("===== Temperature Conversion Result =====");
        System.out.println("Celsius to Fahrenheit: "+ a.convert(tmp)+" F");
        System.out.println("Fahrenheit to Celsius: "+ b.convert(tmp)+" C");
        System.out.println("Celsius to Kelvin: "+ c.convert(tmp)+" K");
        System.out.println("Kelvin to Celsius: "+ d.convert(tmp)+" C");
        
        
    }
}
