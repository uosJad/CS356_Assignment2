package Visitors;

import Composites.TextFieldWidjet;
import Composites.TextLabelWidjet;
import Users.UserManagerSingleton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jason on 7/11/17.
 */
public class NewGroupVisitor extends ButtonVisitor{

    private TextFieldWidjet textFieldWidjet;
    private TextLabelWidjet textLabelWidjet;

    public NewGroupVisitor(TextFieldWidjet t, TextLabelWidjet te){

        textFieldWidjet = t;
        textLabelWidjet = te;

    }

    @Override
    public ActionListener onClickAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField tempField = (JTextField)textFieldWidjet.getJComponent();
                UserManagerSingleton.getInstance().addGroup(tempField.getText() + " (Group)");
            }
        };
    }
}
