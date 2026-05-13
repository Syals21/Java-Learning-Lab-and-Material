/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package excercisefunctional;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 *
 * @author User
 */
public class ExcerciseFunctional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Supplier<T>
        System.out.println("Supplier: ");
        Supplier<String> greetingMessage = () -> "Welcome to the Program!";
        String message = greetingMessage.get();
        System.out.println("Greeting Message: "+ message);
        
        //Consumer<T>
        System.out.println("===================================");
        System.out.println("Consumer: ");
        Consumer<String> number = s-> System.out.println(s);
        number.accept("18");
        
        //Predicate<T>
        System.out.println("===================================");
        System.out.println("Predicate: ");
        Predicate<Integer> mark = n-> n>25 && n<100;
        System.out.println("Mark 88 Pass?: "+mark.test(88));
        System.out.println("Mark 20 Pass?: "+mark.test(20));
        
        //Funtion<T,R>
        System.out.println("===================================");
        System.out.println("Function: ");
        Function <Double,Double> cf = n -> (n*9/5.0)+32;
        System.out.println("30 Celsius to Fahreinheit: "+ cf.apply(30.0));
        
        //UnaryOperator<T>
        System.out.println("===================================");
        System.out.println("UnaryOperator: ");
        UnaryOperator <String> uppercase = s-> s.toUpperCase();
        System.out.print("Hello word toUpperCase:");
        String result = uppercase.apply("Hello World");
        System.out.println(result);
        
        //BiConsumer<T,U>
        System.out.println("===================================");
        System.out.println("BiConsumer: ");
        System.out.println("Print \"name:value\"");
        BiConsumer<String,String> print = (a,b) -> System.out.println(a+":"+b);
        print.accept("Test","One");
        
        //BiPredicate<T,U>
        System.out.println("===================================");
        System.out.println("BiPredicate: ");
        BiPredicate<Double,Double> compare = (a,b)->a<b;
        System.out.println("Price 78 < budget 20:"+ compare.test(78.0,20.0));
        System.out.println("Price 30 < budget 50:"+ compare.test(30.0,50.0));
        
        //BiFunction<T,U,R>
        System.out.println("===================================");
        System.out.println("BiFunction: ");
        BiFunction < Integer,Integer,Integer> add = (a,b)->a+b;
        System.out.println("Add 30 and 25: "+ add.apply(30, 25));
        
        //Binaryoperator
        System.out.println("===================================");
        System.out.println("BinaryOperator: ");
        BinaryOperator <Integer> findMax = Math::max;
        System.out.println("Find Maximum of (15,7): " + findMax.apply(15, 7));   
    }
}
