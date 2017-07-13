package Composites;

import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by jason on 7/8/17.
 */
public abstract class WidjetContainer implements Widjet{
    protected Set<Widjet> containerWidjets;
    protected JPanel panel;
    protected Container parentContainer;

    public abstract void formatWidjet();
    public abstract void addWidjets();

    public WidjetContainer(){
        containerWidjets = new HashSet<>();
        panel = new JPanel();
        addWidjets();
    }

    @Override
    public void update() {
        Iterator<Widjet> it = containerWidjets.iterator();
        while (it.hasNext()){
            Widjet temp = it.next();
            temp.update();
        }
    }

    @Override
    public void render() {
        parentContainer = getParentContainer();
        formatWidjet();
        renderToPanel();

    }

    @Override
    public JComponent getJComponent() {
        return panel;
    }

    @Override
    public Container getParentContainer() {
        return (Container) SwingUtilities.getWindowAncestor(panel);
    }

    private void renderToPanel(){
        Iterator<Widjet> it = containerWidjets.iterator();
        while (it.hasNext()){
            Widjet temp = it.next();
            panel.add(temp.getJComponent());
            temp.render();
            //temp.update();
        }
    }
}
