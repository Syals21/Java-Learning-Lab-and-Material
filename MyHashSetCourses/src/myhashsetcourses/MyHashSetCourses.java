/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myhashsetcourses;

import java.util.HashSet;

/**
 *
 * @author User
 */
public class MyHashSetCourses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        HashSet <String> courses= new HashSet <>();
        courses.add("CS101");
        courses.add("CS102");
        courses.add("CS103");
        courses.add("CS104");
        courses.add("CS102");
        System.out.println("==Display Courses==");
        for( String u : courses){
            System.out.println(u);
        }
        
        System.out.println("Size: "+courses.size());
        System.out.println("Contain CS104: "+courses.contains("CS104"));
        System.out.println("Contain CS999: "+courses.contains("CS999"));
        courses.remove("CS103");
        System.out.println("CS103 has been remove");
        System.out.println("empty?:"+ courses.isEmpty());
        System.out.println("\n==Display Upadte Courses==");
        for( String u : courses){
            System.out.println(u);
        }
        
        HashSet <String> extraCourses = new HashSet <>();
        extraCourses.add("CS201");
        extraCourses.add("CS202");
        extraCourses.add("CS104");
        
        System.out.println("\n==Display ExtraCourses==");
        for ( String u : extraCourses){
            System.out.println(u);
        }
        
        courses.addAll(extraCourses);
        
        System.out.println("\nMerged Courses");
        for(String i: courses){
            System.out.println(i);
        }
        courses.retainAll(extraCourses);
        System.out.println("\nDisplay Retain all");
        for ( String u:courses){
            System.out.println(u);
        }
        
        courses.removeAll(extraCourses);
        System.out.println("\nDisplay courses Remove all extra courses");
        System.out.println(courses);
        
        courses.clear();
        System.out.println("Courses empty?: "+courses.isEmpty());
        
        
        
    }
    
}
