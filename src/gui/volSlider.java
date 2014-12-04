package gui;

import javax.swing.*;

/**
 * Created by Daniel on 12/4/14.
 */
public class VolSlider extends JSlider{

    public VolSlider(float position)
    {
        super();
        this.setValue((int)(this.getMaximum() * position));
    }

    public VolSlider(){
        super();
    }

    public float getPercent()
    {
        //float val = (this.getValue() - this.getMinimum()) / (this.getMaximum() - this.getMinimum());
        float current = this.getValue();
        float max = this.getMaximum();
        float min = this.getMinimum();
        float num = current - min;
        float den = max - min;
        float val = num  / den;
        return val;
    }
}
