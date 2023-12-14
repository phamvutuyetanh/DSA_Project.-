package Main;
import java.awt.*;

import javax.swing.JPanel;
public class DrawDefinition extends JPanel{
    Graphics2D g2;
	
	private boolean draw ;
	private App app;
	private String algorithm;
	
	public DrawDefinition(App a) {
		this.app = a;
		
		draw = false;
	}
	
	public void setdraw(boolean d) {
		this.draw = d;
	}
	public void setAlgo(String s) {
		this.algorithm = s;
	}
	
	
	 public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        this.g2 = (Graphics2D) g; 
	        if(draw == true) {
	        	drawSubWindow(5, 5, 1280, 350);
				drawtext(20, 50);
	        }
					
	    }
	 public void drawSubWindow(int x, int y, int w, int h) {
		 Color c = new Color(173,216,230);
		 g2.setColor(c);
		 g2.fillRoundRect(x, y, w, h, 35, 35);
		 
		 c = new Color(255,255,255);
		 g2.setColor(c);
		 g2.setStroke(new BasicStroke(5));
		 g2.drawRoundRect(x+5, y+5, w-10, h-10, 25, 25);
	 }
	 public void drawtext(int x, int y) {
		 Font arial_20 = new Font("Arial", Font.PLAIN,20);
		 g2.setFont(arial_20);
		 g2.setColor(Color.black);
		 System.out.println(algorithm);
		 if(algorithm.equals("Bubble")) {
			 String text = "Bubble Sort";
			 g2.drawString(text, x, y);
		 }
		 else if (algorithm.equals("Selection")) {
			 String text = "Selection";
			 g2.drawString(text, x, y);
		 }
		 else if (algorithm.equals("Insertion")) {
			 String text = "Insertion";
			 g2.drawString(text, x, y);
		 }
		 else if (algorithm.equals("Quick")) {
			 String text = "Quick";
			 g2.drawString(text, x, y);
		 }
		 else if (algorithm.equals("Merge")) {
			 String text = "Merge";
			 g2.drawString(text, x, y);
		 }
		 
	 }

}

