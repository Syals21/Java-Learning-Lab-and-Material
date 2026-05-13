/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bookstoreapp;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class BookStoreApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in= new Scanner(System.in);
        String name,itemName,itemID,bookName,genre,magazineName,magazineType,sType;
        int phoneNum,itemQuantity;
        int purchaseID=1;
        double price;
        
        System.out.println("========== Welcome to Bookstore App ==========");
        System.out.println("Item that can be choose:");
        System.out.println("\nItem Name : BOOKS");
        System.out.println("***************************************");
        System.out.println("  Book Name :Java Coding (Genre: Education)");
        System.out.println("  Item ID   :1245 ");
        System.out.println("  Price     : RM13.00");
        System.out.println("***************************************");
        System.out.println("  Book Name :Insidious (Genre: Horror)");
        System.out.println("  Item ID   :1289 ");
        System.out.println("  Price     : RM14.00");
        System.out.println("***************************************");
        
        System.out.println("\nItem Name :MAGAZINES");
        System.out.println("***************************************");
        System.out.println("  Magazine Name :National Geographic (Type: Science)");
        System.out.println("  Item ID       :1061 ");
        System.out.println("  Price         : RM10.00");
        System.out.println("***************************************");
        System.out.println("  Magazine Name :Vogue (Type: Fashion)");
        System.out.println("  Item ID       :1061 ");
        System.out.println("  Price         : RM10.00");
        System.out.println("***************************************");
        
        System.out.println("\nItem Name :STATIONARY:");
        System.out.println("***************************************");
        System.out.println("  Stationary Type : Notebook");
        System.out.println("  Item ID         :1612 ");
        System.out.println("  Price           : RM4.00");
        System.out.println("***************************************");
        System.out.println("  Stationary Type :Pen");
        System.out.println("  Item ID         :1613 ");
        System.out.println("  Price           : RM2.00");
        System.out.println("***************************************");
        System.out.println("=============================================\n");
        
        while(true){
            System.out.println("\n------ CUSTOMER INFO ------");
            System.out.print("Enter Name(Type 'stop' to stop): ");
            name = in.nextLine();
            
            if (name.equalsIgnoreCase("stop")){
                break;
            }
            
            System.out.print("Enter Phone Number: ");
            phoneNum = in.nextInt();
            in.nextLine();
            
            Customer cust = new Customer(name,phoneNum);
            System.out.println("\n------ ITEM DETAILS ------");
            System.out.print("Choose item in BookStore(Book/Magazine/Stationary): ");
            itemName=in.nextLine();
            System.out.print("Type item ID: ");
            itemID=in.nextLine();
            System.out.print("Item Price: ");
            price=in.nextDouble();
            System.out.print("Quantity: ");
            itemQuantity=in.nextInt();
            in.nextLine();
           
            if (itemName.equalsIgnoreCase("Book")){
                System.out.print("Enter Book name: ");
                bookName=in.nextLine();
                System.out.print("Enter Book genre: ");
                genre=in.nextLine();
                Item item=new Book(itemName,itemID,price,itemQuantity,bookName,genre);
                Random rand= new Random();
                purchaseID=10000+rand.nextInt(90000);
                CustPurchase purchase = new CustPurchase(cust,item,purchaseID);
                purchase.calculateDiscount(item);
                System.out.println("\n==================== RECEIPT ====================");
                System.out.println(purchase.toString());
                System.out.println("=================================================\n");

                
            }else if(itemName.equalsIgnoreCase("Magazine")){
                System.out.print("Enter Magazine name: ");
                magazineName=in.nextLine();
                System.out.print("Enter Magazine Type: ");
                magazineType=in.nextLine();
                Item item=new Magazine(itemName,itemID,price,itemQuantity,magazineName,magazineType);
                Random rand= new Random();
                purchaseID=10000+rand.nextInt(90000);
                CustPurchase purchase = new CustPurchase(cust,item,purchaseID);
                purchase.calculateDiscount(item);
                System.out.println("\n==================== RECEIPT ====================");
                System.out.println(purchase.toString());
                System.out.println("=================================================\n");
                
            }else if(itemName.equalsIgnoreCase("Stationary")){
                System.out.print("Enter Stationary type: ");
                sType=in.nextLine();
                Item item= new Stationary(itemName,itemID,price,itemQuantity,sType);
                Random rand= new Random();
                purchaseID=10000+rand.nextInt(90000);
                CustPurchase purchase = new CustPurchase(cust,item,purchaseID);
                purchase.calculateDiscount(item);
                System.out.println("\n==================== RECEIPT ====================");
                System.out.println(purchase.toString());
                System.out.println("=================================================\n");
                
            }else {
                System.out.println("Invalid Item");
            }
            
        }
        
        
    }
    
}
