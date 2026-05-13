/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthtrackingsystem;

/**
 *
 * @author User
 */
public class User {

    private int userId;
    private String name;
    private int age;
    private String gender;
    private double weight;
    private double height;

    public User(int userId, String name, int age, String gender, double weight, double height) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public double calculateBMI() {
        if (this.height > 0) {
            return weight / (height * height);
        }
        return 0;
    }

    public String resultBMI() {
        if (calculateBMI() < 18.5) {
            return "Underweight";
        } else if (calculateBMI() < 24.9) {
            return "Normal weight";
        } else if (calculateBMI() < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }

    }

    @Override
    public String toString() {
        return String.format(
                "USER HEALTH PROFILE\n"
                + "------------------------\n"
                + "%-12s : %s\n"
                + "%-12s : %s\n"
                + "%-12s : %d years\n"
                + "%-12s : %s\n"
                + "%-12s : %.1f kg\n"
                + "%-12s : %.2f m\n"
                + "%-12s : %.2f\n"
                + "%-12s : %s\n"
                ,"ID", userId,"Name", name,"Age", age,"Gender", gender,"Weight", weight,"Height", height,"BMI", calculateBMI(),"Category", resultBMI());
    }

}
