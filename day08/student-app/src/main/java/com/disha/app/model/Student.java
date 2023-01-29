package com.disha.app.model;

public class Student {

    String name;

    String roll;
   String std;
   String schoolname;

   public Student(){

   }
    public Student(String name, String roll, String std, String schoolname) {
        this.name = name;
        this.roll = roll;
        this.std = std;
        this.schoolname = schoolname;
    }
    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public String getStd() {
        return std;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public void setStd(String std) {
        this.std = std;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }



}
