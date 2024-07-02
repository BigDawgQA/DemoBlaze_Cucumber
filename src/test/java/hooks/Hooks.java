package hooks;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    WebDriver driver;
    Properties p;

    @Before
    public void setup() throws IOException {

        driver = BaseClass.initializeBrowser();
        assert driver != null;

        p = BaseClass.getProperties();
        driver.get(p.getProperty("appURL"));
        driver.manage().window().maximize();

    }

    //Un-comment to add screenshot
    @AfterStep
    public void takeScreenshots(Scenario scenario) throws IOException {

        TakesScreenshot ts = (TakesScreenshot) BaseClass.getDriver();
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        String scname = ".\\screenshots\\" + scenario.getName() + "_" + BaseClass.getTimeStamp() + ".png";
        File targetFile = new File(scname);

        FileHandler.copy(sourceFile, targetFile);
    }


    @After
    public void closeBrowser(Scenario scenario){

        driver.quit();
    }



}
