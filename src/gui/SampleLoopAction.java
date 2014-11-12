package gui;

import core.Loop;

/**
 * Created by Daniel on 11/12/14.
 */
public class SampleLoopAction implements Action {

    private Loop loop = Loop.sampleLoop();

    @Override
    public void execute() {
        if (loop.isLooping())
        {
            loop.endLoop();
        }
        else
        {
            new Thread(loop).start();
        }
    }
}
