package Composites;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jason on 7/8/17.
 */
public interface Widjet {

    //assume added from parent. get parent then format
    //if container, render all container widjets
    public void render();
    public JComponent getJComponent();
    public Component getParentContainer();
    public void update();
    public void formatWidjet();
}
