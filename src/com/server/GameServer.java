package com.server;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.gui.MainFrame;
import com.gui.MyButton;

public class GameServer extends MainFrame implements ActionListener {

	MyButton sverStart = new MyButton("启动服务");
	MyButton sverStop = new MyButton("停止服务");
	MyButton sverPort = new MyButton("设置端口");

	TextArea messageBox = new TextArea();

	public GameServer() {
		super("Guess Number Server");

		this.add(sverStart);
		this.add(sverStop);
		this.add(sverPort);

		init();

		this.add(messageBox);

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

	}

	private void init() {
		sverStart.setActionCommand("Start");
		sverStart.addActionListener(this);
		sverStop.setActionCommand("Stop");
		sverStop.addActionListener(this);
		sverPort.setActionCommand("Port");
		sverPort.addActionListener(this);
		
		messageBox.setEditable(false);
		messageBox.setPreferredSize(new Dimension(400, 400));
		messageBox.setFont(new Font("Microsoft YaHei UI", 0, 24));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
		case "Start":
			sverStart();
			break;
		case "Stop":
			sverStop();
			break;
		case "Port":
			changePort();
			break;
		}

	}

	private void changePort() {
		// TODO Auto-generated method stub
		showMessage("ChangePort");
		
	}

	private void sverStop() {
		// TODO Auto-generated method stub
		showMessage("Stop Server");
	}

	private void sverStart() {
		// TODO Auto-generated method stub
		showMessage("Start Server");
		
	}
	
	private void showMessage(String message) {
		messageBox.append(message+"\n");
	}

	public static void main(String[] args) {
		new GameServer();
	}

}
