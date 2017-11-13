package com.frames;

import java.awt.Dimension;

import javax.swing.JFrame;

public class MainFrame extends JFrame {

	public MainFrame(String name) {
		// TODO Auto-generated constructor stub
		setTitle(name);
		setVisible(true);
		setSize(new Dimension(400, 600));
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
