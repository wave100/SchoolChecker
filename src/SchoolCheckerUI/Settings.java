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

//    public Settings() {
//        System.out.println(SETTINGS_FILE.getAbsolutePath());
//        if (!SETTINGS_FILE.exists()) {
//            SETTINGS_FILE.getParentFile().mkdirs();
//            try {
//                SETTINGS_FILE.createNewFile();
//            } catch (IOException ex) {
//                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
//            }
//
//            properties.setProperty("filler", "filler");
//
//            try {
//                FileDownloader.downloadFile(System.getProperty("user.home") + System.getProperty("file.separator") + ".schoolchecker" + System.getProperty("file.separator") + "sounds" + System.getProperty("file.separator") + "notify.wav", new URL("http://rishshadra.me/schoolchecker/notify.wav"));
//            } catch (IOException ex) {
//                Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        try {
//            propertiesReader = new BufferedReader(new FileReader(SETTINGS_FILE));
//            propertiesWriter = new PrintWriter(SETTINGS_FILE);
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        try {
//            properties.store(propertiesWriter, "SchoolChecker Persistence File");
//        } catch (IOException ex) {
//            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        try {
//            properties.load(propertiesReader);
//        } catch (IOException ex) {
//            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    
    public Settings() {
        try {
            if (!SETTINGS_FILE.exists()) {
                isFirstRun = true;
                firstRun();
                SETTINGS_FILE.getParentFile().mkdirs();
                SETTINGS_FILE.createNewFile();
            }
            propertiesWriter = new PrintWriter(SETTINGS_FILE);
            propertiesReader = new FileInputStream(SETTINGS_FILE);
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void writeConfig(String t, String U) throws IOException {
        properties.store(propertiesWriter, "SchoolChecker Persistence Data");
    }

    public String getConfigURL() {
        return properties.getProperty("URL");
    }

    public String getConfigTown() {
        return properties.getProperty("town");
    }

    public void setConfigURL(String U) {
        properties.setProperty("URL", U);
    }

    public void setConfigTown(String T) {
        properties.setProperty("town", T);
    }

    public void firstRun() throws MalformedURLException, IOException {
        FileDownloader.downloadFile(System.getProperty("user.home") + System.getProperty("file.separator") + ".schoolchecker" + System.getProperty("file.separator") + "sounds" + System.getProperty("file.separator") + "notify.wav", new URL("http://rishshadra.me/schoolchecker/notify.wav"));
        properties.setProperty("URL", "");
        properties.setProperty("town", "");
    }
}
