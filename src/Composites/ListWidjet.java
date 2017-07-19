package Composites;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jason on 7/12/17.
 */
public class ListWidjet extends SingleWidjet{

    private DefaultListModel<String> listModel;

    public ListWidjet(int x1, int y1, int x2, int y2){
        this(x1,y1,x2,y2,1,1);
    }
    public ListWidjet(int x1, int y1, int x2, int y2, int divx, int divy){
        super();
        listModel = new DefaultListModel<String>();
        component = new JList<String>(listModel);
        component.setBackground(Color.cyan);
        component.setVisible(true);
        this.x_pos = x1;
        this.y_pos = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.COLUMN_DIV_X = divx;
        this.COLUMN_DIV_Y = divy;
    }

    public void fillList(String[] s, boolean putDash){
        for (int i = 0; i < s.length; i++){
            String str = "";
            //if (putDash) str = str + "- ";
            listModel.addElement(str + s[i]);
        }
    }

    public void setValueAtIndex(String s, int i){
        listModel.setElementAt(s, i);
    }

    public void addToList(String s){
        listModel.addElement(s);
    }

    @Override
    public void update() {

    }
}
