/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SchoolCheckerUI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Rish
 */
public class SoundPlayer {
    
    static InputStream soundInStream;
    static AudioStream soundAudioStream;
    
    static final String PATH_TO_NOTIFICATION_SOUND = System.getProperty("user.home") + System.getProperty("file.separator") + ".schoolchecker" + System.getProperty("file.separator") + "sounds" + System.getProperty("file.separator") + "notify.wav";
    
    public static void playNotificationSound() throws FileNotFoundException, IOException {
        soundInStream = new FileInputStream(PATH_TO_NOTIFICATION_SOUND);
        soundAudioStream = new AudioStream(soundInStream);
        AudioPlayer.player.start(soundAudioStream);
    }
    
    public static void playErrorSound() {
        //TO BE ADDED
        throw new java.lang.UnsupportedOperationException("PlayErrorSound method not yet implemented.");
    }
}
