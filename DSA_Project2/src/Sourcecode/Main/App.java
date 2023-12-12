package Sourcecode.Main;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import Sourcecode.SortingAlgorithm.*;

public class App extends JFrame implements ActionListener {

    // Instantiate Objects

    // Random stuff
    JComboBox algosDropdown;
    JLabel lblTtl;
    JLabel name;
    String selectedAlgo = "";
    JPanel panelUpper = new JPanel();
    CreateArray newArray = new CreateArray();
    ArrayList<Integer> array = newArray.createArray();// create array list with random position
    Draw draw = new Draw(array);

    // Buttons
    JButton start;
    JButton reset;

    // Instantiate Algorithms
    BaseSort[] bases = new BaseSort[5];

    public void setupalgorithm() {
        bases[0] = new BubbleSort(array);
        bases[1] = new SelectionSort(array);
        bases[2] = new InsertionSort(array);
        bases[3] = new QuickSort(array);
        bases[4] = new MergeSort(array);
    }

    // Runtime, No. Comparisons, Array Accesses
    // Objects
    JLabel runtimeLabel;
    JLabel comparisonsLabel;
    JLabel arrayAccessesLabel;

    // Global variables
    int noComparisons = 0;
    int noArrAccess = 0;

    // Bool value for reset check
    private boolean needReset = false;

    public App() {
        // Instantiate stuff
        this.setTitle("Sorting Algorithms Visualizer");
        this.setSize(new Dimension(1500, 1000));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // chua chinh
        // Title
        lblTtl = new JLabel("Sorting Algorithms Visualizer");
        lblTtl.setBounds(400, 10, 1000, 100);
        lblTtl.setFont(new Font("Niagara Solid", Font.BOLD, 80));
        lblTtl.setForeground(Color.white);
        panelUpper.add(lblTtl);

        // Add Name
        name = new JLabel("DSA-Project");
        name.setBounds(650, 120, 206, 40);
        name.setFont(new Font("Niagara Solid", Font.BOLD, 50));
        name.setForeground(Color.white);
        panelUpper.add(name);

        // Runtime, Number Comparisons, Number Array Accesses
        // Runtime label
        runtimeLabel = new JLabel("Runtime: null");
        runtimeLabel.setBounds(20, 180, 250, 50);
        runtimeLabel.setFont(new Font("Niagara Solid", Font.BOLD, 28));
        runtimeLabel.setForeground(Color.white);
        panelUpper.add(runtimeLabel);

        // No. Comparisons Label
        comparisonsLabel = new JLabel("No. Comparisons: " + noComparisons);
        comparisonsLabel.setBounds(20, 250, 250, 50);
        comparisonsLabel.setFont(new Font("Niagara Solid", Font.BOLD, 28));
        comparisonsLabel.setForeground(Color.white);
        panelUpper.add(comparisonsLabel);

        // No. Array Access Label
        arrayAccessesLabel = new JLabel("No. Array Access: " + noArrAccess);
        arrayAccessesLabel.setBounds(20, 330, 250, 50);
        arrayAccessesLabel.setFont(new Font("Niagara Solid", Font.BOLD, 28));
        arrayAccessesLabel.setForeground(Color.white);
        panelUpper.add(arrayAccessesLabel);
        // sua
        // Combo Box
        String[] algorithms = { "Select Algorithm", "Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort",
                "Merge Sort" };
        algosDropdown = new JComboBox(algorithms);
        algosDropdown.setBounds(1200, 180, 200, 50);
        algosDropdown.addActionListener(this);
        panelUpper.add(algosDropdown);

        // Buttons
        // Start Button
        start = new JButton("Start Visualization");
        start.setBounds(1200, 250, 200, 50);// 700, 30, 140,30
        start.addActionListener(this);
        panelUpper.add(start);

        // Reset Button
        reset = new JButton("Reset");
        reset.setBounds(1200, 330, 200, 50);// 700, 60, 140, 30. x,y,rong,dai
        reset.addActionListener(this);
        panelUpper.add(reset);

        // Align two panels
        panelUpper.setBounds(0, 0, 2000, 500);/// 870,100
        draw.setBounds(0, 450, 2000, 800);// 870,522

        // Set background colours
        panelUpper.setBackground(Color.black);
        draw.setBackground(Color.black);

        // Add panels
        panelUpper.setLayout(new BorderLayout());
        this.add(draw);
        this.add(panelUpper);
        this.validate();
        this.setVisible(true);

    }

    public void setneedReset(boolean reset) {
        needReset = reset;
    }

    public boolean getneedReset() {
        return needReset;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Check status before pressing start button
        if (e.getSource() == start & algosDropdown.getSelectedItem() != "Select Algorithm" & !needReset) {
            if (selectedAlgo.equals("Bubble")) {
                System.out.println("A");
                try {
                    bases[0].excutesort(draw, this);
                    System.out.println("B");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    System.out.println("C");
                }

            } else if (selectedAlgo == "Selection") {
                try {
                    bases[1].excutesort(draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            } else if (selectedAlgo == "Insertion") {
                try {
                    bases[2].excutesort(draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            } else if (selectedAlgo == "Quick") {
                try {
                    bases[3].excutesort(draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } else if (selectedAlgo == "Merge") {
                try {
                    bases[4].excutesort(draw, this);
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
        }
        // Reset button status
        if (e.getSource() == reset) {
            array = newArray.createArray();
            draw.updateArray(array);
            draw.repaint();
            needReset = false;
            for (int i = 0; i < bases.length; i++) {
                bases[i].setarray(array);
            }

        }
        // Combo box status
        if (e.getSource() == algosDropdown) {
            System.out.println(algosDropdown.getSelectedItem());
            if (algosDropdown.getSelectedItem() == "Bubble Sort") {
                selectedAlgo = "Bubble";
                runtimeLabel.setText("Runtime: O(N^2)");

            } else if (algosDropdown.getSelectedItem() == "Selection Sort") {
                selectedAlgo = "Selection";
                runtimeLabel.setText("Runtime: O(N^2)");

            } else if (algosDropdown.getSelectedItem() == "Insertion Sort") {
                selectedAlgo = "Insertion";
                runtimeLabel.setText("Runtime: O(N^2)");

            } else if (algosDropdown.getSelectedItem() == "Quick Sort") {
                selectedAlgo = "Quick";
                runtimeLabel.setText("Runtime: Nlog(N)");
            } else if (algosDropdown.getSelectedItem() == "Merge Sort") {
                selectedAlgo = "Merge";
                runtimeLabel.setText("Runtime: Nlog(N)");
            }
        }

    }
}
