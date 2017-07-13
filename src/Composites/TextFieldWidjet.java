package Composites;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by jason on 7/10/17.
 */
public class TextFieldWidjet extends SingleWidjet{

    public TextFieldWidjet(String s, int x1, int y1, int x2, int y2){
        this(s, x1,y1,x2,y2,1,1);
    }
    public TextFieldWidjet(String s, int x1, int y1, int x2, int y2, int divx, int divy){
        makeTextField(s);
        this.x_pos = x1;
        this.y_pos = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.COLUMN_DIV_X = divx;
        this.COLUMN_DIV_Y = divy;
    }
    @Override
    public void update() {

    }

    private void makeTextField(String s){
        JTextField temp = new JTextField(s);
        temp.setBackground(Color.GRAY);
        temp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                temp.setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        this.component = temp;


        component.setLayout(null);
    }

}
