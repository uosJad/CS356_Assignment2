package Visitors;

import Composites.TextFieldWidjet;
import Composites.LargeContainers.UserViewContainer;
import Users.User;
import Users.UserManagerSingleton;
import Windows.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

/**
 * Created by jason on 7/12/17.
 */
public class SendMessageVisitor extends ButtonVisitor{

    private TextFieldWidjet textFieldWidjet;
    private UserViewContainer userViewContainer;

    public SendMessageVisitor(TextFieldWidjet t, UserViewContainer u) {
        textFieldWidjet = t;
        userViewContainer = u;
    }

    @Override
    public ActionListener onClickAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                User thisUser = userViewContainer.getUser();
                JTextField textField = (JTextField)textFieldWidjet.getJComponent();
                String message = thisUser.getID() + ": " + textField.getText();
                thisUser.updateMessage(message);
                thisUser.setLastUpdateTime(System.currentTimeMillis());
                userViewContainer.sendMessage(message);
                sendToFollowers(message, thisUser);

                UserManagerSingleton.getInstance().incrementNumOfMessages();
                UserManagerSingleton.getInstance().addMessage(textField.getText(), thisUser);

            }
        };
    }


    private void sendToFollowers(String s, User thisUser){
        Iterator<User> it = thisUser.getFollowerIterator();
        while (it.hasNext()){
            User otherUser = it.next();
            otherUser.updateMessage(s);
            otherUser.setLastUpdateTime(System.currentTimeMillis());
            updateOtherView(s, otherUser);
        }
    }

    private void updateOtherView(String s, User u){
        UserView uv = UserManagerSingleton.getInstance().getUserView(u);
        if (uv != null){
            uv.getUserViewContainer().sendMessage(s);
        }
    }
}
