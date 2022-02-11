package base;

import drivers.DriverCreator;
import internal.ScreenShotTaker;
import listeners.EventCapture;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;


public class BaseTest {
    private EventFiringWebDriver webDriver;


    private WebDriver driverSetUp(){
        //default driver is chrome
        WebDriver Driver= new DriverCreator().createDriverContext(System.getProperty("browser")).create();
        webDriver = new EventFiringWebDriver(Driver);
        EventCapture eventCapture = new EventCapture();
        webDriver.register(eventCapture);
        return webDriver;
    }
    protected void takeScreenShotOnTestFailure(ITestResult iTestResult){
        new ScreenShotTaker(webDriver).captureScreenshot(iTestResult.getTestName());
    }

}
