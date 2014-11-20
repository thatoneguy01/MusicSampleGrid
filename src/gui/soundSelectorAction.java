package gui;

import core.AudioPlaybackSystem;

import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Created by Daniel on 11/12/14.
 */
public class SoundSelectorAction implements Action {

    private SoundSelectorGrid container;
    private File source;
    private Button button;
    public Clip clip;

    public SoundSelectorAction(SoundSelectorGrid grid, Button b)
    {
        container = grid;
        button = b;
    }

    public void setClip(Clip c)
    {
        clip = c;
    }
    public void setSource(File f) { source = f;}

    @Override
    public void execute() {
        container.loopBuilder.build(AudioPlaybackSystem.createJSClip(source));
    }
}
