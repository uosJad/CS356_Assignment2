package Users;

import Composites.ListWidjet;

import java.util.*;

/**
 * Created by jason on 7/10/17.
 */
public class User {

    private String ID;
    private Stack<String> messages;
    private Set<User> followers;
    private Set<User> following;
    private long creationTime;
    private long lastUpdateTime;

    public User(){

    }

    public User(String Username){

        ID = Username;
        messages = new Stack<>();
        followers = new HashSet<>();
        following = new HashSet<>();
        creationTime = System.currentTimeMillis();
        lastUpdateTime = System.currentTimeMillis();
        //followers.add(this);
    }

    public void addMessage(String s){
        messages.push(s);
    }

    public String[] getMessages(){
        ListIterator<String> it = messages.listIterator(messages.size());
        String[] s = new String[messages.size()];
        int i = messages.size()-1;
        while (it.hasPrevious()){
            s[i] = it.previous();
            i--;
        }

        return s;
    }

    public void addFollower(User u){
        followers.add(u);
    }

    public void addFollowing(User u){
        following.add(u);
        u.addFollower(this);
    }

    public String[] getFollowers(){
        Iterator<User> it = followers.iterator();
        String[] s = new String[followers.size()];
        return getUserStringArray(it,s);
    }

    private String[] getUserStringArray(Iterator<User> it, String[] s){

        int i = 0;
        while(it.hasNext()){
            s[i] = it.next().getID();
            i++;
        }
        return s;
    }

    public Iterator<User> getFollowerIterator(){
        return followers.iterator();
    }

    public boolean hasFollowingUser(User u){
        if (following.contains(u)){
            return true;
        }
        return false;
    }

    public String[] getFollowing(){
        Iterator<User> it = following.iterator();
        String[] s = new String[following.size()];
        return getUserStringArray(it,s);
    }

    public void updateMessage(String s){
        lastUpdateTime = System.currentTimeMillis();
        messages.push(s);
    }

    public long getCreationTime() {
        return creationTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    /*
    public void sendMessage(String s){
        Iterator<User> it = followers.iterator();
        while (it.hasNext()){
            it.next().updateMessage(s);
        }
    }
    */

    public String getID() {
        return ID;
    }


}
