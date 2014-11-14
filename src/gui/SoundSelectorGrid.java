package gui;

import javax.sound.sampled.Clip;

/**
 * Created by Daniel on 11/12/14.
 */
public class SoundSelectorGrid {

    private Button[][] grid;
    public LoopBuilderWindow loopBuilder;

    public SoundSelectorGrid(SampleGridWindow source)
    {
        this.grid = source.grid;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; i < grid[i].length; j++)
            {
                Clip c = ((SampleAction)grid[i][j].pressAction).getClip();
                grid[i][j].pressAction = new SoundSelectorAction(this, grid[i][j]);
                ((SoundSelectorAction)grid[i][j].pressAction).setClip(c);
            }
        }
    }
}
