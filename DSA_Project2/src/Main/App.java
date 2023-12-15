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
    DrawDefinition drawmes = new DrawDefinition(this);

    // Buttons
    JButton start;
    JButton reset;
    JButton defi;

    // Instantiate Algorithms
    BaseSort[] bases = new BaseSort[6];

    public void setupalgorithm() {
        bases[0] = new BubbleSort(array);
        bases[1] = new SelectionSort(array);
        bases[2] = new InsertionSort(array);
        bases[3] = new QuickSort(array);
        bases[4] = new MergeSort(array);
        bases[5]= new ShellSort(array);
    }

    // Runtime, No. Comparisons, Array Accesses
    // Objects
    JLabel runtimeLabel;
    JLabel comparisonsLabel;
    JLabel swapsLabel;

    // Global variables
    private int count = 1;

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
        comparisonsLabel = new JLabel("No. Comparisons: " );
        comparisonsLabel.setBounds(30, 215, 500, 50);
        comparisonsLabel.setFont(new Font("Courier New", Font.BOLD, 28));
        comparisonsLabel.setForeground(new Color(163, 184, 204));
        panelUpper.add(comparisonsLabel);

        // No. Array Access Label
        swapsLabel = new JLabel("No. Swaps: " );
        swapsLabel.setBounds(30, 250, 500, 50);
        swapsLabel.setFont(new Font("Courier New", Font.BOLD, 28));
        swapsLabel.setForeground(new Color(163, 184, 204));
        panelUpper.add(swapsLabel);
        // sua
        // Combo Box
        String[] algorithms = { "Select Algorithm", "Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort",
                "Merge Sort","Shell Sort" };
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

        // defi 
        defi = new JButton("Definition of Algorithm");
        defi.setBounds(350, 350, 140, 35);// 700, 60, 140, 30. x,y,rong,dai
        defi.addActionListener(this);
        panelUpper.add(defi);

        // Align two panels
        panelUpper.setBounds(0, 0, 2000, 500);/// 870,100
        draw.setBounds(0, 500, 2000, 700);// 870,522
        drawmes.setBounds(550, 120, 1300, 370);
        // Set background colours
        panelUpper.setBackground(new Color(30, 30, 30));
        draw.setBackground(new Color(30, 30, 30));
        drawmes.setBackground(new Color(30, 30, 30));
        // Add panels
        panelUpper.setLayout(new BorderLayout());
        this.add(drawmes);
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
                    swapsLabel.setText("No. Swaps: NO SWAP in Merge sort");
                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }
            }
            else if( selectedAlgo=="Shell"){
                try{
                bases[5].excutesort(draw,this);
                int n= bases[5].getncompare();
                comparisonsLabel.setText("No. comparisons: " + Integer.toString(n));
                swapsLabel.setText("No. Swaps: NO SWAP in Merge sort");
            }
            catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
        }
    }
}
        // Reset button status
        if ((e.getSource() == algosDropdown) || e.getSource() == reset) {
            array = newArray.createArray();
            draw.updateArray(array);
            draw.repaint();
            needReset = false;
            for (int i = 0; i < bases.length; i++) {
                bases[i].setarray(array);
                bases[i].setncompare();
                bases[i].setnSwaps();
            }
            drawmes.setdraw(false);
        	drawmes.repaint();
            comparisonsLabel.setText("No. comparisons: 0");
            swapsLabel.setText("No. Swaps: 0");

        }

        if(e.getSource() == defi & algosDropdown.getSelectedItem() != "Select Algorithm") {
        	count++;
        	System.out.println("C"+count);
        	if(count%2 == 0) {
        		drawmes.setdraw(true);
        		String al = selectedAlgo;
        		drawmes.setAlgo(al);
        		drawmes.repaint();
        	}
        	else {
        		drawmes.setdraw(false);
        		drawmes.repaint();
        	}
        	
        	
        	
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
            } else if (algosDropdown.getSelectedItem() == "Shell Sort") {
                selectedAlgo = "Shell";
                runtimeLabel.setText("Time complexity: Nlog(N)");
        }

    }
}}
        
    

