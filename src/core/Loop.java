package core;

import javax.sound.sampled.Clip;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Daniel on 11/12/14.
 */
public class Loop implements Runnable {

    private Clip[] clips;
    private boolean looping = false;

    public Loop()
    {
        clips = new Clip[16];
    }

    public void addSound(int index, Clip sound)
    {
        clips[index] = sound;
    }

    public void beginLoop()
    {
        long miliDelay = 15000 / Config.tempo;
        int nanoDelay = (int) (((15000 / Config.tempo) - miliDelay) * 1000);
        this.looping = true;
        while (this.looping)
        {
            for (int i = 0; i < 16; i++)
            {
                if (clips[i] != null) {
                    clips[i].setFramePosition(0);
                    clips[i].start();
                }
                try {
                    Thread.sleep(miliDelay, nanoDelay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void endLoop()
    {
        this.looping = false;
    }

    public void run()
    {
        beginLoop();
    }

    public boolean isLooping()
    {
        return this.looping;
    }

    public static Loop sampleLoop()
    {
        Loop loop = new Loop();
        Clip kick1 = AudioPlaybackSystem.createJSClip(new File("909_kik2.wav"));
        Clip kick2 = AudioPlaybackSystem.createJSClip(new File("909_kik2.wav"));
        Clip kick3 = AudioPlaybackSystem.createJSClip(new File("909_kik2.wav"));
        Clip kick4 = AudioPlaybackSystem.createJSClip(new File("909_kik2.wav"));
        loop.addSound(0, kick1);
        loop.addSound(4, kick2);
        loop.addSound(8, kick3);
        loop.addSound(12, kick4);
        return loop;
    }
}
