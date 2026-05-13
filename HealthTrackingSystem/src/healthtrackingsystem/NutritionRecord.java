/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthtrackingsystem;

/**
 *
 * @author User
 */
public class NutritionRecord extends HealthRecord {

    private String mealType;
    private double calories;

    public NutritionRecord(String mealType, double calories, User user, int userID, int recordID, String date) {
        super(user, userID, recordID, date);
        this.mealType = mealType;
        this.calories = calories;
    }

    public String getMealType() {
        return mealType;
    }

    public double getCalories() {
        return calories;
    }

    @Override
    public String displayRecord() {
        return String.format(
                "MEAL RECORD\n"
                + "---------------------\n"
                + "%-15s : %s\n"
                + "%-15s : %s\n"
                + "%-15s : %s\n"
                + "%-15s : %s\n"
                + "%-15s : %.2f kcal\n"
                ,"Record ID", super.getRecordID(),"User ID", super.getUserID(),"Date", super.getDate(),"Meal Type", mealType,"Calories", calories);
    }
}
