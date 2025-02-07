package TestProject.TestNG_tests;

import TestProject.BrokenLinkPOM;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TestNGTest {
    WebDriver driver;
    BrokenLinkPOM blp;

    @BeforeClass
    public void Initiation(){
        Scanner sc=new Scanner(System.in);

        //     String urlhrefgetattrbt;

        System.setProperty("webdriver.chrome.driver", "D:\\Development Softwares\\chromedriver.exe");

        driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.espn.in/");
    }

    @Test (description = "Check Broken Links", priority = 1)
    public void Automation(){
        blp=new BrokenLinkPOM();

        ArrayList<String> hrefurlsstore=new ArrayList<>();

        blp.storeURLS(driver, hrefurlsstore);
        blp.calculateTime(hrefurlsstore);
    }

    @AfterClass
    public void Conclusion(){
        driver.close();
    }
}
