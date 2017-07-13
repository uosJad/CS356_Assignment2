package Visitors;

import Composites.ButtonWidjet;
import Composites.TextLabelWidjet;
import Users.UserManagerSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jason on 7/10/17.
 */
public class PositiveVisitor extends ButtonVisitor{

    private TextLabelWidjet text;

    public PositiveVisitor(TextLabelWidjet text){
        this.text = text;
    }
    @Override
    public ActionListener onClickAction() {
        //TODO calc positive
        ActionListener temp = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(UserManagerSingleton.getInstance().calcPositive() +
                        " positive messages (messages with +'s)");
            }
        };
        return temp;

    }
}
