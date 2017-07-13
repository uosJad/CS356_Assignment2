package Composites;

import Visitors.ButtonVisitor;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jason on 7/8/17.
 */
public class ButtonWidjet extends SingleWidjet{

    public ButtonWidjet(String s, int x1, int y1, int x2, int y2){
        this(s, x1,y1,x2,y2,1,1);
    }
    public ButtonWidjet(String s, int x1, int y1, int x2, int y2, int divx, int divy){
        component = new JButton(s);
        component.setLayout(null);
        this.x_pos = x1;
        this.y_pos = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.COLUMN_DIV_X = divx;
        this.COLUMN_DIV_Y = divy;
    }

    public void acceptVisitor(ButtonVisitor visitor){
        visitor.setListener((JButton)this.component);
    }


    @Override
    public void update() {
        //TODO implementation button
    }

    public void setDiv(int x, int y){
        COLUMN_DIV_X = x;
        COLUMN_DIV_Y = y;
    }
}
