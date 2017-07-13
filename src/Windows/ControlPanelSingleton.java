package Windows;

import Composites.LargeContainers.RightControlContainer;
import Composites.TreeContainer;
import Users.*;

import javax.swing.*;

/**
 * Created by jason on 7/8/17.
 */
public class ControlPanelSingleton extends Window{
    private static ControlPanelSingleton instance = null;
    private TreeContainer treeContainer;
    private RightControlContainer rightControlContainer;

    private ControlPanelSingleton(){

        super(640,480);
        frame.setTitle("SM Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeManager(){
        UserManagerSingleton.getInstance();
        UserManagerSingleton.getInstance().setTreeWidjet(treeContainer.getTreeWidjet());

    }

    @Override
    protected void addWidjets(){
        treeContainer = new TreeContainer();
        widjets.add(treeContainer);
        rightControlContainer = new RightControlContainer();
        widjets.add(rightControlContainer);

        initializeManager();

    }

    public static ControlPanelSingleton getInstance(){
        if (instance == null){
            instance = new ControlPanelSingleton();
        }
        return instance;
    }

    public TreeContainer getTreeContainer() {
        return treeContainer;
    }

    public void setTreeContainer(TreeContainer treeContainer) {
        this.treeContainer = treeContainer;
    }

    public RightControlContainer getRightControlContainer() {
        return rightControlContainer;
    }

    public void setRightControlContainer(RightControlContainer rightControlContainer) {
        this.rightControlContainer = rightControlContainer;
    }
}
