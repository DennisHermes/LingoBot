package me.Dannus.LingoProject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AppLauncher {

	static JLabel loadingText = new JLabel("Woorden binnenhalen...", SwingConstants.CENTER);
	
	static JFrame frame = new JFrame("Lingo bot");
	
	public static void lauch() {
		
		
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		Container loadingPane = new JPanel(frame.getContentPane().getLayout());
		loadingPane.setBackground(Color.DARK_GRAY);
		
		loadingText.setForeground(new Color(255, 255, 255, 255));
		loadingText.setFont(new Font("Courier", Font.PLAIN, 20));
		loadingPane.add(BorderLayout.CENTER, loadingText);
		
		frame.setContentPane(loadingPane);
		frame.revalidate();
	}
	
	public static void beginLetterScreen() {
		
		Container beginLetterPane = new JPanel(frame.getContentPane().getLayout());
		beginLetterPane.setBackground(Color.DARK_GRAY);
		
		Container buttonPane = new Container();
		buttonPane.setLayout(new GridLayout(10, 3));
		
		JLabel beginLetterText = new JLabel("Met welke letter begint het woord?", SwingConstants.CENTER);
		beginLetterText.setForeground(new Color(255, 255, 255, 0));
		beginLetterText.setFont(new Font("Courier", Font.PLAIN, 40));
		beginLetterPane.add(BorderLayout.PAGE_START, beginLetterText);
		
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < alpha.length(); i++) {
			JButton button = new JButton(alpha.charAt(i) + "");
			buttonPane.add(BorderLayout.PAGE_END, button);
			button.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
            		List<String> possible = new ArrayList<String>();
        			for (int i = 0; i < WordsManager.possibleWords.size(); i++) {
        				if (WordsManager.possibleWords.get(i).startsWith(button.getText().toLowerCase().trim())) {
        					possible.add(WordsManager.possibleWords.get(i));
        				}
        			}
        			WordsManager.possibleWords = possible;
        			wordSuggestedScreen();
	            }
	        });
		}
		beginLetterPane.add(buttonPane);
		
		frame.setContentPane(beginLetterPane);
		frame.revalidate();
		
		fadeIn(beginLetterText);
	}
	
	public static void wordSuggestedScreen() {
		
		JLabel wordSuggestedText = new JLabel("Woorden met de meeste potentie:", SwingConstants.CENTER);
		wordSuggestedText.setForeground(new Color(255, 255, 255, 255));
		wordSuggestedText.setFont(new Font("Courier", Font.PLAIN, 25));
		
		JLabel wordSuggested2Text = new JLabel("(Klik op het woord dat je gekozen hebt.)", SwingConstants.CENTER);
		wordSuggested2Text.setForeground(new Color(255, 255, 255, 255));
		wordSuggested2Text.setFont(new Font("Courier", Font.PLAIN, 15));
		
		Container textPane = new Container();
		textPane.setLayout(new GridLayout(20, 1));
		textPane.add(BorderLayout.PAGE_START, wordSuggestedText);
		textPane.add(BorderLayout.PAGE_START, wordSuggested2Text);
		
		String[] suggesting = WordSuggester.suggestWord(WordsManager.possibleWords).split(",");
		for (int i = 0; i < suggesting.length; i++) {
			JButton button = new JButton(suggesting[i] + "");
			textPane.add(BorderLayout.PAGE_END, button);
			if (i == 4) break;
		}
		
		Container wordSuggestedPane = new JPanel(frame.getContentPane().getLayout());
		wordSuggestedPane.setBackground(Color.DARK_GRAY);
		wordSuggestedPane.add(textPane);
		
		frame.setContentPane(wordSuggestedPane);
		frame.revalidate();
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
	
	public static void fadeIn(JLabel l) {
		for (int i = 0; i < 255; i++) {
			l.setForeground(new Color(255, 255, 255, i));
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}