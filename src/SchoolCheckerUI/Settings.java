/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SchoolCheckerUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rish
 */
public class Settings {

    String URL;
    String town;
    boolean isFirstRun = false;
    
    Properties properties = new Properties();

    final File SETTINGS_FILE = new File(System.getProperty("user.home") + System.getProperty("file.separator") + ".schoolchecker" + System.getProperty("file.separator") + "persistence.properties");
    FileInputStream propertiesReader;
    PrintWriter propertiesWriter;

    
    public Settings() {
        try {
            if (!SETTINGS_FILE.exists()) {
                System.out.println("First run detected");
                isFirstRun = true;
                firstRun();
                SETTINGS_FILE.getParentFile().mkdirs();
                SETTINGS_FILE.createNewFile();
            }
            
            propertiesReader = new FileInputStream(SETTINGS_FILE);
            properties.load(propertiesReader);
            propertiesReader.close();
            
            propertiesWriter = new PrintWriter(SETTINGS_FILE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(properties.getProperty("URL"));
        
    }

    public void writeConfig() throws IOException {
        propertiesWriter.close();
        propertiesReader.close();
        boolean deleted = SETTINGS_FILE.delete();
        propertiesWriter = new PrintWriter(SETTINGS_FILE);
        propertiesReader = new FileInputStream(SETTINGS_FILE);
        SETTINGS_FILE.createNewFile();
        properties.store(propertiesWriter, "SchoolChecker Persistence Data");
        System.out.println("Wrote Config (overwrite: " + deleted + ")");
    }

    public String getConfigURL() {
        System.out.println(properties.getProperty("URL") + " returned from getConfigURL");
        return properties.getProperty("URL");
    }

    public String getConfigTown() {
        System.out.println(properties.getProperty("town") + " returned from getConfigTown");
        return properties.getProperty("town");
    }

    public void setConfigURL(String U) {
        System.out.println(U + " set as config URL");
        properties.setProperty("URL", U);
    }

    public void setConfigTown(String T) {
        System.out.println(T + " set as config town");
        properties.setProperty("town", T);
    }

    public void firstRun() throws MalformedURLException, IOException {
        FileDownloader.downloadFile(System.getProperty("user.home") + System.getProperty("file.separator") + ".schoolchecker" + System.getProperty("file.separator") + "sounds" + System.getProperty("file.separator") + "notify.wav", new URL("http://rishshadra.me/schoolchecker/notify.wav"));
        properties.setProperty("URL", "");
        properties.setProperty("town", "");
    }
    
    public void closeStreams() {
        try {
            propertiesReader.close();
            propertiesWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("Streams Closed");
        
    }
}
