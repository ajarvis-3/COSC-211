
import java.util.Scanner;

public class Date {
  private String month;
  private int day;
  private int year; // a four digit number.
  
  public Date() {
    month = "January";
    day = 1;
    year = 1000;
  }

  public Date(int monthInt, int day, int year) {
    setDate(monthInt, day, year);
  }

  public Date(String monthString, int day, int year) {
    setDate(monthString, day, year);
  }

  public Date(int year) {
    setDate(1, 1, year);
  }

  public Date(Date aDate) {
    if (aDate == null)// Not a real date.
    {
      System.out.println("Fatal Error.");
      System.exit(0);
    }

    month = aDate.month;
    day = aDate.day;
    year = aDate.year;
  }

  public void setDate(int monthInt, int day, int year) {
    if (dateOK(monthInt, day, year)) {
      this.month = monthString(monthInt);
      this.day = day;
      this.year = year;
    } else {
      System.out.println("Fatal Error");
      System.exit(0);
    }
  }

  public void setDate(String monthString, int day, int year) {
    if (dateOK(monthString, day, year)) {
      this.month = monthString;
      this.day = day;
      this.year = year;
    } else {
      System.out.println("Fatal Error");
      System.exit(0);
    }
  }

  public void setDate(int year) {
    setDate(1, 1, year);
  }

  public void setYear(int year) {
    if ((year < 1000) || (year > 9999)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      this.year = year;
  }

  public void setMonth(int monthNumber) {
    if ((monthNumber <= 0) || (monthNumber > 12)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      month = monthString(monthNumber);
  }

  public void setDay(int day) {
    if ((day <= 0) || (day > 31)) {
      System.out.println("Fatal Error");
      System.exit(0);
    } else
      this.day = day;
  }

 public int getMonth() {
    return switch (month) {
    case "January" -> 1; 
    case "February" -> 2;
    case "March" -> 3;
    case "April" -> 4;
    case "May" -> 5;
    case "June" -> 6;
    case "July" -> 7;
    case "August" -> 8;
    case "September" -> 9;
    case "October" -> 10;
    case "November" -> 11;
    case "December" -> 12;
    default -> {
      System.out.println("Fatal Error");
      System.exit(0);
      yield 0;
    }
    
    }; 
  }

  public int getDay() {
    return day;
  }

  public int getYear() {
    return year;
  }

  public String toString() {
    return (month + " " + day + ", " + year);
  }

  public boolean equals(Date otherDate) {
    return ((month.equals(otherDate.month)) && (day == otherDate.day) && (year == otherDate.year));
  }

  public boolean precedes(Date otherDate) {
    return ((year < otherDate.year) || (year == otherDate.year && getMonth() < otherDate.getMonth())
        || (year == otherDate.year && month.equals(otherDate.month) && day < otherDate.day));
  }

  public void readInput() {
    var tryAgain = true;
    var keyboard = new Scanner(System.in);
    while (tryAgain) {
      System.out.println("Enter month, day, and year.");
      System.out.println("Do not use a comma.");
      String monthInput = keyboard.next();
      var dayInput = keyboard.nextInt();
      var yearInput = keyboard.nextInt();
      if (dateOK(monthInput, dayInput, yearInput)) {
        setDate(monthInput, dayInput, yearInput);
        tryAgain = false;
      } else
        System.out.println("Illegal date. Reenter input.");
    }
  }

  private boolean dateOK(int monthInt, int dayInt, int yearInt) {
    return ((monthInt >= 1) && (monthInt <= 12) && (dayInt >= 1) && (dayInt <= 31)
        && (yearInt >= 1000) && (yearInt <= 9999));
  }

  private boolean dateOK(String monthString, int dayInt, int yearInt) {
    return (monthValid(monthString) && (dayInt >= 1) && (dayInt <= 31) && (yearInt >= 1000)
        && (yearInt <= 9999));
  }

  public boolean monthValid(String month) {
    return switch (month) {
    case "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" -> true;
    default -> false;
  };
  }

  public String monthString(int monthNumber) {
    return switch (monthNumber) {
      case 1 -> "January";
      case 2 -> "February";
      case 3 -> "March";
      case 4 -> "April";
      case 5 -> "May";
      case 6 -> "June";
      case 7 -> "July";
      case 8 -> "August";
      case 9 -> "September";
      case 10 -> "October";
      case 11 -> "November";
      case 12 -> "December";
      default -> {
        System.out.println("Fatal Error");
        System.exit(0);
        yield "Error"; // to keep the compiler happy
    }
  };
}
}
    
   
/*return switch (month) {
case 1 -> "January";
case 2 -> "February";
case 3 -> "March";
case 4 -> "April";
case 5 -> "May";
case 6 -> "June";
case 7 -> "July";
case 8 -> "August";
case 9 -> "September";
case 10 -> "October";
case 11 -> "November";
case 12 ->  "December";
default -> ; *

};
 /* //return 1;
//else if (month.equals("February"))
  //return 2;
//else if (month.equalsIgnoreCase("March"))
  //return 3;
//else if (month.equalsIgnoreCase("April"))
  //return 4;
//else if (month.equalsIgnoreCase("May"))
  //return 5;
// else if (month.equals("June"))
  //return 6;
//else if (month.equalsIgnoreCase("July"))
  //return 7;
//else if (month.equalsIgnoreCase("August"))
  //return 8;
//else if (month.equalsIgnoreCase("September"))
  return 9;
else if (month.equalsIgnoreCase("October"))
  return 10;
else if (month.equals("November"))
  return 11;
else if (month.equals("December"))
  return 12;
else {
  System.out.println("Fatal Error");
  System.exit(0);
  return 0; // Needed to keep the compiler happy
} **/
