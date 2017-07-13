package Composites;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jason on 7/11/17.
 */
public class TextAreaWidjet extends SingleWidjet{

    public TextAreaWidjet(String s, int x1, int y1, int x2, int y2){
        this(s, x1,y1,x2,y2,1,1);
    }
    public TextAreaWidjet(String s, int x1, int y1, int x2, int y2, int divx, int divy){
        makeTextArea(s);
        this.x_pos = x1;
        this.y_pos = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.COLUMN_DIV_X = divx;
        this.COLUMN_DIV_Y = divy;
    }

    private void makeTextArea(String s){
        JTextArea temp = new JTextArea(s);
        temp.setBackground(Color.GRAY);
        this.component = temp;
        component.setLayout(null);
    }

    @Override
    public void update() {

    }

}
