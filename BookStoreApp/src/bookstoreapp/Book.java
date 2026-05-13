/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstoreapp;

/**
 *
 * @author User
 */
public class Book extends Item {
    private String bookName;
    private String genre;
    
    public Book(String itemName,String itemID,double price,int itemQuantity,String bookName,String genre){
        super(itemName,itemID,price,itemQuantity);
        this.bookName=bookName;
        this.genre=genre;    
    }
    
    public String getBookName(){
        return this.bookName;
    }
    public String getGenre(){
        return this.genre;
    }
    
    @Override
    public double getDiscountRate(double amountPurchase){
        if(amountPurchase>80 && amountPurchase<=200){
            return 0.12;
        }else if(amountPurchase>200){
            return 0.25;
        }else {
            return 0.0;
        }
    }
    
    @Override
    public String toString(){
        return super.toString() + String.format("\nBook Name        : %s\nGenre            : %s",this.bookName,this.genre);
    }
}
