package Sourcecode;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;
import java.awt.*;

public class Draw extends JPanel {
    ArrayList<Integer> nums;

    public Draw(ArrayList<Integer> array) {
        nums = array;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int index = 0; index < nums.size(); index++) {
            //super.paintComponent(g);
            g.setColor(Color.pink);
            g.fillRect(10+ 27 * (index) + 2 * (index), 500 - nums.get(index), 25, nums.get(index));  
        }

    }

    public void updateArray(ArrayList<Integer> array) {
        nums = array;
    }
}
