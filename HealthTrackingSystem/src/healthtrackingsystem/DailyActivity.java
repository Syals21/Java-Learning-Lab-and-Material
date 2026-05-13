/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package healthtrackingsystem;

/**
 *
 * @author User
 */
public class DailyActivity extends HealthRecord {

    private String activityType;
    private double duration;

    public DailyActivity(String activityType, double duration, User user, int userID, int recordID, String date) {
        super(user, userID, recordID, date);
        this.activityType = activityType;
        this.duration = duration;
    }

    public String getActivityType() {
        return activityType;
    }

    public double getDuration() {
        return duration;
    }

    public double calculateMet() {
        switch (this.activityType) {
            case "Rest":
                return 1.0;
            case "Walk":
                return 4.0;
            case "Run":
                return 8.0;
            default:
                return 0;
        }
    }

    public double calculateCaloriesBurned() {
        return calculateMet() * user.getWeight() * this.duration;
    }

    @Override
    public String displayRecord() {
        return String.format(
                "ACTIVITY RECORD\n"
                + "---------------------\n"
                + "%-15s : %s\n"
                + "%-15s : %s\n"
                + "%-15s : %s\n"
                + "%-15s : %s\n"
                + "%-15s : %.2f hours\n"
                + "%-15s : %.2f kcal\n"
                ,"Record ID", super.getRecordID(),"User ID", super.getUserID(),"Date", super.getDate(),"Activity Type", activityType,"Duration", duration,"Calories Burn", calculateCaloriesBurned()
        );
    }

}
