package com.amittaigames.graph;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.amittaigames.math.SlopeIntercept;

public class Menu {

	private static JFrame frame;
	
	public static void init(String title, int width, int height, int x, int y) {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(15, 1));
		
		JButton btnPoint = new JButton("Add Point");
		JButton btnSlopeLine = new JButton("Add Slope Line");
		JButton btnBestFitLine =  new JButton("Add Best Fit Line");
		JButton btnClearGraph = new JButton("Clear Graph");
		
		panel.add(btnPoint);
		panel.add(btnSlopeLine);
		panel.add(btnBestFitLine);
		panel.add(btnClearGraph);
		
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setContentPane(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(x, y);
		frame.setResizable(false);
		frame.setVisible(true);
		
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String loc = JOptionPane.showInputDialog("Enter coordinates for a point").replace(" ", "");
				String[] locs = loc.split(",");
				new Point(Float.parseFloat(locs[0]), Float.parseFloat(locs[1]));
			}
		});
		
		btnClearGraph.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Line.list.clear();
				Point.list.clear();
			}
		});
		
		btnBestFitLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				float avgax = 0;
				for (int i = 0; i < Point.list.size() / 2; i++) {
					avgax += Point.list.get(i).getX();
				}
				avgax /= Point.list.size() / 2;
				
				float avgay = 0;
				for (int i = 0; i < Point.list.size() / 2; i++) {
					avgay += Point.list.get(i).getY();
				}
				avgay /= Point.list.size() / 2;
				
				float avgbx = 0;
				for (int i = Point.list.size() / 2; i < Point.list.size(); i++) {
					avgbx += Point.list.get(i).getX();
				}
				avgbx /= Point.list.size() / 2;
				
				float avgby = 0;
				for (int i = Point.list.size() / 2; i < Point.list.size(); i++) {
					avgby += Point.list.get(i).getY();
				}
				avgby /= Point.list.size() / 2;
				
				float width = Graph.current.getWidthOffset();
				float height = Graph.current.getHeightOffset();
				
				float slope = SlopeIntercept.findSlope(new Vector(avgax, avgay), 
						new Vector(avgbx, avgby));
				float yint = SlopeIntercept.findInterceptY(avgax * width, avgay * height, slope);
				Vector x = new Vector(0, yint);
				Vector y =  new Vector(Main.WIDTH, SlopeIntercept.solveForY(Main.WIDTH, slope, yint));
				new Line(x, y);
			}
		});
		
		btnSlopeLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Point.list.size() < 2) {
					JOptionPane.showMessageDialog(null, "There aren't enough points!");
				} else {
					Point a = Point.list.get(0);
					Point b = Point.list.get(1);
					float slope = SlopeIntercept.findSlope(a, b);
					float yint = SlopeIntercept.findInterceptY(a.getRealX(), a.getRealY(), slope);
					Vector x = new Vector(0, yint);
					Vector y = new Vector(Main.WIDTH, SlopeIntercept.solveForY(Main.WIDTH, slope, yint));
					new Line(x, y);
				}
			}
		});
	}
	
}