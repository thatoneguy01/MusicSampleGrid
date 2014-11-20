package gui;

import core.Config;
import core.Loop;

/**
 * Created by Daniel on 11/12/14.
 */
public class SampleLoopAction implements Action {

    private Loop loop = null;//Loop.sampleLoop();

    @Override
    public void execute() {
        if (Config.editMode) {
            LoopBuilderWindow loopBuilderWindow = new LoopBuilderWindow(this);
        }
        else {
            if (loop != null) {
                if (loop.isLooping()) {
                    loop.endLoop();
                } else {
                    new Thread(loop).start();
                }
            }
            Config.mainWindow.requestFocusInWindow();
        }
    }

    public void setLoop(Loop l)
    {
        if (l != null)
            this.loop = l;
    }
}
