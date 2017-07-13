package Visitors;

import Composites.TextFieldWidjet;
import Composites.TextLabelWidjet;
import Composites.TreeWidjet;
import Users.GroupUser;
import Users.User;
import Users.UserManagerSingleton;
import Windows.ControlPanelSingleton;
import Windows.UserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jason on 7/10/17.
 */
public class OpenUserPanelVisitor extends ButtonVisitor{

    private TextLabelWidjet alert;

    public OpenUserPanelVisitor(TextLabelWidjet alert){
        this.alert = alert;
    }

    @Override
    public ActionListener onClickAction() {
        return new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                //get user
                //new user view

                UserManagerSingleton manager = UserManagerSingleton.getInstance();

                User temp = manager.getUserFromString(
                        UserManagerSingleton.getInstance().getSelectedNode());



                if (temp != null && !(temp instanceof GroupUser)){
                    UserView uv = new UserView(temp);
                }
                else{
                    JLabel lab = (JLabel)alert.getJComponent();
                    lab.setText("Please select a user");
                }

            }
        };

    }
}
