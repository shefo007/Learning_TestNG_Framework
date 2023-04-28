package Examples.DisableTestCases;

import org.testng.annotations.Test;

public class TestNGDisableDemo {

    @Test(priority = 3)
    public static void FirstTest() {
        System.out.println("This is Test Case 1, but after priority Test Case 3");
    }

    @Test(priority = 4)
    public static void SecondTest() {
        System.out.println("This is Test Case 2, but after priority Test Case 4");
    }

    @Test(priority = 2, enabled = false)
    public static void ThirdTest() {
        System.out.println("This is Test Case 3, but now skipped");
    }

    @Test(priority = 1)
    public static void FourthTest() {
        System.out.println("This is Test Case 4, but after priority Test Case 1");
    }
}
