package com.example.losaltoshackseducation;

public class Goal {

    String goalCategory;
    String goalName;
    String goalDescription;
    String goalPointValue;
    String className;

    public Goal(String goalCategory, String goalName, String goalDescription, String goalPointValue, String className) {
        this.goalCategory = goalCategory;
        this.goalName = goalName;
        this.goalDescription = goalDescription;
        this.goalPointValue = goalPointValue;
    }

    public String getName() {
        return goalName;
    }


    //Can delete this later
    @Override
    public String toString() {
        return "Goal{" +
                "goalCategory='" + goalCategory + '\'' +
                ", goalName='" + goalName + '\'' +
                ", goalDescription='" + goalDescription + '\'' +
                ", goalPointValue='" + goalPointValue + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
