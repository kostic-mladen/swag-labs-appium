package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import pages.LoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SwagLabsLoginTest {

    private AppiumDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setDeviceName("emulator_5554")     // ime emulatora iz AVD managera
                .setAvd("Pixel_6")            // Appium automatski pokreće emulator
                .setAvdLaunchTimeout(Duration.ofSeconds(120)) // čekaj do 2 min da se podigne
                .setApp("D:\\Demo\\swag-labs-appium\\apps\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk")
                .setAppPackage("com.swaglabsmobileapp")
                .setAppActivity("com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");

        // verify that login succeeded
        boolean isProductsVisible = driver.findElement(
                By.xpath("//android.widget.TextView[@text='PRODUCTS']")
        ).isDisplayed();

        assert isProductsVisible : "Products page not visible after login!";
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
