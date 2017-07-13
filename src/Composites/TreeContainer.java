package Composites;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by jason on 7/8/17.
 */
public class TreeContainer extends WidjetContainer {

    private TreeWidjet treeWidjet;

    public TreeContainer(){
        super();
    }

    public TreeWidjet getTreeWidjet(){
        return treeWidjet;
    }

    @Override
    public void addWidjets() {
        treeWidjet = new TreeWidjet();
        this.containerWidjets.add(treeWidjet);
    }

    @Override
    public void formatWidjet() {
        panel.setLayout(null);
        panel.setBackground(Color.GRAY);
        panel.setSize(parentContainer.getWidth()*2/5, parentContainer.getHeight());
    }
}
