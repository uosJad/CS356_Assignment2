package Visitors;

import Composites.ButtonWidjet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jason on 7/10/17.
 */
public abstract class ButtonVisitor {

    protected ButtonWidjet button;

    public ButtonVisitor(){};

    public abstract ActionListener onClickAction();

    public void setListener(JButton b){
        b.addActionListener(onClickAction());
    }


}
