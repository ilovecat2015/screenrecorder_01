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
public class tvb {

    public static void main(String[] args) throws InterruptedException, FindFailed, URISyntaxException, IOException, AWTException {

        //Desktop.getDesktop().browse(new URI("http://filehoot.com/34b9tk68z8iw"));
        //Debug.on(3);
        Screen s=new Screen();
        //System.out.println("Start searching");
        boolean count=true;
        int count_tvb=1;
        int count_notvb=1;
        

        ImagePath.add("selenium.filehoot/resources");
        //System.out.println(ImagePath.getBundleFolder());
        ImagePath.setBundlePath("");
        //System.out.println(ImagePath.getBundleFolder());
        System.out.println("searching TVB logo");
        while(count){
            
            try{
 
                if (s.exists( new Pattern("tvb1.png").similar(0.65f))!=null)
                {
                    
                     System.err.println("Found TVB logo1: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb1.png").similar(0.65f)));
                    //Debug.user("Match TVB: %s", s.find("tvb7.png"));
                    s.find("tvb1.png");
                    count_tvb++;
                }
               else if (s.exists(new Pattern("tvb2.png").similar(0.65f))!=null)
                {
                     
                     System.err.println("Found TVB logo1: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb2.png").similar(0.65f)));
                    //Debug.user("Match TVB: %s", s.find("tvb2.png"));
                    //s.find("tvb2.png");
                    count_tvb++;
                }
 
                
                else if (s.exists( new Pattern("tvb3.png").similar(0.65f))!=null)
                {
                    
                     System.err.println("Found TVB logo2: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb3.png").similar(0.65f)));
                    //Debug.user("Match TVB: %s", s.find("tvb3.png"));
                    s.find("tvb3.png");
                    count_tvb++;
                }
                else if (s.exists( new Pattern("tvb4.png").similar(0.65f))!=null)
                {
                    
                     System.err.println("Found TVB logo3: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb4.png").similar(0.65f)));
                   // Debug.user("Match TVB: %s", s.find("tvb4.png"));
                    s.find("tvb4.png");
                    count_tvb++;
                }
                else if (s.exists( new Pattern("tvb5.png").similar(0.65f))!=null)
                {
                    
                     System.err.println("Found TVB logo4: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb5.png").similar(0.65f)));
                    //Debug.user("Match TVB: %s", s.find("tvb5.png"));
                    s.find("tvb5.png");
                    count_tvb++;
                }
                else if (s.exists( new Pattern("tvb6.png").similar(0.65f))!=null)
                {
               
                     System.err.println("Found TVB logo5: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb6.png").similar(0.65f)));
                    //Debug.user("Match TVB: %s", s.find("tvb6.png"));
                    s.find("tvb6.png");
                    count_tvb++;
                }

                
                else
                {
                System.err.println("Can't find TVB logo: "+count_notvb);
                count_notvb++;
                }

                     if (count_notvb==3){
                count=false;
                } else if (count_tvb==3)
                {count=false;
                } else
                {
                    count=true;
                }


                     
                     
                       }catch(FindFailed e)
        {e.printStackTrace();
        }
        }



  
        if (count_notvb==3){
        System.out.println("Can't find TVB logo");
        } else if (count_tvb==3){
        System.out.println("found TVB logo");
    } else {
            System.err.println("Error");
        }
    
    }
    
       public static int main() throws InterruptedException, FindFailed, URISyntaxException, IOException, AWTException {

        //Desktop.getDesktop().browse(new URI("http://filehoot.com/34b9tk68z8iw"));
        //Debug.on(3);
        Screen s=new Screen();
        //System.out.println("Start searching");
        boolean count=true;
        int count_tvb=1;
        int count_notvb=1;

        ImagePath.add("selenium.filehoot/resources");
        //System.out.println(ImagePath.getBundleFolder());
        ImagePath.setBundlePath("");
        //System.out.println(ImagePath.getBundleFolder());
        System.out.println("Searching TVB logo");
        while(count){
            
            try{
                
                if (s.exists( new Pattern("tvb1.png").similar(0.65f))!=null)
                {
                    
                     System.err.println("Found TVB logo1: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb1.png").similar(0.65f)));
                    //Debug.user("Match TVB: %s", s.find("tvb7.png"));
                    s.find("tvb1.png");
                    count_tvb++;
                }
                                
                else if (s.exists(new Pattern("tvb2.png").similar(0.65f))!=null)
                {
                     
                     System.err.println("Found TVB logo2: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb2.png").similar(0.65f)));
                    //Debug.user("Match TVB: %s", s.find("tvb2.png"));
                    //s.find("tvb2.png");
                    count_tvb++;
                }
 
                
                else if (s.exists( new Pattern("tvb3.png").similar(0.65f))!=null)
                {
                    
                     System.err.println("Found TVB logo3: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb3.png").similar(0.65f)));
                    //Debug.user("Match TVB: %s", s.find("tvb3.png"));
                    s.find("tvb3.png");
                    count_tvb++;
                }
                else if (s.exists( new Pattern("tvb4.png").similar(0.65f))!=null)
                {
                    
                     System.err.println("Found TVB logo4: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb4.png").similar(0.65f)));
                   // Debug.user("Match TVB: %s", s.find("tvb4.png"));
                    s.find("tvb4.png");
                    count_tvb++;
                }
                else if (s.exists( new Pattern("tvb5.png").similar(0.65f))!=null)
                {
                    
                     System.err.println("Found TVB logo5: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb5.png").similar(0.65f)));
                    //Debug.user("Match TVB: %s", s.find("tvb5.png"));
                    s.find("tvb5.png");
                    count_tvb++;
                }
                else if (s.exists( new Pattern("tvb6.png").similar(0.65f))!=null)
                {
               
                     System.err.println("Found TVB logo6: "+count_tvb);
                     System.out.println(s.exists(new Pattern("tvb6.png").similar(0.65f)));
                    //Debug.user("Match TVB: %s", s.find("tvb6.png"));
                    s.find("tvb6.png");
                    count_tvb++;
                }

                
                else
                {
                System.err.println("Can't find TVB logo: "+count_notvb);
                count_notvb++;
                }

                if (count_notvb==3){
                count=false;
                } else if (count_tvb==3)
                {count=false;
                } else
                {
                    count=true;
                }
                

                       }catch(FindFailed e)
        {e.printStackTrace();
        }
        }
        int check_block = 0;
                if (count_notvb==3){
        System.out.println("Can't find TVB logo");
        check_block=1;
        } else if (count_tvb==3){
        System.out.println("found TVB logo");
        check_block=2;
    } else {
            System.err.println("Error");
        }
        
        
    return check_block;
    } 
    
    
}
