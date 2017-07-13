package Users;

import Composites.TextFieldWidjet;
import Composites.TextLabelWidjet;
import Composites.TreeWidjet;
import Windows.UserView;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by jason on 7/10/17.
 */
public class UserManagerSingleton {

    private static UserManagerSingleton instance = null;
    private Set<String> messageSet;
    private Set<UserView> userViews;
    private Set<User> users;
    private TreeWidjet treeWidjet;
    private TextLabelWidjet labelWidjet;
    private int numOfMessages;

    private UserManagerSingleton(){
        users = new HashSet<>();
        userViews = new HashSet<>();
        messageSet = new HashSet<>();
        users.add(new GroupUser("Root"));
        numOfMessages = 0;
    }

    public void setLabel(TextLabelWidjet label){
        labelWidjet = label;
    }

    public void setTreeWidjet(TreeWidjet t){
        treeWidjet = t;
    }

    public static UserManagerSingleton getInstance(){
        if (instance == null){
            instance = new UserManagerSingleton();
        }
        return instance;
    }

    public String getSelectedNode(){
        String s = treeWidjet.getSelected();
        return s;
    }

    public void addGroup(String s){

        this.addUserToList(new GroupUser(s));

    }

    public void addUser(String s){
        this.addUserToList(new User(s));
    }

    private void addUserToList(User u){
        if (u.getID().equals("")){
            labelWidjet.setText("Please insert ID");
            return;
        }
        if (getUserFromString(u.getID())!=null){
            if (u instanceof User)
                labelWidjet.setText("User " + u.getID() + " already exists");
            else if (u instanceof GroupUser)
                labelWidjet.setText("Group " + u.getID() + " already exists");
            return;
        }

        if (treeWidjet.addNode(u.getID(), labelWidjet)){
            users.add(u);
        }

    }

    public void removeUserView(UserView u){
        userViews.remove(u);
    }


    public void addUserView(UserView uv){
        userViews.add(uv);
    }

    public UserView getUserView(User u){
        Iterator<UserView> it = userViews.iterator();
        while(it.hasNext()){
            UserView temp = it.next();
            if (temp.getUserViewContainer().getUser() == u){
                return temp;
            }
        }
        return null;
    }

    public User getUserFromString(String s){
        Iterator<User> it = users.iterator();
        while(it.hasNext()){
            User temp = it.next();
            if (temp.getID().equals(s)){
                return temp;
            }
        }
        return null;
    }

    public int getTotalUsers(){
        Iterator<User> it = users.iterator();
        int count = 0;
        while (it.hasNext()){
            if (!(it.next() instanceof GroupUser)){
                count++;
            }
        }
        return count;
    }

    public int getTotalGroups(){
        Iterator<User> it = users.iterator();
        int count = 0;
        while (it.hasNext()){
            if (it.next() instanceof GroupUser){
                count++;
            }
        }
        return count;
    }

    public int getNumOfMessages() {
        return numOfMessages;
    }

    public void incrementNumOfMessages() {
        this.numOfMessages++;
    }

    public void addMessage(String s){
        messageSet.add(s);
    }

    public int calcPositive(){
        int count = 0;
        Iterator<String> it = messageSet.iterator();
        while (it.hasNext()){
            if (it.next().contains("+")) count++;
        }
        return count;
    }
}
