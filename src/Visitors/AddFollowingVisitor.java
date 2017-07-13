package Visitors;

import Composites.TextFieldWidjet;
import Composites.LargeContainers.UserViewContainer;
import Users.User;
import Users.UserManagerSingleton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jason on 7/12/17.
 */
public class AddFollowingVisitor extends ButtonVisitor {

    private TextFieldWidjet textFieldWidjet;
    private UserViewContainer userViewContainer;

    public AddFollowingVisitor(TextFieldWidjet t, UserViewContainer v) {
        textFieldWidjet = t;
        userViewContainer = v;
    }

    @Override
    public ActionListener onClickAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User u = getOtherUser();
                if (u==null){
                    JTextField t = (JTextField)textFieldWidjet.getJComponent();
                    t.setText("User Not found");
                }
                else if (userViewContainer.getUser().hasFollowingUser(u) ||
                        u == userViewContainer.getUser()){
                    JTextField t = (JTextField)textFieldWidjet.getJComponent();
                    t.setText("Already following");
                }
                else {
                    User currentUser = userViewContainer.getUser();
                    currentUser.addFollowing(u);
                    userViewContainer.addFollowing(u.getID());
                }
            }
        };
    }

    private User getOtherUser(){
        JTextField t = (JTextField)textFieldWidjet.getJComponent();
        return UserManagerSingleton.getInstance().getUserFromString(t.getText());
    }

}
