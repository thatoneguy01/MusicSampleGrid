package gui;

import javax.sound.sampled.Clip;

/**
 * Created by Daniel on 11/12/14.
 */
public class SoundSelectorAction implements Action {

    private SoundSelectorGrid container;
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

    @Override
    public void execute() {
        container.loopBuilder.build(((SampleAction)button.pressAction).getClip());
    }
}
