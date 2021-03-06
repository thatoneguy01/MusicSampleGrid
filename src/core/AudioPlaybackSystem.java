package core;

import gui.Button;
import gui.SampleAction;
import gui.SampleButton;
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

//    public static void loadClip(String alias, File file)
//    {
//        URL url = null;
//        try {
//            url= file.toURI().toURL();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        Main.soundSystem.loadSound(url, alias);
//        Main.soundSystem.newSource(false, alias, url, alias, false, 0, 0, 0, SoundSystemConfig.ATTENUATION_NONE, SoundSystemConfig.getDefaultRolloff());
//        System.out.println("Sound loaded.");
//    }

    public static Clip createJSClip(File inputFile)
    {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(inputFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            return clip;
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void playJSClip(Clip clip)
    {
        if (clip.isRunning())
        {
            clip.stop();
        }
        clip.setFramePosition(0);
        clip.start();
    }

    public static void stopJSClip(Clip clip)
    {
        if (clip.isRunning())
            clip.stop();
        clip.setFramePosition(0);
    }

//    public static void playClip(String alias)
//    {
//        Main.soundSystem.stop(alias);
//        Main.soundSystem.rewind(alias);
//        Main.soundSystem.play(alias);
//    }

    public static Clip clone(SampleButton source) {
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(((SampleAction)source.getPressAction()).getSoundFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            return clip;
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setVolume(Clip clip, float percent)
    {
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float volMax = volume.getMaximum();
        float volMin = volume.getMinimum();
        float volVal = ((volMax - volMin) * percent) + volMin;
        volume.setValue(volVal);
    }

    public static float getVolPercent(Clip clip)
    {
        FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        float volLevel = volume.getValue();
        float volMax = volume.getMaximum();
        float volMin = volume.getMinimum();
        float percent = (volLevel - volMin)/(volMax - volMin);
        return percent;
    }

}
