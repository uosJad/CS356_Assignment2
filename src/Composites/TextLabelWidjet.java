package Composites;

import javax.swing.*;

/**
 * Created by jason on 7/10/17.
 */
public class TextLabelWidjet extends SingleWidjet{

    public TextLabelWidjet(String s, int x1, int y1, int x2, int y2){
        this(s, x1,y1,x2,y2,1,1);
    }
    public TextLabelWidjet(String s, int x1, int y1, int x2, int y2, int divx, int divy){
        this.component = new JLabel(s);
        component.setLayout(null);
        this.x_pos = x1;
        this.y_pos = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.COLUMN_DIV_X = divx;
        this.COLUMN_DIV_Y = divy;
    }

    @Override
    public void update() {
        this.update(null);
    }

    public void update(String s){

    }

    public void setText(String s){
        JLabel label = (JLabel)this.getJComponent();
        label.setText(s);
    }

}
