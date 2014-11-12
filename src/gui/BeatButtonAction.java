package gui;

import java.awt.*;

/**
 * Created by Daniel on 11/12/14.
 */
public class BeatButtonAction implements Action {

    public int index;
    public BeatButton container;
    public BeatButtonArray superContainer;

    public BeatButtonAction(int index, BeatButton cont, BeatButtonArray superCont)
    {
        this.index = index;
        this.container = cont;
        this.superContainer = superCont;
    }


    @Override
    public void execute() {
        if (superContainer.activeIndex == index) {
            superContainer.activeIndex = -1;
            container.setBackground(container.baseColor);
//            container.setBorderPainted(true);
//            container.setOpaque(true);
//            container.setContentAreaFilled(false);
        }
        else {
            superContainer.activeIndex = index;
            for (int i = 0; i < 16; i++) {
                BeatButton b = this.superContainer.buttonAt(i);
                b.setBackground(b.baseColor);
            }
            container.setBackground(new Color(0, 200, 0));
//            container.setBorderPainted(false);
//            container.setOpaque(true);
//            container.setContentAreaFilled(false);
        }
        System.out.println(superContainer.activeIndex);
    }
}
