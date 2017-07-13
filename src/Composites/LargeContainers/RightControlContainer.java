package Composites.LargeContainers;

import Composites.ButtonWidjet;
import Composites.TextFieldWidjet;
import Composites.TextLabelWidjet;
import Composites.WidjetContainer;
import Users.UserManagerSingleton;
import Visitors.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;

/**
 * Created by jason on 7/8/17.
 */
public class RightControlContainer extends WidjetContainer {

    private TextLabelWidjet alertLable;
    private TextFieldWidjet textField;
    private TextFieldWidjet userID;
    private TextFieldWidjet groupID;

    public RightControlContainer(){
        super();
    }

    @Override
    public void addWidjets() {
        JPanel top = new JPanel();

        int divx = 6;
        int divy = 6;

        textField = new TextFieldWidjet("Text Here",2,26,60,6,divx,divy);
        containerWidjets.add(textField);

        alertLable = new TextLabelWidjet("", 2, 34,60, 6, divx,divy);
        containerWidjets.add(alertLable);
        UserManagerSingleton.getInstance().setLabel(alertLable);

        generateUpperButtons(divx,divy);
        generateLowerButtons(divx,divy);


    }

    private void generateUpperButtons(int divx, int divy){
        userID = new TextFieldWidjet("USER ID HERE",2,2,29,6,divx,divy);
        containerWidjets.add(userID);
        ButtonWidjet userBut = new ButtonWidjet("Add user",33,2,29,6,divx,divy);
        userBut.acceptVisitor(new NewUserVisitor(userID, alertLable));
        containerWidjets.add(userBut);

        groupID = new TextFieldWidjet("GROUP ID HERE",2,10,29,6,divx,divy);
        containerWidjets.add(groupID);
        ButtonWidjet groupBut = new ButtonWidjet("Add group",33,10,29,6,divx,divy);
        groupBut.acceptVisitor(new NewGroupVisitor(groupID, alertLable));
        containerWidjets.add(groupBut);

        ButtonWidjet openBut = new ButtonWidjet("Open User View",2,18,60,6,divx,divy);
        openBut.acceptVisitor(new OpenUserPanelVisitor(alertLable));
        containerWidjets.add(openBut);
    }

    private void generateLowerButtons(int divx, int divy){

        ButtonWidjet userTotal = new ButtonWidjet("User Total",2,59,29,6,divx,divy);
        userTotal.acceptVisitor(new UserTotalVisitor(alertLable));
        containerWidjets.add(userTotal);

        ButtonWidjet groupTotal = new ButtonWidjet("Group Total",33,59,29,6,divx,divy);
        groupTotal.acceptVisitor(new GroupTotalVisitor(alertLable));
        containerWidjets.add(groupTotal);

        ButtonWidjet messageTotal = new ButtonWidjet("Message Total",2,67,29,6,divx,divy);
        messageTotal.acceptVisitor(new MessageTotalVisitor(alertLable));

        containerWidjets.add(messageTotal);

        ButtonWidjet positive = new ButtonWidjet("Positive",33,67,29,6,divx,divy);
        positive.acceptVisitor(new PositiveVisitor(alertLable));
        containerWidjets.add(positive);

    }

    @Override
    public void formatWidjet() {
        panel.setLayout(null);
        panel.setBackground(Color.RED);
        panel.setSize(parentContainer.getWidth()*3/5, parentContainer.getHeight());
        panel.setLocation(parentContainer.getWidth()*2/5,0);
    }
}
