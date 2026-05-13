/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreapp;

/**
 *
 * @author User
 */
public class Customer {
    private String name;
    private int phoneNum;
    
    public Customer(String name,int phoneNum){
        this.name=name;
        this.phoneNum= phoneNum;
    }
    public String getCustName(){
        return this.name;
    }
    public int getPhoneNum(){
        return this.phoneNum;
    }
    
    public String toString(){
        return String.format("Name             : %s\nPhone Number     : %d", name, phoneNum);
    }
}
