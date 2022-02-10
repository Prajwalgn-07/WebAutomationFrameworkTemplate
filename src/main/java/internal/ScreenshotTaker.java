package internal;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotTaker {

    private final WebDriver webDriver;

    public ScreenshotTaker(WebDriver webDriver) {
        this.webDriver=webDriver;
    }

    public void captureScreenshot(String name) {
        TakesScreenshot scrShot = ((TakesScreenshot) webDriver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File("./screenshots/"+name+".png");
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


