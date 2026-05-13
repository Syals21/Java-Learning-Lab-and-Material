/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labtestap;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class LabTestAP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        ArrayList<Product> product = new ArrayList<>();
        int stock;
        String id, name;
        int choice = 0;

        while (choice != 5) {
            System.out.println("===Choose Option Below===");
            System.out.println("1. Add product");
            System.out.println("2. Increase stock");
            System.out.println("3. Decrease stock");
            System.out.println("4. Display All");
            System.out.println("5. Stop Program");
            System.out.print("\nChoice: ");
            choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case 1:
                    try {
                        System.out.print("Product ID : ");
                        id = in.nextLine();
                        System.out.print("Name: ");
                        name = in.nextLine();
                        System.out.print("Stock: ");
                        stock = in.nextInt();
                        product.add(new Product(id, name, stock));
                        System.out.println("Product Add Succesfully\n");
                    } catch (NegativeStockException e) {
                        System.out.println("Exception: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    String Pid = in.nextLine();
                    System.out.print("Enter Amount to increase: ");
                    int amountInc = in.nextInt();
                    int inc = product.indexOf(Pid);
                    product.get(inc).IncreaseProduct(amountInc);
                    break;
                case 3:

                    try {
                        System.out.print("Enter Product ID: ");
                        String Did = in.nextLine();
                        System.out.print("Enter Amount to Decrease: ");
                        int amountDec = in.nextInt();
                        int dec = product.indexOf(Did);
                        product.get(dec).DecreaseProduct(amountDec);
                    } catch (NegativeStockException e) {
                        System.out.println("Exception:"+ e.getMessage());
                    }
                    break;
                case 4:
                    for (Product s: product ){
                        System.out.println(s);
                    }
                    break;
            }

        }
    }

}
