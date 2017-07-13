package Composites;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jason on 7/8/17.
 */
public abstract class SingleWidjet implements Widjet{

    protected Container parentContainer;
    protected JComponent component;
    protected int x_pos,y_pos,x2,y2;
    protected int COLUMN_DIV_X,COLUMN_DIV_Y;

    public abstract void update();

    @Override
    public void render() {
        parentContainer = getParentContainer();
        formatWidjet();
    }

    @Override
    public JComponent getJComponent(){
        return this.component;
    }

    @Override
    public Container getParentContainer() {
        return (Container) SwingUtilities.getWindowAncestor(this.component);
    }

    @Override
    public void formatWidjet() {
        component.setBounds(
                (Integer)x_pos*COLUMN_DIV_X,
                (Integer)y_pos*COLUMN_DIV_Y,
                (Integer)x2*COLUMN_DIV_X,
                (Integer)y2*COLUMN_DIV_Y);
    }

}
