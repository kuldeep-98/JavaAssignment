import java.time.LocalDate;
import java.util.Scanner;

class Age {
    private int days;
    private int months;
    private int years;

    public Age(int days, int months, int years) {
        this.days = days;
        this.months = months;
        this.years = years;
    }

    public int getDays() {
        return days;
    }

    public int getMonths() {
        return months;
    }

    public int getYears() {
        return years;
    }

    public String Print() {
        return years + " Years, " + months + " Months, " + days + " Days";
    }
}

public class GetAge {

    private static Age GetUserAge(String DOB) {
        LocalDate date = LocalDate.now();

        int calAge, calMonths, days;
        int userYear,userMonth,userDays;
        int currentMonth = date.getMonthValue();
        int currentYear = date.getYear();
        int currentDay = date.getDayOfMonth();
        String[] dateOfBirth;

        dateOfBirth = DOB.split("-|\\/");

        userDays =  Integer.parseInt(dateOfBirth[0]);
        userMonth = Integer.parseInt(dateOfBirth[1]);
        userYear = Integer.parseInt(dateOfBirth[2]);

        days = Math.abs(currentDay - userDays);
        calMonths = Math.abs(currentMonth - userMonth);
        calAge = Math.abs(currentYear - userYear);

        //Calculate age with proper months and days
        if (currentMonth <= userMonth) {
            calAge--;
            if (currentDay <= userDays) {
                calMonths = Math.abs(calMonths - 11);
                days = Math.abs(days - 31);
            } else {
                calMonths = Math.abs(calMonths - 12);
            }
        }

        if (currentMonth > userMonth) {
            if (currentDay < userDays) {
                days = Math.abs(days - 31);
                calMonths = Math.abs(calMonths - 1);
            }
        }

        if (days == 31) {
            calMonths++;
            days = 0;
        }
        if (calMonths == 12) {
            calAge++;
            calMonths = 0;
        }

        //Printing Result
        if (userYear == currentYear) {
            if (userMonth == currentMonth) {
                if (userDays > currentDay) {
                    return null;
                }
            }
            if (userMonth > currentMonth) {
                return null;
            }
            return new Age(days, calMonths, calAge);
        } else if (userYear > currentYear) {
            return null;
        } else return new Age(days, calMonths, calAge);
    }

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        boolean d = true;
        String dateOfBirth = "";

        while (d) {
            System.out.println("Enter Date of Birth in dd-mm-yyyy or dd/mm/yyyy format");
            dateOfBirth = read.next();
            if (dateOfBirth.matches("^([0-2][0-9]|(3)[0-1])(-|\\/)(((0)[0-9])|((1)[0-2]))(-|\\/)\\d{4}$"))
                break;
            System.out.println("Not in required Format");
        }

        Age age = GetUserAge(dateOfBirth);

        try {
            System.out.println(age.Print());
        } catch (NullPointerException e) {
            System.out.println("Hurray you will be born in future");
        }
    }
}
