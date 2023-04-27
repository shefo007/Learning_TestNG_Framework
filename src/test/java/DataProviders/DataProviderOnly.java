package DataProviders;

import org.testng.annotations.DataProvider;

public class DataProviderOnly {

    @DataProvider(name = "input-provider")
    public static Object[][] inputData() {
        Object[][] data = new Object[2][3];

        data[0][0] = "Sherif Abdallah";
        data[0][1] = "Test Automation Engineer";
        data[0][2] = 6500;

        data[1][0] = "Ali Ahmed";
        data[1][1] = "Web Developer";
        data[1][2] = 7500;
        return data;
    }
}
