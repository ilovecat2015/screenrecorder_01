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
public class openload_new {
    //for checking there are 404 page
    public static int main() throws InterruptedException, FindFailed, URISyntaxException, IOException, AWTException {

        Screen s = new Screen();        
        int count = 1;
        boolean start = true;
        boolean start1 = false;
        int check_sorry = 0;

        ImagePath.add("selenium.filehoot/resources");
        ImagePath.setBundlePath("");    

        Thread.sleep(5000);
        while (start) {
            System.out.println("Start searching - openload sorry logos");
            //prelim checking
            if (s.exists(new Pattern("openload_sorry.png").similar(0.9f)) != null) {
                System.out.print("found1 ");
            }else {
                System.out.print("null ");
            }
            if (s.exists(new Pattern("openload_sorry1.png").similar(0.9f)) != null) {
                System.out.println("found2 ");
            }else {
                System.out.println("null ");
            }
            System.out.println("Start searching - openload play logos");
            if (s.exists(new Pattern("openload_play.png").similar(0.8f)) != null) {
                System.out.print("found1 ");
            }else {
                System.out.print("null ");
            }
            if (s.exists(new Pattern("openload_play2.png").similar(0.8f)) != null) {
                System.out.println("found2 ");
            }else {
                System.out.println("null ");
            } 
                                            
            if (s.exists(new Pattern("openload_play.png").exact()) != null) {
                System.out.println("found openload_play logo-1.png and click it");
                System.out.println(s.exists(new Pattern("openload_play.png").exact()));
               // Debug.user("Match TVB: %s", s.find("openload_play.png"));
                s.find("openload_play.png");
                s.click("openload_play.png");
                start1 = true;
                start = false;
                Thread.sleep(2000);
            }                        
                     
            if (s.exists(new Pattern("openload_sorry.png").exact()) != null) {
                System.out.println("found openload_sorry logo-1.png");
                System.out.println(s.exists(new Pattern("openload_sorry.png").exact()));
                s.mouseMove("openload_sorry.png");
                start1 = false;
                start = false;
                check_sorry = 1;
                Thread.sleep(2000);
            }
             
            if (s.exists(new Pattern("openload_sorry1.png").exact()) != null) {
                System.out.println("found openload_sorry logo-2.png");
                System.out.println(s.exists(new Pattern("openload_sorry1.png").exact()));
                s.mouseMove("openload_sorry1.png");
                start1 = false;
                start = false;
                check_sorry = 1;
                Thread.sleep(2000);
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
           
            System.out.println("Start searching - openload play logos"); 
            Thread.sleep(2000);
            if (s.exists(new Pattern("openload_play2.png").similar(0.9f)) != null) {
                System.out.println("found2 ");
            }else {
                System.out.println("null ");
            }

            if (s.exists(new Pattern("openload_play2.png")) != null) {
                System.out.println("found openload_play logo-2.png and click it");
                System.out.println(s.exists(new Pattern("openload_play2.png")));                
                s.find("openload_play2.png");
                s.click("openload_play2.png");
                start1 = false;
                Thread.sleep(2000);
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
