/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author User
 */
public abstract class HospitalStaff {
    private String name;
    private int staffID;
    private double basicSalary;
    private int hoursWork;
    
    public HospitalStaff(String name, int staffID,double basicSalary,int hoursWork){
        this.name=name;
        this.staffID=staffID;
        this.basicSalary=basicSalary;
        this.hoursWork= hoursWork;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getStaffID(){
        return this.staffID;
    }
    
    public double getBasicSalary(){
        return this.basicSalary;
    }
    public double getHoursWork(){
        return this.hoursWork;
    }
    
    public abstract double calculateMonthlySalary();
    
    public String toString(){
        return String.format("Hospital Staff Name: %s \nStaff ID: %d \nBasic Salary: RM%.2f \nTotal Hours Work: %d Hours",
                this.name,this.staffID,this.basicSalary,this.hoursWork);
    }
}
