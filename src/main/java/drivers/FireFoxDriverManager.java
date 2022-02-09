package drivers;


import internal.Toggles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverManager implements DriverManager<WebDriver> {
    @Override
    public WebDriver create() {
        if(Toggles.HEADLESS.isOn()) {
            return createHeadlessFirefoxDriver();
        }
        return new io.github.bonigarcia.wdm.managers.FirefoxDriverManager().create();
    }

    private WebDriver createHeadlessFirefoxDriver() {
        new io.github.bonigarcia.wdm.managers.FirefoxDriverManager().setup();
        FirefoxOptions firefoxOptions=getHeadlessFireFoxOptions();
        return new FirefoxDriver(firefoxOptions);
    }

    private FirefoxOptions getHeadlessFireFoxOptions() {
        FirefoxOptions firefoxOptions=new FirefoxOptions();
        firefoxOptions.setHeadless(true);
        return firefoxOptions;
    }
}
