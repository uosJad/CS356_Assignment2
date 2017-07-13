package Visitors;

import Composites.TextLabelWidjet;
import Users.UserManagerSingleton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jason on 7/10/17.
 */
public class GroupTotalVisitor extends ButtonVisitor{

    private TextLabelWidjet textLabelWidjet;

    public GroupTotalVisitor(TextLabelWidjet t) {
        textLabelWidjet = t;
    }

    @Override
    public ActionListener onClickAction() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textLabelWidjet.setText(
                        UserManagerSingleton.getInstance().getTotalGroups() + " groups (including Root)");

            }
        };
    }
}
