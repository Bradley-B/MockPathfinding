import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.activation.UnsupportedDataTypeException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.RepaintManager;

public class Canvas {

	JFrame field = new JFrame("MockMoving");
	CanvasPanel canvasPanel = new CanvasPanel();
	JPanel buttonPanel = new JPanel();
	JButton rotateLeftButton = new JButton("rotate clockwise");
	JButton rotateRightButton = new JButton("rotate c-clockwise");
	JButton moveButton = new JButton("move");
	JTextField value = new JTextField(3);

	Figure bot = new Figure(250, 250);

	public Canvas() {
		startGUI();
	}

	private void startGUI() {
		field.setSize(500, 500);
		field.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		field.setLayout(new BorderLayout());

		buttonPanel.add(rotateLeftButton);
		buttonPanel.add(rotateRightButton);
		buttonPanel.add(moveButton);
		buttonPanel.add(value);
		buttonPanel.setBackground(Color.WHITE);
		canvasPanel.setBackground(Color.WHITE);

		rotateLeftButton.addActionListener(new Clicked());
		rotateRightButton.addActionListener(new Clicked());
		moveButton.addActionListener(new Clicked());

		field.add(canvasPanel, BorderLayout.CENTER);
		field.add(buttonPanel, BorderLayout.PAGE_END);
		field.setVisible(true);
	}

	public void redraw() {
		canvasPanel.repaint();
	}

	@SuppressWarnings("serial")
	private class CanvasPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D graphics2d = (Graphics2D)g;

			double x = bot.getX();
			double y = bot.getY();
			double rot = bot.getRotation();

			double[] pt = {x+5, y+20};
			double[] pt2 = {x-5, y+20};
			AffineTransform.getRotateInstance(rot-Math.PI/2, x, y).transform(pt, 0, pt, 0, 1);
			AffineTransform.getRotateInstance(rot-Math.PI/2, x, y).transform(pt2, 0, pt2, 0, 1);			

			Polygon triangle = new Polygon(new int[] {(int) x, (int) pt[0], (int) pt2[0]}, new int[] {(int) y, (int) pt[1], (int) pt2[1]}, 3);
			graphics2d.setColor(Color.BLUE);
			graphics2d.fillPolygon(triangle);
			graphics2d.setColor(Color.BLACK);
			graphics2d.draw(triangle);
		}
	}

	private class Clicked implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			double number = 0;
			try {number = Integer.decode(value.getText());} catch (Exception ex) {number = Math.PI/6;}

			if(e.getSource().equals(rotateLeftButton)) {
				bot.rotate(number);
			} else if(e.getSource().equals(rotateRightButton)) {
				bot.rotate(-1*number);
			} else if(e.getSource().equals(moveButton)) {
				try {number = Integer.decode(value.getText());} catch (Exception ex) {number = 10;}
				bot.move((int) number);
			} 
			redraw();
		}
	}

}
