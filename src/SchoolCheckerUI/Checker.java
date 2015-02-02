/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SchoolCheckerUI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.awt.Toolkit;

/**
 *
 * @author Rish
 */
public class Checker {
    
    public Checker() {
        
    }
    
    public static String check(String town, String url) throws MalformedURLException, IOException {
    String text = new Scanner( new URL(url).openStream(), "UTF-8" ).useDelimiter("\\A").next();
    text = text.toLowerCase();
    town = town.toLowerCase();
    //System.out.println(text.indexOf("htvclosings"));
    //System.out.println(text.indexOf("}]}});"));
    //text = text.substring(text.indexOf("ibsys.htvclosings.init"), text.indexOf("}]}});"));
    if (town.equalsIgnoreCase("Town")) {
        return "Please enter a town.";
    }
    if (text.contains(town)) {
        //Toolkit.getDefaultToolkit().beep();
        SoundPlayer.playNotificationSound();
            return "Closed";
        } else {
            return "Open";
    }
    }
}
