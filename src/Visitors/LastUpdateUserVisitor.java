package Visitors;

import Composites.LargeContainers.UserViewContainer;
import Composites.TextFieldWidjet;
import Composites.TextLabelWidjet;
import Users.User;
import Users.UserManagerSingleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jason on 7/18/17.
 */
public class LastUpdateUserVisitor extends ButtonVisitor{

    private TextLabelWidjet textLabelWidjet;

    public LastUpdateUserVisitor(TextLabelWidjet t) {
        textLabelWidjet = t;
    }

    @Override
    public ActionListener onClickAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User lastUser = UserManagerSingleton.getInstance().getLastUpdateUser();
                if (lastUser != null){
                    textLabelWidjet.setText(lastUser.getID() + " at " + lastUser.getLastUpdateTime());
                }
                else {
                    textLabelWidjet.setText("Not updates yet");
                }

            }
        };
    }
}
