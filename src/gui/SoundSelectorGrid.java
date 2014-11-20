package gui;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by Daniel on 11/12/14.
 */
public class SoundSelectorGrid extends JPanel{

    private Button[][] grid;
    public LoopBuilderWindow loopBuilder;

    public SoundSelectorGrid(int xSize, int ySize, SampleGridWindow source, LoopBuilderWindow container)
    {
        this.setLayout(new GridLayout(xSize, ySize));
        this.grid = new Button[xSize][ySize];
        this.loopBuilder = container;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[i].length; j++)
            {
                Clip c = ((SampleAction)source.grid[i][j].pressAction).getClip();
                File f = ((SampleAction)source.grid[i][j].pressAction).getSoundFile();
                grid[i][j] = new SelectorButton(40, 40, this);
                ((SoundSelectorAction)grid[i][j].pressAction).setClip(c);
                ((SoundSelectorAction)grid[i][j].pressAction).setSource(f);
                this.add(grid[i][j]);
            }
        }
    }
}
