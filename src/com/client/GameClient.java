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

import com.game.GuessNumber;
import com.gui.MainFrame;
import com.gui.MyButton;

public class GameClient extends MainFrame implements ActionListener {

	MyButton btnConn = new MyButton("连接服务器");
	MyButton btnStart = new MyButton("开始游戏");
	MyButton btnRestart = new MyButton("重新开始");
	MyButton btnGuess = new MyButton("猜数");
	MyButton btnStop = new MyButton("结束游戏");

	TextField guessBox = new TextField();
	TextArea messageBox = new TextArea("", 0, 0, TextArea.SCROLLBARS_VERTICAL_ONLY);

	GuessNumber game;// 游戏对象

	public GameClient() {
		super("Guess Number Client");

		guessBox.setPreferredSize(new Dimension(280, 40));
		guessBox.setFont(new Font("Microsoft YaHei UI", 0, 36));

		messageBox.setEditable(false);
		messageBox.setPreferredSize(new Dimension(400, 400));
		messageBox.setFont(new Font("Microsoft YaHei UI", 0, 24));

		this.add(btnStart);
		this.add(btnRestart);
		this.add(btnStop);
		this.add(btnConn);
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
		btnStop.setActionCommand("Stop");
		btnStop.addActionListener(this);
		btnGuess.setActionCommand("Guess");
		btnGuess.setBackground(new Color(0, 132, 255));
		btnGuess.addActionListener(this);

		guessBox.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				int keyChar = e.getKeyChar();
				if (keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9 && guessBox.getText().length() < 3) {

				} else if (keyChar == KeyEvent.VK_ENTER) {
					actionPerformed(new ActionEvent(btnGuess, 0, "Guess"));
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
			messageBox.setText("");
			startGame();
			break;
		case "Restart":
			messageBox.setText("");
			showMessage("游戏已重启!!");
			startGame();
			break;
		case "About":
			aboutGame();
			break;
		case "Stop":
			stopGame();
			break;
		case "Guess":
			if (guessBox.getText().length() == 0) {
				showMessage("请输入100以内的数字");
				break;
			}
			guessNumber(Integer.parseInt(guessBox.getText()));
			break;
		case "Connect":
			getConnection();

		default:

			break;
		}

	}

	// 连接服务器
	private void getConnection() {
		// TODO Auto-generated method stub

	}

	// 开始猜数
	private void guessNumber(int number) {
		// TODO Auto-generated method stub
		if (game == null) {
			startGame();
		}

		showMessage("你猜的数是:" + number);
		switch (game.guess(number)) {
		case 1:
			showMessage("猜大了");
			break;
		case -1:
			showMessage("猜小了");
			break;
		case 0:
			showMessage("恭喜你！猜中了");
			showMessage("您共猜了" + game.getCount() + "次");
			showMessage("正确答案是:" + game.getAnswerNumber());
			break;
		}
		guessBox.setText("");

	}

	// 结束游戏
	private void stopGame() {
		// TODO Auto-generated method stub
		game = null;
		showMessage("游戏已结束！！");
		

	}

	// 关于
	private void aboutGame() {
		// TODO Auto-generated method stub

	}

	// 开始游戏
	private void startGame() {
		// TODO Auto-generated method stub
		showMessage("游戏开始!!");
		showMessage("请输入100以内的数进行游戏!!");
		game = new GuessNumber();

	}

	public void showMessage(String message) {
		messageBox.append(message + "\n");
	}

}
