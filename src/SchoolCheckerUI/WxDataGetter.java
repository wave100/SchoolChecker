/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SchoolCheckerUI;

import java.io.IOException;
import net.aksingh.owmjapis.CurrentWeather;
import net.aksingh.owmjapis.DailyForecast;
import net.aksingh.owmjapis.OpenWeatherMap;
import org.json.JSONException;

/**
 *
 * @author Rish
 */
public class WxDataGetter {
    private static String ZIP;
    private static OpenWeatherMap owm = new OpenWeatherMap(OpenWeatherMap.Units.IMPERIAL, "185aded9f32e6a99e6d91f8238c855c0");
    private static DailyForecast df;
    
    public static void setZIP(String zip) throws JSONException, IOException {
        df = owm.dailyForecastByCityName(zip, (byte)1);
        ZIP = zip;
    }
    
    public static int getTemp() {
        return (int) df.getForecastInstance(0).getTemperatureInstance().getDayTemperature();
    }
    
    public static int getPrecip() {
        return (int) df.getForecastInstance(0).getSnow();
    }
    
    public static String getZIP() {
        return ZIP;
    }
    
}
