package com.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.frames.MainFrame;
import com.frames.MyButton;

public class GameClient extends MainFrame implements ActionListener {

	MyButton btnConn = new MyButton("连接服务器");
	MyButton btnStart = new MyButton("开始游戏");
	MyButton btnRestart = new MyButton("重新开始");
	MyButton btnGuess = new MyButton("猜数");
	MyButton btnAbout = new MyButton("关于");

	// JMenuBar menuBar=new JMenuBar();
	//
	// JMenu gameMenu=new JMenu("Game");
	// JMenuItem gameStart=new JMenuItem("开始游戏");
	// JMenuItem gameRestart=new JMenuItem("重新开始");
	// JMenuItem gameStop=new JMenuItem("结束游戏");

	TextField guessBox = new TextField();
	TextArea messageBox = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);

	public GameClient() {
		super("Guess Number Client");

		guessBox.setPreferredSize(new Dimension(280, 40));
		guessBox.setFont(new Font("Microsoft YaHei UI", 0, 36));
		
		messageBox.setEditable(false);
		messageBox.setPreferredSize(new Dimension(400, 400));
		messageBox.setFont(new Font("Microsoft YaHei UI", 0, 24));

		this.add(btnStart);
		this.add(btnRestart);
		this.add(btnConn);
		this.add(btnAbout);
		this.add(messageBox);

		this.add(guessBox);
		this.add(btnGuess);

		initButtons();

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));

	}

	// 初始化按钮事件监听和按钮事件命令
	private void initButtons() {
		// TODO Auto-generated method stub
		btnStart.setActionCommand("Start");
		btnStart.addActionListener(this);
		btnRestart.setActionCommand("Restart");
		btnRestart.addActionListener(this);
		btnConn.setActionCommand("Connect");
		btnConn.addActionListener(this);
		btnAbout.setActionCommand("About");
		btnAbout.addActionListener(this);
		btnGuess.setActionCommand("Guess");
		btnGuess.setBackground(new Color(0, 132, 255));
		btnGuess.addActionListener(this);

		guessBox.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9 && guessBox.getText().length() < 3) {

				} else {
					e.consume(); // 关键，屏蔽掉非法输入
				}
			}
		});

	}

	public static void main(String[] args) {
		new GameClient();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "Start":
			startGame();
			break;
		case "Restart":
			showMessage("游戏已重启!!");
			startGame();
			break;
		case "About":
			aboutGame();
			break;
		case "Stop":
			messageBox.append("游戏已结束!!\n");
			stopGame();
			break;
		case "Guess":
			if (guessBox.getText().length() == 0) {
				showMessage("请输入100以内的数字");
				break;
			}
			guessNumber(Integer.parseInt(guessBox.getText()));
			showMessage("你猜的数是:" + guessBox.getText());
			break;
		case "Connect":
			getConnection();

		default:
			break;
		}

	}

	private void getConnection() {
		// TODO Auto-generated method stub

	}

	private void guessNumber(int number) {
		// TODO Auto-generated method stub

	}

	private void stopGame() {
		// TODO Auto-generated method stub

	}

	private void aboutGame() {
		// TODO Auto-generated method stub

	}

	private void startGame() {
		// TODO Auto-generated method stub
		showMessage("游戏开始!!");
		showMessage("请输入100以内的数进行游戏!!");

	}

	public void showMessage(String message) {
		messageBox.append(message + "\n");
	}

}
