/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital;

/**
 *
 * @author User
 */
public class Hospital {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HospitalStaff hs;
        
        hs= new Doctor("Syabil",308451,5000,16,"Surgery");
        hs.calculateMonthlySalary();
        System.out.println("============== Doctor ==============\n"+ hs.toString());
        
        hs= new Nurse("Nazihah",65401,3000,13,"Medicine");
        hs.calculateMonthlySalary();
        System.out.println("============== Nurse ==============\n"+ hs.toString());
        
        
    }
    
}
