//Ryan Vu
//CS1400
//Assignment 4
//9 October, 2024

public class A4Scholarship {
    String name;
    int major;
    int minClassLevel;
    int maxClassLevel;
    double gpa;
    double amount;
    double deadLine; // use format 0.YYYYMMDD so that August 23 2025 would be 0.20250823
    int counter;

    public A4Scholarship(String name, int major, int minClassLevel, int maxClassLevel, double gpa, double amount, double deadLine) {
        this.name = name;
        this.major = major;
        this.minClassLevel = minClassLevel;
        this.maxClassLevel = maxClassLevel;
        this.amount = amount;
        this.deadLine = deadLine;
        counter = 0;
    }

    public String getName() {
        return name;
    }

    public int getMajor() {
        return major;
    }

    public int getMinClassLevel() {
        return minClassLevel;
    }

    public int getMaxClassLevel() {
        return maxClassLevel;
    }

    public double getMinGpa() {
        return gpa;
    }
    public double getAmount() {
        return amount;
    }

    public double getDeadLine() {
        return deadLine;
    }

    public void incrementCounter() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
