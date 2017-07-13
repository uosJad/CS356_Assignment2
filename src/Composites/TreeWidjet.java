package Composites;

import Users.GroupUser;
import Users.User;
import Users.UserManagerSingleton;
import sun.reflect.generics.tree.Tree;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;

/**
 * Created by jason on 7/8/17.
 */
public class TreeWidjet extends SingleWidjet{

    private JScrollPane scrollPane;
    private DefaultMutableTreeNode selectedNode;
    private DefaultMutableTreeNode root;
    private DefaultTreeModel treeNode;
    private DefaultTreeModel treeModel;

    public TreeWidjet(){
        root = new DefaultMutableTreeNode("Root");
        JTree temp = new JTree(root);
        temp.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        treeModel = (DefaultTreeModel)temp.getModel();
        addTreeListener(temp);
        component = temp;
    }

    @Override
    public void update() {
        //TODO implementation tree
    }

    @Override
    public void formatWidjet(){
        component.setSize(parentContainer.getSize());
        //scrollPane = new JScrollPane(component);
        //scrollPane.setLayout(new ScrollPaneLayout());
        //scrollPane.setVisible(true);
    }


    private void addTreeListener(JTree t){
        t.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                selectedNode = (DefaultMutableTreeNode) t.getLastSelectedPathComponent();
                //System.out.println(selectedNode);
            }
        });
    }

    public String getSelected(){
        if (selectedNode == null) return null;
        return selectedNode.toString();
    }

    public boolean addNode(String s, TextLabelWidjet labelWidjet){
        if (selectedNode == null){
            labelWidjet.setText("Please select a group");
            return false;
        }


        User tempUser = UserManagerSingleton.getInstance().getUserFromString(selectedNode.toString());

        if (tempUser!=null && tempUser instanceof GroupUser){
            selectedNode.add(new DefaultMutableTreeNode(s));
            treeModel.reload(root);
        }
        else{
            labelWidjet.setText("Please select a group");
            return false;
        }

        return true;

    }

}
