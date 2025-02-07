package TestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class testMain {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc=new Scanner(System.in);

   //     String urlhrefgetattrbt;

        System.setProperty("webdriver.chrome.driver", "D:\\Development Softwares\\chromedriver.exe");

        WebDriver driver=new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.get("https://www.espn.in/");

        BrokenLinkPOM blp=new BrokenLinkPOM();

        ArrayList<String> hrefurlsstore=new ArrayList<>();

        blp.storeURLS(driver, hrefurlsstore);
        blp.calculateTime(hrefurlsstore);

       // Thread.sleep(5000);
        driver.close();
    }

    // checking for broken links sequencially/parallely.
 /*    public static void verifyBrokenUrls(String urlLink){

        if (urlLink == null || urlLink.isEmpty()) {
            System.out.println("Skipping null or empty URL");
            return;
        }

        try{
            HttpURLConnection huc;

            //converting String urlLink to URI

            URI uri = new URI(urlLink);

            //converting URI to URL
            URL url=uri.toURL();

            huc = (HttpURLConnection) url.openConnection();

           huc.setConnectTimeout(6000);

            huc.connect();

            if (huc.getResponseCode()<400){
                System.out.println(urlLink+" --- "+huc.getResponseMessage()+" ----> (Good URL)");
            }
            else{
                System.out.println(urlLink+" --- "+huc.getResponseMessage()+" ----> (Broken URL)");

            }

        } catch (MalformedURLException e) {
            System.out.println(urlLink+ " --- Malformed URL ---> (Skipping)");
        }catch (SocketTimeoutException e){
            System.out.println(urlLink+ " --- Connection Timeout ---> (Possibly Broken)");
        }catch (IOException e){
            System.out.println(urlLink+ " --- IO Exception: "+e.getMessage()+" ---> (Possible Network Issue)");
        }catch (Exception e){
            System.out.println(urlLink+ " --- Exception: "+e.getMessage()+" ---> Error Occurred");
        }

    }

  */
}
