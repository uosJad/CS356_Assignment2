package Windows;

import Composites.LargeContainers.UserViewContainer;
import Users.User;
import Users.UserManagerSingleton;

import javax.swing.*;

/**
 * Created by jason on 7/10/17.
 */
public class UserView extends Window{

    private User user;
    private JTextArea message;
    private UserView uv;
    private UserViewContainer userViewContainer;

    public UserView(User u){
        super(384,480);
        uv = this;
        user = u;
        //System.out.println(user.getID());
        frame.setTitle(u.getID() + "'s Profile");
        UserManagerSingleton.getInstance().addUserView(uv);
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                UserManagerSingleton.getInstance().removeUserView(uv);
                //System.out.println("removed");
            }
        });

        userViewContainer.setUser(user);

    }

    @Override
    protected void addWidjets() {
        userViewContainer= new UserViewContainer();
        widjets.add(userViewContainer);
    }


    public UserViewContainer getUserViewContainer() {
        return userViewContainer;
    }

    public void refreshMessages(){

    }
}
