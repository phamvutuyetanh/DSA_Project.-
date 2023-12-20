package Main;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawDefinition extends JPanel {
	Graphics2D g2;

	private boolean draw;
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
		if (draw == true) {
			drawSubWindow(5, 5, 1280, 350);
			drawtext(20, 50);
		}

	}

	public void drawSubWindow(int x, int y, int w, int h) {
		Color c = new Color(173, 216, 230);
		g2.setColor(c);
		g2.fillRoundRect(x, y, w, h, 35, 35);

		c = new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x + 5, y + 5, w - 10, h - 10, 25, 25);
	}


	public static ArrayList<String> wrapText(Graphics2D g2d, String text, int textWidthArea) {
		FontMetrics fm = g2d.getFontMetrics();
		ArrayList<String> lines = new ArrayList<>();
		String[] words = text.split(" ");
		StringBuilder line = new StringBuilder(words[0]);
		for (int i = 1; i < words.length; i++) {
			if (fm.stringWidth(line + " " + words[i]) <= textWidthArea) {
				line.append(" ").append(words[i]);
			} else {
				lines.add(line.toString());
				line = new StringBuilder(words[i]);
			}
		}
		lines.add(line.toString());
		return lines;
	}

	public void drawtext(int x, int y) {
		Font arial_20 = new Font("Arial", Font.PLAIN, 20);
		g2.setFont(arial_20);
		g2.setColor(Color.black);
		System.out.println(algorithm);
		if (algorithm.equals("Bubble")) {
			String text = "Bubble Sort is the simplest sorting algorithm that repeatedly swaps adjacent elements if they're in the wrong order. It usually begins from the left and compares adjacent elements, and the higher one is placed on the right side.";
			// g2.drawString(text, x, y);
			ArrayList<String> lines = wrapText(g2, text, 1250); // 1280 is the width of your text area, then we get 1250 for the text
			for (String line : lines) {
				g2.drawString(line, x, y += g2.getFontMetrics().getHeight());
			}
		} else if (algorithm.equals("Selection")) {
			String text = "Selection Sort is a simple and efficient sorting algorithm that repeatedly selects the smallest (or largest) element from the unsorted portion of the list and swaps it with the first element of the unsorted part. This process is repeated for the remaining unsorted portion until the entire list is sorted.";
			// g2.drawString(text, x, y);
			ArrayList<String> lines = wrapText(g2, text, 1250); // 1280 is the width of your text area, then we get 1250 for the text
			for (String line : lines) {
				g2.drawString(line, x, y += g2.getFontMetrics().getHeight());
			}
		} else if (algorithm.equals("Insertion")) {
			String text = "Insertion sort is a sorting algorithm that places an unsorted element at its suitable place in each iteration. Insertion sort works similarly to how we sort cards in our hand in a card game. We assume that the first card is already sorted; then, we select an unsorted card. If the unsorted card is greater than the card in hand, it is placed on the right; otherwise, it is placed on the left. In the same way, other unsorted cards are taken and put in their right place.";
			// g2.drawString(text1, x, y);
			ArrayList<String> lines = wrapText(g2, text, 1250); // 1280 is the width of your text area, then we get 1250 for the text
			for (String line : lines) {
				g2.drawString(line, x, y += g2.getFontMetrics().getHeight());
			}
		} else if (algorithm.equals("Quick")) {
			String text = "Quick";
			g2.drawString(text, x, y);
		} else if (algorithm.equals("Merge")) {
			String text = "Merge Sort is a sorting algorithms based on the divide and conquer strategy. It works by dividing an array into two halves, sorting each half, and then merging the sorted halves back together. This process is repeated until the entire array is sorted. It’s known for its efficiency, with a worst-case time complexity of Ο(N log(n) ).";
			// g2.drawString(text, x, y);
			ArrayList<String> lines = wrapText(g2, text, 1250); // 1280 is the width of your text area, then we get 1250 for the text
			for (String line : lines) {
				g2.drawString(line, x, y += g2.getFontMetrics().getHeight());
			}
		} else if( algorithm.equals("Shell")){
			String text= "";
		}
	}

}
