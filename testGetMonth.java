import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class testGetMonth {
int sampleDay = 12;
int sampleMonth = 2;
int sampleYear = 1999;
Date date = new Date(sampleMonth, sampleDay, sampleYear);
  @Test
  public void testTestingDay() {
    Assert.assertTrue(date.getDay() == sampleDay);
  }
  
  @Test
  public void testTestingMonth() {
    Assert.assertTrue(date.getMonth() == sampleMonth);
  }
  
  @Test
  public void testTestingYear() {
    Assert.assertTrue(date.getYear() == sampleYear);
     }
  @Test
    public void testmonthString() {
      Assert.assertTrue(date.monthString(2).equalsIgnoreCase("February"));
    }

  @Test
    public void testmonthCheck() {
      String testMonth2 = "July";
      Assert.assertTrue(date.monthValid(testMonth2) == true);
    }
}
