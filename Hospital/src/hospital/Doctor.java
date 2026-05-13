/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author User
 */
public class Doctor extends HospitalStaff {
    private String ddepartment;
    
    public Doctor(String name, int staffID,double basicSalary,int hoursWork,String ddepartment){
        super(name,staffID,basicSalary,hoursWork);
        this.ddepartment=ddepartment;
    }
    
    public String getdDepartment(){
        return this.ddepartment;
    }
    
    @Override
    public double calculateMonthlySalary(){
        return super.getBasicSalary() + (super.getHoursWork()*50);
    }
    
    @Override
    public String toString(){
        return super.toString() + String.format("\nDepartment: %s\nTotal Monthly Salary: RM%.2f",this.ddepartment,calculateMonthlySalary());
    }
}
