package TestProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinkPOM {

    public void storeURLS(WebDriver obj,ArrayList<String> hrefurlsstore){
        String urlhrefgetattrbt;

        //using List<> to colectively store all the url links in the url_links object.
        List<WebElement> url_links=obj.findElements(By.tagName("a")); //tag "a" refers to hyperlinks in the designated webpage
    //    ArrayList<String> hrefurlsstore=new ArrayList<>();

        System.out.println("Total no. of url links: "+url_links.size());

        //using for-each loop to check the href tags in them (url_links), and then store them in the urlhrefgetattrbt variable.
        //after the href checking, all the urls are stored in hrefurlsstore arraylist object.
        for (WebElement filterhreflink:url_links){
            urlhrefgetattrbt=filterhreflink.getAttribute("href");

            hrefurlsstore.add(urlhrefgetattrbt);
        }
    }

    public void calculateTime(ArrayList<String> hrefurlsstore){
        long start_t, end_t, time_diff,mil_to_sec;

        start_t=System.currentTimeMillis();
        hrefurlsstore.parallelStream().forEach(BrokenLinkPOM::verifyBrokenUrls); // url links stored in hrefurlsstore here are passed to the url variable one at a time via forEach()
        // , and from there, to the verifyBrokenUrlSeqPar(url) method.
        end_t=System.currentTimeMillis();

        time_diff= end_t-start_t;
        mil_to_sec=time_diff/1000;

        System.out.println("\n\nTotal time taken in parallel execution: "+ mil_to_sec+" seconds");

    }

    // checking for broken links sequencially/parallely.
    public static void verifyBrokenUrls(String urlLink){

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
}
