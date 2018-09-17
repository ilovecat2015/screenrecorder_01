/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.sikuli.basics.Debug;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

/**
 *
 * @author Jonathan
 */
public class all {

    public static void main(String[] args) throws InterruptedException, FindFailed, URISyntaxException, IOException, AWTException {

        //Desktop.getDesktop().browse(new URI("https://openload.co/f/18JNPiEi85k"));
        //Debug.on(3);
        Screen s = new Screen();
        System.out.println("Start searching");
        int count = 1;
        boolean start = true;
        boolean start1 = false;

        ImagePath.add("selenium.filehoot/resources");
        //System.out.println(ImagePath.getBundleFolder());
        ImagePath.setBundlePath("");
        System.out.println(ImagePath.getBundleFolder());

        Thread.sleep(5000);
        while (start) {
            //Thread.sleep(1000);
            System.out.println("searching1");
            System.out.println((s.exists(new Pattern("openload_play.png").exact())));
            System.out.println(new Pattern("openload_play.png").getFileURL());
            System.out.println(s.exists(new Pattern("openload_play.png").similar(0.9f)));
            System.out.println(new Pattern("openload_play.png").getFileURL());

            System.out.println((s.exists(new Pattern("openload_play2.png").exact())));
            System.out.println(new Pattern("openload_play2.png").getFileURL());
            System.out.println(s.exists(new Pattern("openload_play2.png").similar(0.9f)));
            System.out.println(new Pattern("openload_play2.png").getFileURL());
            
            if (s.exists(new Pattern("openload_play.png").exact()) != null) {
                System.out.println("openload_play.png");
                Debug.user("Match TVB: %s", s.find("openload_play.png"));
                s.find("openload_play.png");
                s.click("openload_play.png");
                start1 = true;
                start = false;
            }
            /*
                if (s.exists( new Pattern("filehoot_filenotfound.png"))!=null)
                {
                     System.err.println("File Not Found");
                    Debug.user("Match TVB: %s", s.find("filehoot_filenotfound.png"));
                    s.find("filehoot_filenotfound.png");
                 start1=false;
                    start=false;
                }*/

            count++;
            if (count > 2) {
                System.out.println("Checked count: " + count + "(if loop more than 10, it will start recording and go to the next link)");
                if (count >= 10) {
                    start = false;
                }
            }

        }
        count = 0;
        while (start1) {

            Thread.sleep(2000);
            System.out.println("searching2");

            System.out.println((s.exists(new Pattern("openload_play2.png").exact())));
            System.out.println(new Pattern("openload_play2.png").getFileURL());

            if (s.exists(new Pattern("openload_play2.png")) != null) {
                System.out.println("find play button");
                Debug.user("Match TVB: %s", s.find("openload_play2.png"));
                s.find("openload_play2.png");
                s.click("openload_play2.png");
                //start2=true;
                start1 = false;
            }
            count++;
            if (count > 2) {
                System.out.println("Checked count: " + count + "(if loop more than 10, it will start recording and go to the next link)");
                if (count >= 5) {
                    start1 = false;
                }
            }

        }

        Robot r = new Robot();
        r.mouseMove(0, 0);
        /*
        int checking=1000;
        
        while(count<5){
            Thread.sleep(checking);
            System.out.println(count);
            count++;
            try {
                Debug.user("Match TVB: %s"+count, s.find(photo3));
                if (s.exists(photo3)!=null)
                {
                    System.out.println("Found TVB logo: " +count+" times");  
                    checking=1000;
                }

            } catch (FindFailed ex) {
                Debug.error(ex.getMessage());
            }
        }
        System.out.println("It is TVB drama");

         */

    }

    //for checking there are 404 page
    public static int main() throws InterruptedException, FindFailed, URISyntaxException, IOException, AWTException {

        Screen s = new Screen();
        System.out.println("Start searching - openload play and sorry logos");
        int count = 1;
        boolean start = true;
        boolean start1 = false;
        int check_sorry = 0;

        ImagePath.add("selenium.filehoot/resources");
        ImagePath.setBundlePath("");    

        Thread.sleep(5000);
        while (start) {
            //prelim checking
            if (s.exists(new Pattern("openload_sorry.png").similar(0.9f)) != null) {
                System.out.print("found sorry1");
            }else {
                System.out.print("null ");
            }
            if (s.exists(new Pattern("openload_sorry1.png").similar(0.9f)) != null) {
                System.out.print("found sorry2");
            }else {
                System.out.print("null ");
            }
            if (s.exists(new Pattern("openload_play.png").similar(0.9f)) != null) {
                System.out.print("found play");
            }else {
                System.out.print("null ");
            }
            if (s.exists(new Pattern("openload_play2.png").similar(0.9f)) != null) {
                System.out.print("found play2");
            }else {
                System.out.print("null ");
            } 
                                            
            if (s.exists(new Pattern("openload_play.png").exact()) != null) {
                System.out.println("openload_play.png");
                Debug.user("Match TVB: %s", s.find("openload_play.png"));
                s.find("openload_play.png");
                s.click("openload_play.png");
                start1 = true;
                start = false;
            }                        
                     
            if (s.exists(new Pattern("openload_sorry.png").exact()) != null) {
                System.out.println("Found openload_sorry logo-1.png");
                System.out.println(s.exists(new Pattern("openload_sorry.png").exact()));
                s.mouseMove("openload_sorry.png");
                start1 = false;
                start = false;
                check_sorry = 1;
            }
             
            if (s.exists(new Pattern("openload_sorry1.png").exact()) != null) {
                System.out.println("Found openload_sorry logo-2.png");
                System.out.println(s.exists(new Pattern("openload_sorry1.png").exact()));
                s.mouseMove("openload_sorry1.png");
                start1 = false;
                start = false;
                check_sorry = 1;
            }
            count++;
            if (count > 2) {
                if (count >= 4) {
                    start = false;
                }
            }

        }
        count = 0;
        //coz openload have two play buttons
        while (start1) {
            Thread.sleep(2000);
            System.out.println("Start searching - openload play logos");
                      
            if (s.exists(new Pattern("openload_play2.png").similar(0.9f)) != null) {
                System.out.print("found play2");
            }else {
                System.out.print("null ");
            }

            if (s.exists(new Pattern("openload_play2.png")) != null) {
                System.out.println("find play2 button");
                System.out.println(s.exists(new Pattern("openload_play2.png")));                
                s.find("openload_play2.png");
                s.click("openload_play2.png");
                start1 = false;
            }
            count++;
            if (count > 2) {
                if (count >= 4) {
                    start1 = false;
                }
            }
        }
        Robot r = new Robot();
        r.mouseMove(0, 0);

        if (check_sorry == 0) {
            System.out.println("Can't find openload sorry logo and it will still start recording");
            System.out.println("");
        } else if (check_sorry == 1) {
            System.out.println("Found openload sorry logo");
            System.out.println("");
        } else {
            System.err.println("Error");
            System.out.println("");
        }
        return check_sorry;
    }
}
