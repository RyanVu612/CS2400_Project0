//Ryan Vu
//CS1400
//Assignment 4
//9 October, 2024

import java.util.ArrayList;
import java.util.Scanner;

public class A4ScholarshipFinder {
    public static void main(String[] args) {
        ArrayList<A4Scholarship> scholarships = new ArrayList<A4Scholarship>();

        int major = 0;
        int classLevel = 0;
        double gpa = 0.0;asdfasd
        double date = 0;
        int quantity = 1;
        int response = 0;

        Scanner scanner = new Scanner(Systeadfafm.in);

        scholarships = collectScholarships(scholarships);

        while (response != -1) {
            showConfigs(major, classLevel, gpa, date, quantity);
            System.out.println("Enter the numberasdfasdfdf which you want to edit. Enter [-1] to exit. Enter [6] to find scholarships");
            response = scanner.nextInt();

            if (response == -1) {
                break;
            }adsfsdfjdsafkldsa

            switch (response) {
                case 0: 
                    System.out.println("Enter the number which you want to edit. Enter [6] to find scholarships");
                    break;
                case 1:
                    System.out.println("\nWhat are you majoring in?\n[1] Computer Science" 
                        + "\n[2] Civil Engineering"
                        + "\n[3] Mechanical Engineering");
                    major = scanner.nextInt();
                    break;
                case 2:
                    System.out.println("\nWhat college class level are you? Ex: Enter '2' for sophomore status");
                    classLevel = scanner.nextInt();
                    break;
                case 3:
                    System.out.println("\nWhat is your current GPA?");
                    gpa = scanner.nextDouble();
                    break;
                case 4:
                    System.out.println("\nWhat is the current date? (Use format 0.YYYYMMDD)");
                    date = scanner.nextDouble();
                    break;
                case 5:
                    System.out.println("\nHow many scholarships do you want to be listed? (Max of " + scholarships.size() + ")");
                    quantity = scanner.nextInt();
                    break;
                case 6:
                    scholarships = findScholarships(scholarships, major, classLevel, gpa, date);
                    printScholarships(scholarships, quantity);
                    response = -1;
                    break;
                default:
                    break;
            }
        }
    }

    public static void showConfigs(int major, int classLevel, double gpa, double date, int quantity) {
        System.out.println("\nCurrent configurations:\n[1] Major - " + majorString(major)
            + "\n[2] Class Level - " + classLevel
            + "\n[3] GPA - " + gpa
            + "\n[4] Date - " + dateToString(date)
            + "\n[5] Number of Scholarships - " + quantity);
    }

    public static ArrayList<A4Scholarship> collectScholarships(ArrayList<A4Scholarship> scholarships) {
        scholarships.add(A4ScholarshipList.alvarez);
        scholarships.add(A4ScholarshipList.bbh);
        scholarships.add(A4ScholarshipList.checkPoint);
        scholarships.add(A4ScholarshipList.donald);
        scholarships.add(A4ScholarshipList.boeing);
        return scholarships;
    }

    public static ArrayList<A4Scholarship> findScholarships(ArrayList<A4Scholarship> scholarships, int major, int classLevel,
        double gpa, double date) {
        ArrayList<A4Scholarship> newList = new ArrayList<A4Scholarship>();
        for (A4Scholarship scholarship : scholarships) {
            if (major == scholarship.getMajor()) {
                scholarship.incrementCounter();
            }
            if (classLevel >= scholarship.getMinClassLevel() && classLevel <= scholarship.getMaxClassLevel()) {
                scholarship.incrementCounter();
            }
            if (gpa >= scholarship.getMinGpa()) {
                scholarship.incrementCounter();
            }
            if (date <= scholarship.getDeadLine()) {
                scholarship.incrementCounter();
            }

            // first object being added to array list (no need to sort)
            if (newList.size() == 0) {
                newList.add(scholarship);
                continue;
            }
            
            for (int i = 0; i < newList.size(); i++) {
                if (scholarship.getCounter() >= newList.get(i).getCounter()) {
                    newList.add(i, scholarship);
                    break;
                } else {
                    newList.add(scholarship);
                }
            }
        }
        return newList;
    }

    public static String dateToString(double date) {
        int year = (int) (date * 10000);
        int month = (int) (date * 1000000 - year * 100);
        int day = (int) (date * 100000000 - year * 10000 - month * 100);

        return month + "/" + day + "/" + year;
    }

    public static String majorString(int major) {
        String majorString = "none";

        switch (major) {
            case 0:
                majorString = "none";
                break;
            case 1: 
                majorString = "Computer Science";
                break;
            case 2:
                majorString = "Civil Engineering";
                break;
            case 3:
                majorString = "Mechanical Engineering";
                break;
            case 4:
                majorString = "";
                break;
            default:
                break;
        }
        return majorString;
    }

    public static void printScholarships(ArrayList<A4Scholarship> scholarships, int quantity) {
        for (int i = 0; i < quantity; i++) {
            System.out.println(
                "\n" + (i + 1) + ". " + scholarships.get(i).getName() + " for $" + scholarships.get(i).getAmount() 
                + " due on " + dateToString(scholarships.get(i).getDeadLine()) + " in "
                + majorString(scholarships.get(i).getMajor()));
        }
    }
}