package Examples.DisableTestCases;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreDemo {

    @Test(priority = 1)
    public void FirstTest() {

        System.out.println("This is Test Case 1");

    }

    @Test(priority = 2)
    public void SecondTest() {

        System.out.println("This is Test Case 2");

    }

    @Ignore
    @Test(priority = 3)
    public void ThirdTest() {

        System.out.println("This is Test Case 3");

    }

    @Test(priority = 4)
    public void FourthTest() {

        System.out.println("This is Test Case 4");

    }

}
