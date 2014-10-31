package core;

import paulscode.sound.SoundSystemConfig;

import javax.sound.sampled.*;
import javax.sound.sampled.LineEvent.Type;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


/**
 * Created by Daniel on 10/25/2014.
 */
public class AudioPlaybackSystem
{

    public static void loadClip(String alias, File file)
    {
        URL url = null;
        try {
            url= file.toURI().toURL();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Main.soundSystem.loadSound(url, alias);
        Main.soundSystem.newSource(false, alias, url, alias, false, 0, 0, 0, SoundSystemConfig.ATTENUATION_NONE, SoundSystemConfig.getDefaultRolloff());
        System.out.println("Sound loaded.");
    }

    public static void playClip(String alias)
    {
        Main.soundSystem.stop(alias);
        Main.soundSystem.rewind(alias);
        Main.soundSystem.play(alias);
    }
}
