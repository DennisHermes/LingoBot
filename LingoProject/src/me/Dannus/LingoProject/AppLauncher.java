package me.Dannus.LingoProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AppLauncher {

	static JLabel loadingText = new JLabel("Woorden binnenhalen...", SwingConstants.CENTER);
	
	static JFrame frame = new JFrame("Lingo bot");
	static Container defaultPane = frame.getContentPane();
	
	public static void lauch() {
		
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setLocationRelativeTo(null);
		frame.setSize(500, 500);
		
		try {
			URL url = new URL("https://media.cdnandroid.com/05/fc/35/b2/imagen-lingo-word-game-0big.jpg");
			Image image = ImageIO.read(url);
			frame.setIconImage(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		loadingScreen();
		
		frame.setVisible(true);
	}
	
	public static void loadingScreen() {
		loadingText.setForeground(new Color(255, 255, 255, 255));
		loadingText.setFont(new Font("Courier", Font.PLAIN, 20));
		
		Container loadingPane = defaultPane;
		loadingPane.add(BorderLayout.CENTER, loadingText);
		frame.setContentPane(loadingPane);
	}
	
	public static void fadeOut(JLabel l) {
		for (int i = 255; i > 1; i--) {
			l.setForeground(new Color(255, 255, 255, i));
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}