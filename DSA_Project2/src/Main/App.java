package Main;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import SortingAlgorithm.*;

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
    JLabel swapsLabel;

    // Global variables
    int noComparisons = 0;
    int noSwaps = 0;

    // Bool value for reset check
    private boolean needReset = false;

    public App() {
        // Instantiate stuff
        this.setTitle("Sorting Algorithms Visualizer");
        this.setSize(new Dimension(1900, 1080));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // chua chinh
        // Title
        lblTtl = new JLabel("Sorting Algorithms Visualizer");
        lblTtl.setBounds(30, 10, 1500, 100);
        lblTtl.setFont(new Font("Courier New", Font.BOLD, 60));
        lblTtl.setForeground(new Color(163, 184, 204));
        panelUpper.add(lblTtl);

        // Add Name
        name = new JLabel("DSA-Project");
        name.setBounds(30, 90, 300, 40);
        name.setFont(new Font("Courier New", Font.PLAIN, 20));
        name.setForeground(new Color(163, 184, 204));
        panelUpper.add(name);

        // Runtime, Number Comparisons, Number Array Accesses
        // Runtime label
        runtimeLabel = new JLabel("Time complexity: null");
        runtimeLabel.setBounds(30, 180, 500, 50);
        runtimeLabel.setFont(new Font("Courier New", Font.BOLD, 28));
        runtimeLabel.setForeground(new Color(163, 184, 204));
        panelUpper.add(runtimeLabel);

        // No. Comparisons Label
        comparisonsLabel = new JLabel("No. Comparisons: " + noComparisons);
        comparisonsLabel.setBounds(30, 215, 500, 50);
        comparisonsLabel.setFont(new Font("Courier New", Font.BOLD, 28));
        comparisonsLabel.setForeground(new Color(163, 184, 204));
        panelUpper.add(comparisonsLabel);

        // No. Array Access Label
        swapsLabel = new JLabel("No. Swaps: " + noSwaps);
        swapsLabel.setBounds(30, 250, 500, 50);
        swapsLabel.setFont(new Font("Courier New", Font.BOLD, 28));
        swapsLabel.setForeground(new Color(163, 184, 204));
        panelUpper.add(swapsLabel);
        // sua
        // Combo Box
        String[] algorithms = { "Select Algorithm", "Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort",
                "Merge Sort" };
        algosDropdown = new JComboBox(algorithms);
        algosDropdown.setBounds(30, 300, 140, 35);
        algosDropdown.addActionListener(this);
        panelUpper.add(algosDropdown);

        // Buttons
        // Start Button
        start = new JButton("Start Sort");
        start.setBounds(190, 300, 140, 35);// 700, 30, 140,30
        start.addActionListener(this);
        panelUpper.add(start);

        // Reset Button
        reset = new JButton("Reset");
        reset.setBounds(350, 300, 140, 35);// 700, 60, 140, 30. x,y,rong,dai
        reset.addActionListener(this);
        panelUpper.add(reset);

        // Align two panels
        panelUpper.setBounds(0, 0, 2000, 500);/// 870,100
        draw.setBounds(0, 450, 2000, 800);// 870,522

        // Set background colours
        panelUpper.setBackground(new Color(30, 30, 30));
        draw.setBackground(new Color(30, 30, 30));

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
                    int n = bases[0].getncompare();
                    comparisonsLabel.setText("No. comparisons: " + Integer.toString(n));
                    int s = bases[0].getnSwaps();
                    swapsLabel.setText("No. Swaps: " + Integer.toString(s));
                    System.out.println("B");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    System.out.println("C");
                }

            } else if (selectedAlgo == "Selection") {
                try {
                    bases[1].excutesort(draw, this);
                    int n = bases[1].getncompare();
                    comparisonsLabel.setText("No. comparisons: " + Integer.toString(n));
                    int s = bases[1].getnSwaps();
                    swapsLabel.setText("No. Swaps: " + Integer.toString(s));
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            } else if (selectedAlgo == "Insertion") {
                try {
                    bases[2].excutesort(draw, this);
                    int n = bases[2].getncompare();
                    comparisonsLabel.setText("No. comparisons: " + Integer.toString(n));
                    int s = bases[2].getnSwaps();
                    swapsLabel.setText("No. Swaps: " + Integer.toString(s));
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

            } else if (selectedAlgo == "Quick") {
                try {
                    bases[3].excutesort(draw, this);
                    int n = bases[3].getncompare();
                    comparisonsLabel.setText("No. comparisons: " + Integer.toString(n));
                    int s = bases[3].getnSwaps();
                    swapsLabel.setText("No. Swaps: " + Integer.toString(s));
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            } else if (selectedAlgo == "Merge") {
                try {
                    bases[4].excutesort(draw, this);
                    int n = bases[4].getncompare();
                    comparisonsLabel.setText("No. comparisons: " + Integer.toString(n));
                    int s = bases[4].getnSwaps();
                    swapsLabel.setText("No. Swaps: " + Integer.toString(s));
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
                bases[i].setncompare();
                bases[i].setnSwaps();
            }
            comparisonsLabel.setText("No. comparisons: 0");
            swapsLabel.setText("No. Swaps: 0");

        }
        // Combo box status
        if (e.getSource() == algosDropdown) {
            System.out.println(algosDropdown.getSelectedItem());
            if (algosDropdown.getSelectedItem() == "Bubble Sort") {
                selectedAlgo = "Bubble";
                runtimeLabel.setText("Time complexity: O(N^2)");

            } else if (algosDropdown.getSelectedItem() == "Selection Sort") {
                selectedAlgo = "Selection";
                runtimeLabel.setText("Time complexity: O(N^2)");

            } else if (algosDropdown.getSelectedItem() == "Insertion Sort") {
                selectedAlgo = "Insertion";
                runtimeLabel.setText("Time complexity: O(N^2)");

            } else if (algosDropdown.getSelectedItem() == "Quick Sort") {
                selectedAlgo = "Quick";
                runtimeLabel.setText("Time complexity: Nlog(N)");
            } else if (algosDropdown.getSelectedItem() == "Merge Sort") {
                selectedAlgo = "Merge";
                runtimeLabel.setText("Time complexity: Nlog(N)");
            }
        }

    }
}
