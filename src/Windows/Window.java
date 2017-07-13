package Windows;

import Composites.Widjet;

import javax.swing.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by jason on 7/10/17.
 */
public abstract class Window {
    protected JFrame frame;
    protected Set<Widjet> widjets;

    protected abstract void addWidjets();

    protected Window(){
        this(0,0);
    }

    protected Window(int w, int h){
        widjets = new HashSet<Widjet>();
        createFrame(w, h);
        addWidjets();
        renderComponents();
    }

    protected void createFrame(int w, int h){
        frame = new JFrame();
        frame.setSize(w, h);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    protected void renderComponents(){
        Iterator<Widjet> it = widjets.iterator();
        while(it.hasNext()){
            Widjet temp = it.next();
            frame.add(temp.getJComponent());
            temp.render();
            //temp.update();
        }
    }
}
