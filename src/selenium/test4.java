package selenium;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.sikuli.basics.Debug;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

public class test4 {

    public static void main(String[] args) throws InterruptedException, FindFailed, URISyntaxException, IOException, AWTException {
        // Opening chrome with that addon
        
        /*
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src\\resources\\AdBlocker-Ultimate_v2.23.crx"));     
        options.addArguments("window-size=1000,800");
        System.setProperty("webdriver.chrome.driver", "src\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        Point point=new Point(0, 0);
        driver.manage().window().setPosition(point);
        
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("http://filehoot.com/34b9tk68z8iw");
        Thread.sleep(2000);
        // Creating object to the Sukali screen class
*/
        Desktop.getDesktop().browse(new URI("http://filehoot.com/34b9tk68z8iw"));
        Screen s=new Screen();
        System.out.println("Start searching");

        int count=1;
        boolean start=true;
        boolean start1=false;
        boolean start2=true;
        String photo1="src\\resources\\filehoot_photo1.png";
        String photo2="src\\resources\\filehoot_photo2.png";       
        String photo3="src\\resources\\filehoot_tvb1.png";
        Thread.sleep(5000);
        while(start){
            Thread.sleep(2000);
            try {
                Debug.user("Match TVB: %s", s.find(photo1));
                if (s.exists(photo1)!=null)
                {
                    s.find(photo1);
                    s.click(photo1);
                    start1=true;
                    start=false;
                }
            } catch (FindFailed ex) {
                Debug.error(ex.getMessage());
            }
        }
     
        while(start1){
            Thread.sleep(2000);
            try {
                Debug.user("Match TVB: %s", s.find(photo2));
                if (s.exists(photo2)!=null)
                {
                    s.find(photo2);
                    s.click(photo2);
                    start2=true;
                    start1=false;
                }
            } catch (FindFailed ex) {
                Debug.error(ex.getMessage());
            }
        }
    
        Robot r = new Robot();
        r.mouseMove(0, 0);
       
        int checking=2000;
        
        while(count<60){
            Thread.sleep(checking);
            try {
                Debug.user("Match TVB: %s", s.find(photo3));
                if (s.exists(photo3)!=null)
                {
                    
                    System.out.println("Found TVB logo: " +count+" times");  
                    count++;
                    checking=1000;
                }
            } catch (FindFailed ex) {
                Debug.error(ex.getMessage());
            }
        }
        System.out.println("It is TVB drama");
        
       // Pattern pattern=new Pattern("src\\resources\\testtest.png");
        //s.wait(pattern,3000);
     
        //Finding and clicking on the Addon image
  
           // s.find("src\\resources\\testtest.png");
            //s.click("src\\resources\\testtest.png");
            /*
     int count =1;
       
            while(count<100){
            System.out.println("count: "+ count);
            count ++;
            
             
            System.out.println("found TVB");
            }
            */
            
            
            
            /*
            Thread.sleep(10000);
            s.find("src\\resources\\testtest1.png");
            s.click("src\\resources\\testtest1.png");
            
            Thread.sleep(20000);
            s.find("src\\resources\\TVB.png");
            System.out.println("found TVB");
            
            Thread.sleep(2000);
            s.find("src\\resources\\TVB.png");
            System.out.println("found TVB");
            Thread.sleep(2000);
            s.find("src\\resources\\TVB.png");
            System.out.println("found TVB");
            */
   

    }
}