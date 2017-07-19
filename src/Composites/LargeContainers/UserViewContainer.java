package Composites.LargeContainers;

import Composites.ButtonWidjet;
import Composites.ListWidjet;
import Composites.TextFieldWidjet;
import Composites.WidjetContainer;
import Users.User;
import Users.UserManagerSingleton;
import Visitors.AddFollowingVisitor;
import Visitors.SendMessageVisitor;
import Windows.UserView;

/**
 * Created by jason on 7/11/17.
 */
public class UserViewContainer extends WidjetContainer {

    private User user;
    private ListWidjet followingList;
    private ListWidjet messageList;

    public UserViewContainer(){
        super();
        panel.setLayout(null);
    }

    public void setUser(User s){
        user = s;
        followingList.addToList("User created at: " + user.getCreationTime());
        followingList.addToList("Currently following:");
        followingList.fillList(s.getFollowing(), true);

        messageList.addToList("News Feed (Last update at " + user.getLastUpdateTime() + "):");
        messageList.fillList(user.getMessages(), false);
    }

    public User getUser() {
        return user;
    }

    @Override
    public void formatWidjet() {
        panel.setSize(parentContainer.getSize());
    }

    @Override
    public void addWidjets() {
        int divx = 6;
        int divy = 6;
        TextFieldWidjet followTextField = new TextFieldWidjet("USER ID HERE",2,2,29,6,divx,divy);
        containerWidjets.add(followTextField);
        ButtonWidjet followButton = new ButtonWidjet("Follow",33,2,29,6,divx,divy);
        followButton.acceptVisitor(new AddFollowingVisitor(followTextField, this));
        containerWidjets.add(followButton);

        followingList = new ListWidjet(2,10,60,28,divx,divy);
        containerWidjets.add(followingList);

        TextFieldWidjet messageTextField = new TextFieldWidjet("MESSAGE HERE",2,40,29,6,divx,divy);
        containerWidjets.add(messageTextField);
        ButtonWidjet postButton = new ButtonWidjet("Send",33,40,29,6,divx,divy);
        postButton.acceptVisitor(new SendMessageVisitor(messageTextField, this));
        containerWidjets.add(postButton);

        messageList = new ListWidjet(2,48,60,28,divx,divy);
        containerWidjets.add(messageList);

    }

    public void sendMessage(String s){
        messageList.addToList(s);
        messageList.setValueAtIndex("News Feed (Last update at " + user.getLastUpdateTime() + "):", 0);
    }

    public void addFollowing(String s){
        followingList.addToList(s);
    }

}
