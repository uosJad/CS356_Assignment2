package Visitors;

import Composites.TextLabelWidjet;
import Users.UserManagerSingleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jason on 7/18/17.
 */
public class ValidUsersVisitor extends ButtonVisitor{


    private TextLabelWidjet textLabelWidjet;

    public ValidUsersVisitor(TextLabelWidjet t) {
        textLabelWidjet = t;
    }

    @Override
    public ActionListener onClickAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (UserManagerSingleton.getInstance().isValidUsers()){
                    textLabelWidjet.setText("Is valid");
                }
                else{
                    textLabelWidjet.setText("Not valid");
                }
            }
        };
    }
}
