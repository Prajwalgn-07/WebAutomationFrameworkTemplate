package listeners;


import base.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult arg0) {
        takeScreenShotOnTestFailure(arg0);
    }
}
