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

/**
 *
 * @author Rish
 */
public class UpdateChecker {
    public static boolean checkUpdate() throws MalformedURLException, IOException {
        System.out.println("Checking for update... ");
        return SchoolChecker.VERSION < Integer.valueOf(new Scanner(new URL("http://rishshadra.me/schoolchecker/updater/version.txt").openStream(), "UTF-8").useDelimiter("\\A").next());
    }
    
    public static void update() throws IOException {
        System.out.println("Updating program... ");
        System.out.println("Running command: " + "java -jar " + System.getProperty("user.home") + System.getProperty("file.separator") + ".schoolchecker" + System.getProperty("file.separator") + "update" + System.getProperty("file.separator") + "Updater.jar");
        Runtime.getRuntime().exec("java -jar " + System.getProperty("user.home") + System.getProperty("file.separator") + ".schoolchecker" + System.getProperty("file.separator") + "update" + System.getProperty("file.separator") + "Updater.jar");
        System.exit(0);
    }
}
