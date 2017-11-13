package com.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

public class MyButton extends JButton {

	public MyButton(String name) {
		// TODO Auto-generated constructor stub
		setText(name);
		setBackground(Color.LIGHT_GRAY);
		setPreferredSize(new Dimension(95, 40));
		setFont(new Font("Microsoft YaHei UI", 1, 16));
		setBorder(null);
		
		
	}
}
