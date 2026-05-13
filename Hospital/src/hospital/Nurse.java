/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author User
 */
public class Nurse extends HospitalStaff{
    private String ndepartment;
    
    public Nurse(String name, int staffID,double basicSalary,int hoursWork,String ndepartment){
        super(name,staffID,basicSalary,hoursWork);
        this.ndepartment=ndepartment;
    }
    
    public String getnDepartment(){
        return this.ndepartment;
    }
    
    @Override
    public double calculateMonthlySalary(){
        return super.getBasicSalary() + (super.getHoursWork()*30);
    }
    
    @Override
    public String toString(){
        return super.toString() + String.format("\nDepartment: %s\nTotal Monthly Salary: RM%.2f",this.ndepartment,calculateMonthlySalary());
    }
}
