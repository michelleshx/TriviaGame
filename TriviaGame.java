/**
 * TriviaGame
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Font;
import java.io.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;

public class TriviaGame {
	// declare class level object and variables
	static JFrame frame1 = new JFrame ("Start Page");
	static JFrame frame2 = new JFrame ("Game Page");
	static JFrame frame3 = new JFrame ("Game Over Page");
	static JLabel welcomeLbl, lblTitle1, lblInstruct1, lblNamePrompt1, lblTitle2, lblInstruct2, livesLbl, scoreLbl, qLbl, picLbl, leaderboardLbl, gameOverLbl, resultsLbl, lblReturningPlayer, orLbl1, lblNamePrompt2, orLbl2;
	static JLabel[] rankLbl = new JLabel [10];
	static JLabel[] blankLbl = new JLabel [29];
	static JButton goBtn, sbmtBtn, playAgainBtn1, playAgainBtn2, quitBtn;
	static JButton[] btn = new JButton [20];
	static JTextField nameInput1, nameInput2;
	static JRadioButton a, b, c, d;
	static String[] name = new String[10];
	static ButtonGroup answer;
	static int questionNum = 0, lives = 3, gameNum = 0;
	static int[] score = new int[10];

	private static void guiApp () {

		// create a line border with the specified color and width
		Border border1 = BorderFactory.createLineBorder(Color.decode("#000000"), 10);

		//Create and set up the 3 frames
		frame1.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
		frame2.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame3.setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);

		//-------------------------------------------------------------------------------------------------------------------------------------
		//Panels for Login Screen (frame 1) 
		final JPanel panel1 = new JPanel (new GridLayout (8, 1));
		panel1.setBackground (Color.decode("#000000"));
		final JPanel panel2 = new JPanel (new GridLayout (1, 3));
		panel2.setBackground (Color.decode("#000000"));
		final JPanel panel3 = new JPanel (new GridLayout (1, 3));
		panel3.setBackground (Color.decode("#000000"));

		//Components for Login Screen (frame 1)
		welcomeLbl = new JLabel ("Welcome to ", JLabel.CENTER);
		welcomeLbl.setForeground (Color.decode("#ffffff"));
		welcomeLbl.setFont(titleFont(9));
		lblTitle1 = new JLabel ("The Hardest Quiz", JLabel.CENTER);
		lblTitle1.setFont(titleFont(16));
		lblTitle1.setForeground (Color.decode("#f500ff"));
		lblInstruct1 = new JLabel ("Can you answer all 20 questions correctly?", JLabel.CENTER);
		lblInstruct1.setForeground (Color.decode("#ffffff"));
		lblInstruct1.setFont(titleFont(9));
		blankLbl[0] = new JLabel ("");
		lblNamePrompt1 = new JLabel ("When you are ready, please enter your name: ", JLabel.CENTER);
		lblNamePrompt1.setForeground (Color.decode("#ffffff"));
		lblNamePrompt1.setFont(titleFont(9));
		blankLbl[1] = new JLabel ("");
		nameInput1 = new JTextField ("");
		blankLbl[2] = new JLabel (" ");
		blankLbl[3] = new JLabel (" ");
		goBtn = new JButton ("Go");
		goBtn.setBackground (Color.decode("#8a00ff"));
		goBtn.setForeground (Color.decode("#ffffff"));
		goBtn.setFont(titleFont(9));
		blankLbl[4] = new JLabel (" ");
		blankLbl[5] = new JLabel (" ");

		//Button handler for frame 1
		final ButtonHandler onClick = new ButtonHandler ();
		goBtn.addActionListener (onClick);

		//Add components to panel 1
		panel2.add(blankLbl[1]);
		panel2.add(nameInput1);
		panel2.add(blankLbl[2]);

		panel3.add(blankLbl[3]);
		panel3.add(goBtn);
		panel3.add(blankLbl[4]);

		panel1.add (welcomeLbl);
		panel1.add (lblTitle1);
		panel1.add (lblInstruct1);
		panel1.add (blankLbl[0]);
		panel1.add (lblNamePrompt1);
		panel1.add (panel2);
		panel1.add (panel3);
		panel1.add (blankLbl[5]);

		frame1.add (panel1);
		frame1.pack ();
		frame1.setSize (450, 275);
		frame1.setResizable(false);
		frame1.setVisible (true);

		//------------------------------------------------------------------------------------------------------------------------------------------------------------------------
		//Panels for Game Screen (frame 2)
		//Top Panel
		final JPanel topPanel = new JPanel ();
		topPanel.setBackground(Color.decode("#000000"));
		topPanel.setBorder(border1);

		//Components for Top Panel
		lblTitle2 = new JLabel ("The Hardest Quiz", JLabel.CENTER);
		lblTitle2.setFont(titleFont(36));
		lblTitle2.setForeground(Color.decode("#f500ff"));

		//Add components to Top Panel
		topPanel.add(lblTitle2);

		//Mid Panel
		final JPanel midPanel = new JPanel (new GridLayout (13, 1));
		midPanel.setBackground(Color.decode("#000000"));
		midPanel.setBorder(border1);
		final JPanel panel4 = new JPanel (new GridLayout (1, 3));
		panel4.setBackground(Color.decode("#000000"));
		final JPanel panel5 = new JPanel (new GridLayout (1, 3));
		panel5.setBackground(Color.decode("#000000"));
		final JPanel panel6 = new JPanel (new GridLayout (1, 3));
		panel6.setBackground(Color.decode("#000000"));
		final JPanel panel7 = new JPanel (new GridLayout (1, 3));
		panel7.setBackground(Color.decode("#000000"));
		final JPanel panel8 = new JPanel (new GridLayout (1, 3));
		panel8.setBackground(Color.decode("#000000"));
		final JPanel panel9 = new JPanel (new GridLayout (1, 3));
		panel9.setBackground(Color.decode("#000000"));
		final JPanel panel10 = new JPanel (new GridLayout (1, 5));
		panel10.setBackground(Color.decode("#000000"));
		final JPanel panel11 = new JPanel (new GridLayout (1, 5));
		panel11.setBackground(Color.decode("#000000"));
		final JPanel panel12 = new JPanel (new GridLayout (1, 5));
		panel12.setBackground(Color.decode("#000000"));
		final JPanel panel13 = new JPanel (new GridLayout (1, 5));
		panel13.setBackground(Color.decode("#000000"));

		//Components for MidPanel
		livesLbl = new JLabel ("♥ ♥ ♥");
		livesLbl.setForeground (Color.decode("#ffffff"));
		livesLbl.setFont(titleFont(9));
		livesLbl.setBorder(border1);
		blankLbl[6] = new JLabel ("");
		scoreLbl = new JLabel ("Your score: -");
		scoreLbl.setForeground (Color.decode("#ffffff"));
		scoreLbl.setFont(titleFont(9));
		qLbl = new JLabel ("Click on a question to begin", JLabel.CENTER);
		qLbl.setForeground (Color.decode("#ffffff"));
		qLbl.setFont(titleFont(9));
		blankLbl[7] = new JLabel ("");
		blankLbl[8] = new JLabel ("");
		blankLbl[9] = new JLabel ("");
		blankLbl[10] = new JLabel ("");
		blankLbl[11] = new JLabel ("");
		blankLbl[12] = new JLabel ("");
		blankLbl[13] = new JLabel ("");
		blankLbl[14] = new JLabel ("");

		//set up radio buttons
		a = new JRadioButton ("A)", false);
		a.setOpaque(false);
		a.setBorder(border1);
		a.setFont(titleFont(9));
		a.setForeground (Color.decode("#ffffff"));
		b = new JRadioButton ("B)", false);
		b.setOpaque(false);
		b.setBorder(border1);
		b.setFont(titleFont(9));
		b.setForeground (Color.decode("#ffffff"));
		c = new JRadioButton ("C)", false);
		c.setOpaque(false);
		c.setBorder(border1);
		c.setFont(titleFont(9));
		c.setForeground (Color.decode("#ffffff"));
		d = new JRadioButton ("D)", false);
		d.setOpaque(false);
		d.setBorder(border1);
		d.setFont(titleFont(9));
		d.setForeground (Color.decode("#ffffff"));
		
		//set up logical relationship for group
		answer = new ButtonGroup();
		answer.add (a);
		answer.add (b);
		answer.add (c);
		answer.add (d);
		disableBtns();

		blankLbl[15] = new JLabel ("");
		blankLbl[16] = new JLabel ("");
		sbmtBtn = new JButton ("Submit");
		sbmtBtn.setFont(titleFont(9));
		sbmtBtn.setBackground (Color.decode("#b700ff"));
		sbmtBtn.setForeground (Color.decode("#ffffff"));
		blankLbl[17] = new JLabel ("");
		blankLbl[18] = new JLabel ("");

		//create jButtons and addActionListener for buttons on frame 2
		String x; 
		for (int i = 0; i < 20; i++) {
			x = Integer.toString(i+1);
			btn[i] = new JButton (x);
			btn[i].addActionListener (onClick);
			btn[i].setBackground (Color.decode("#6700ff"));
			btn[i].setForeground (Color.decode("#ffffff"));
			btn[i].setFont(titleFont(9));
//			btn[i].setBorder(border4);
		}
		blankLbl[11] = new JLabel ("");

		//add ActionListener for submit button
		sbmtBtn.addActionListener(onClick);

		//smaller panels on Mid Panel
		//lives and score
		panel4.add(livesLbl);
		panel4.add(blankLbl[6]);
		panel4.add(scoreLbl);

		//Centered Radio buttons
		panel5.add(blankLbl[7]);
		panel5.add(a);
		panel5.add(blankLbl[8]);

		panel6.add(blankLbl[9]);
		panel6.add(b);
		panel6.add(blankLbl[10]);

		panel7.add(blankLbl[11]);
		panel7.add(c);
		panel7.add(blankLbl[12]);

		panel8.add(blankLbl[13]);
		panel8.add(d);
		panel8.add(blankLbl[14]);

		//Centered submit button
		panel9.add(blankLbl[15]);
		panel9.add(sbmtBtn);
		panel9.add(blankLbl[16]);

		//Question buttons
		for (int i = 0; i < 5; i++) {
			panel10.add(btn[i]);
		}
		for (int i = 5; i < 10; i++) {
			panel11.add(btn[i]);
		}
		for (int i = 10; i < 15; i++) {
			panel12.add(btn[i]);
		}
		for (int i = 15; i < 20; i++) {
			panel13.add(btn[i]);
		}

		//Add components to Mid Panel
		midPanel.add(panel4);
		midPanel.add(qLbl);
		midPanel.add(panel5);
		midPanel.add(panel6);
		midPanel.add(panel7);
		midPanel.add(panel8);
		midPanel.add(panel9);
		midPanel.add(blankLbl[17]);
		midPanel.add(panel10);
		midPanel.add(panel11);
		midPanel.add(panel12);
		midPanel.add(panel13);
		midPanel.add(blankLbl[18]);

		//Right Leaderboard Panel
		final JPanel rightPanel = new JPanel (new GridLayout (11, 1));
		rightPanel.setBackground(Color.decode("#000000"));
		rightPanel.setBorder(border1);

		//Components for Leaderboard
		leaderboardLbl = new JLabel ("Leaderboard", JLabel.LEFT);
		leaderboardLbl.setBorder(border1);
		leaderboardLbl.setForeground (Color.decode("#ffffff"));
		leaderboardLbl.setFont(titleFont(9));
		for (int i = 0; i < 10; i ++) {
			rankLbl[i] = new JLabel ("");
			rankLbl[i].setForeground (Color.decode("#ffffff"));
			rankLbl[i].setFont(titleFont(9));
//			rankLbl[i].setBorder(border2);
		}

		//Add components to leaderboard panel
		rightPanel.add(leaderboardLbl);
		for (int i = 0; i < 10; i ++) {
			rightPanel.add(rankLbl[i]);
		}
		rightPanel.setPreferredSize(new Dimension(200, 500));

		frame2.add (topPanel, BorderLayout.PAGE_START);
		frame2.add (midPanel, BorderLayout.CENTER);
		frame2.add(rightPanel, BorderLayout.LINE_END);
		frame2.pack ();
		frame2.setSize (1000, 500);
		//		frame2.setResizable(true);
		frame2.setVisible (false);

		//Frame 3 (Play again prompt) ------------------------------------------------------------------------------------------------------------------------
		final JPanel panelPlayAgain = new JPanel (new GridLayout (12, 1));
		panelPlayAgain.setBackground(Color.decode("#000000"));
		final JPanel panel14 = new JPanel (new GridLayout (1, 3));
		panel14.setBackground (Color.decode("#000000"));
		final JPanel panel15 = new JPanel (new GridLayout (1, 3));
		panel15.setBackground (Color.decode("#000000"));
		final JPanel panel16 = new JPanel (new GridLayout (1, 3));
		panel16.setBackground (Color.decode("#000000"));
		final JPanel panel17 = new JPanel (new GridLayout (1, 3));
		panel17.setBackground (Color.decode("#000000"));

		//create components for play again frame
		gameOverLbl = new JLabel ("Game Over!", JLabel.CENTER);
		gameOverLbl.setFont(titleFont(16));
		gameOverLbl.setForeground (Color.decode("#b700ff"));
		resultsLbl = new JLabel ("Your score: ", JLabel.CENTER);
		resultsLbl.setFont(titleFont(9));
		resultsLbl.setForeground (Color.decode("#8a00ff"));
		blankLbl[19] = new JLabel ("");
		blankLbl[20] = new JLabel ("");
		lblReturningPlayer = new JLabel ("Same Player?", JLabel.CENTER);
		lblReturningPlayer.setFont(titleFont(9));
		lblReturningPlayer.setForeground (Color.decode("#ffffff"));
		playAgainBtn1 = new JButton ("Play Again");
		playAgainBtn1.setFont(titleFont(9));
		playAgainBtn1.setBackground (Color.decode("#b700ff"));
		playAgainBtn1.setForeground (Color.decode("#ffffff"));
		blankLbl[21] = new JLabel ("");
		orLbl1 = new JLabel ("or", JLabel.CENTER);
		orLbl1.setFont(titleFont(9));
		orLbl1.setForeground (Color.decode("#ffffff"));
		lblNamePrompt2 = new JLabel ("New Player Name:", JLabel.CENTER);
		lblNamePrompt2.setFont(titleFont(9));
		lblNamePrompt2.setForeground (Color.decode("#ffffff"));
		blankLbl[22] = new JLabel ("");
		nameInput2 = new JTextField ("");
		blankLbl[23] = new JLabel ("");
		blankLbl[24] = new JLabel ("");
		playAgainBtn2 = new JButton ("Play");
		playAgainBtn2.setFont(titleFont(9));
		playAgainBtn2.setBackground (Color.decode("#b700ff"));
		playAgainBtn2.setForeground (Color.decode("#ffffff"));
		blankLbl[25] = new JLabel ("");
		orLbl2 = new JLabel ("or", JLabel.CENTER);
		orLbl2.setFont(titleFont(9));
		orLbl2.setForeground (Color.decode("#ffffff"));
		blankLbl[26] = new JLabel ("");
		quitBtn = new JButton ("Quit");
		quitBtn.setFont(titleFont(9));
		quitBtn.setBackground (Color.decode("#b700ff"));
		quitBtn.setForeground (Color.decode("#ffffff"));
		blankLbl[27] = new JLabel ("");
		blankLbl[28] = new JLabel ("");

		//Button handler for frame 3
		playAgainBtn1.addActionListener (onClick);
		playAgainBtn2.addActionListener (onClick);
		quitBtn.addActionListener (onClick);

		//first centered play again button
		panel14.add(blankLbl[20]);
		panel14.add(playAgainBtn1);
		panel14.add(blankLbl[21]);

		//centered text field
		panel15.add(blankLbl[22]);
		panel15.add(nameInput2);
		panel15.add(blankLbl[23]);

		//second centered play again button 
		panel16.add(blankLbl[24]);
		panel16.add(playAgainBtn2);
		panel16.add(blankLbl[25]);

		//centered quit button
		panel17.add(blankLbl[26]);
		panel17.add(quitBtn);
		panel17.add(blankLbl[27]);

		//add components to main panel on frame 3
		panelPlayAgain.add(gameOverLbl);
		panelPlayAgain.add(resultsLbl);
		panelPlayAgain.add(blankLbl[19]);
		panelPlayAgain.add(lblReturningPlayer);
		panelPlayAgain.add(panel14);
		panelPlayAgain.add(orLbl1);
		panelPlayAgain.add(lblNamePrompt2);
		panelPlayAgain.add(panel15);
		panelPlayAgain.add(panel16);
		panelPlayAgain.add(orLbl2);
		panelPlayAgain.add(panel17);
		panelPlayAgain.add(blankLbl[28]);

		frame3.add (panelPlayAgain);
		frame3.pack ();
		frame3.setSize (500, 350);
		frame3.setResizable(false);
		frame3.setVisible (false);		
	}


	private static class ButtonHandler implements ActionListener
	{
		public void actionPerformed (final ActionEvent e)
		{
			final String whichOne = e.getActionCommand ();

			if (whichOne.equals ("Go")) {
				//open frame 2
				frame2.setVisible (true);
				frame1.setVisible (false);

				//get textinput
				name[gameNum] = nameInput1.getText ();
			}

			//display the questions
			if (whichOne.equals("1")) {
				enableBtns();
				qLbl.setText ("1. Who is the Nintendo character, Mario's, brother?");
				a.setText("A) Waluigi");
				b.setText("B) Luigi");//correct
				c.setText("C) Wario");
				d.setText("D) Yoshi");
				btn[0].setEnabled (false);
				btn[0].setBackground (Color.decode("#4800b3"));
				questionNum = 1;
			}

			else if (whichOne.equals("2")) {
				enableBtns();
				qLbl.setText ("2. What is the largest ocean?");
				a.setText("A) Atlantic");
				b.setText("B) Indian");
				c.setText("C) Southern");
				d.setText("D) Pacific");//correct
				btn[1].setEnabled (false);
				btn[1].setBackground (Color.decode("#4800b3"));
				questionNum = 2;
			}

			else if (whichOne.equals("3")) {
				enableBtns();
				qLbl.setText ("3. How many bones are in the human body?");
				a.setText("A) 270");
				b.setText("B) 204");
				c.setText("C) 267");
				d.setText("D) 206");//correct
				btn[2].setEnabled (false);
				btn[2].setBackground (Color.decode("#4800b3"));
				questionNum = 3;
			}

			else if (whichOne.equals("4")) {
				enableBtns();
				qLbl.setText ("4. Who won the 2020 oscars for Best Supporting Actress?");
				a.setText("A) Kathy Bates");
				b.setText("B) Laura Dern");//correct
				c.setText("C) Florence Pugh");
				d.setText("D) Margot Robbie");
				btn[3].setEnabled (false);
				btn[3].setBackground (Color.decode("#4800b3"));
				questionNum = 4;
			}

			else if (whichOne.equals("5")) {
				enableBtns();
				qLbl.setText ("5. How many days are in a fortnight?");
				a.setText("A) 14");//correct
				b.setText("B) 7");
				c.setText("C) 10");
				d.setText("D) 4");
				btn[4].setEnabled (false);
				btn[4].setBackground (Color.decode("#4800b3"));
				questionNum = 5;
			}

			else if (whichOne.equals("6")) {
				enableBtns();
				qLbl.setText ("6. Who is Google's CEO");
				a.setText("A) Larry Page");
				b.setText("B) Sergey Bin");
				c.setText("C) Sundar Pichai"); //correct
				d.setText("D) Tim Cook");
				btn[5].setEnabled (false);
				btn[5].setBackground (Color.decode("#4800b3"));
				questionNum = 6;
			}

			else if (whichOne.equals("7")) {
				enableBtns();
				qLbl.setText ("7. What is 6!");
				a.setText("A) 6!");
				b.setText("B) 1");
				c.setText("C) 720");//correct
				d.setText("D) 5040");
				btn[6].setEnabled (false);
				btn[6].setBackground (Color.decode("#4800b3"));
				questionNum = 7;
			}

			else if (whichOne.equals("8")) {
				enableBtns();
				qLbl.setText ("8. In both Japan and Europe, a butterfly was seen as the personification of what?");
				a.setText("A) Good luck");
				b.setText("B) A person's soul");//correct
				c.setText("C) Mother Nature");
				d.setText("D) God");
				btn[7].setEnabled (false);
				btn[7].setBackground (Color.decode("#4800b3"));
				questionNum = 8;
			}

			else if (whichOne.equals("9")) {
				enableBtns();
				qLbl.setText ("9. What is the order of colours on the Russian flag?");
				a.setText("A) White, Blue, Red");//correct
				b.setText("B) Blue, Red, White");
				c.setText("C) White, Red, Blue");
				d.setText("D) Red, White, Blue");
				btn[8].setEnabled (false);
				btn[8].setBackground (Color.decode("#4800b3"));
				questionNum = 9;
			}

			else if (whichOne.equals("10")) {
				enableBtns();
				qLbl.setText ("10. In the Disney movie, Tangled, what is Flynn's real name?");
				a.setText("A) Eric");
				b.setText("B) Kristoff");
				c.setText("C) Claude");
				d.setText("D) Eugene");//correct
				btn[9].setEnabled (false);
				btn[9].setBackground (Color.decode("#4800b3"));
				questionNum = 10;
			}

			else if (whichOne.equals("11")) {
				enableBtns();
				qLbl.setText ("11. What was Stephen King's first published novel?");
				a.setText("A) The Shining");
				b.setText("B) Carrie");//correct
				c.setText("C) It");
				d.setText("D) Skeleton Crew");
				btn[10].setEnabled (false);
				btn[10].setBackground (Color.decode("#4800b3"));
				questionNum = 11;
			}

			else if (whichOne.equals("12")) {
				enableBtns();
				qLbl.setText ("12. Bananas are scientifically classified as a: ");
				a.setText("A) Pepo");
				b.setText("B) Drupe");
				c.setText("C) Citrus");
				d.setText("D) Berry"); //correct
				btn[11].setEnabled (false);
				btn[11].setBackground (Color.decode("#4800b3"));
				questionNum = 12;
			}

			else if (whichOne.equals("13")) {
				enableBtns();
				qLbl.setText ("13. Today, most Christians celebrate on December 25 in what calendar?");
				a.setText("A) Julian calendar");
				b.setText("B) Roman calendar");
				c.setText("C) Babylonian calendar");
				d.setText("D) Gregorian calendar");//correct
				btn[12].setEnabled (false);
				btn[12].setBackground (Color.decode("#4800b3"));
				questionNum = 13;
			}

			else if (whichOne.equals("14")) {
				enableBtns();
				qLbl.setText ("14. Which Harry Potter movie was the most expensive to produce?");
				a.setText("A) Deathly Hallows Part 1");
				b.setText("B) Deathly Hallows Part 2");
				c.setText("C) Half-Blood Prince");//correct
				d.setText("D) Goblet of Fire");
				btn[13].setEnabled (false);
				btn[13].setBackground (Color.decode("#4800b3"));
				questionNum = 14;
			}

			else if (whichOne.equals("15")) {
				enableBtns();
				qLbl.setText ("15. What is a group of frogs called?");
				a.setText("A) Army");//correct
				b.setText("B) Hoard");
				c.setText("C) Flock");
				d.setText("D) Herd");
				btn[14].setEnabled (false);
				btn[14].setBackground (Color.decode("#4800b3"));
				questionNum = 15;
			}

			else if (whichOne.equals("16")) {
				enableBtns();
				qLbl.setText ("16. In what year did construction on the first Disney Land begin?");
				a.setText("A) 1963");
				b.setText("B) 1978");
				c.setText("C) 1949");
				d.setText("D) 1954");//correct
				btn[15].setEnabled (false);
				btn[15].setBackground (Color.decode("#4800b3"));
				questionNum = 16;
			}

			else if (whichOne.equals("17")) {
				enableBtns();
				qLbl.setText ("17. At the beginning of the 1990s which country had most camels?");
				a.setText("A) Egypt");
				b.setText("B) Somalia");//correct
				c.setText("C) Morocco");
				d.setText("D) Ethiopia");
				btn[16].setEnabled (false);
				btn[16].setBackground (Color.decode("#4800b3"));
				questionNum = 17;
			}

			else if (whichOne.equals("18")) {
				enableBtns();
				qLbl.setText ("18. Who had the top-selling album artist of the 1970s, according to Billboard?");
				a.setText("A) The Beatles");
				b.setText("B) Billy Joel");
				c.setText("C) Led Zeppelin");
				d.setText("D) Elton John");//correct
				btn[17].setEnabled (false);
				btn[17].setBackground (Color.decode("#4800b3"));
				questionNum = 18;
			}	

			else if (whichOne.equals("19")) {
				enableBtns();
				qLbl.setText ("19. How many universities are in New York City?");
				a.setText("A) 27");
				b.setText("B) 110");//correct
				c.setText("C) 67");
				d.setText("D) 105");
				btn[18].setEnabled (false);
				btn[18].setBackground (Color.decode("#4800b3"));
				questionNum = 19;
			}

			else if (whichOne.equals("20")) {
				enableBtns();
				qLbl.setText ("20. The 'Tine' in Tina Fey is short for what name?");
				a.setText("A) Albertina");
				b.setText("B) Valentina");
				c.setText("C) Bettina");
				d.setText("D) Stamatina");//correct
				btn[19].setEnabled (false);
				btn[19].setBackground (Color.decode("#4800b3"));
				questionNum = 20;
			}

			//check users answer
			else if (whichOne.equals ("Submit")) {
				if (questionNum == 1) {
					disableBtns();
					if (b.isSelected()) {
						score[gameNum]++;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 2) {
					disableBtns();
					if (d.isSelected()) {
						score[gameNum]+=2;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 3) {
					disableBtns();
					if (d.isSelected()) {
						score[gameNum]+=3;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 4) {
					disableBtns();
					if (b.isSelected()) {
						score[gameNum]+=4;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 5) {
					disableBtns();
					if (a.isSelected()) {
						score[gameNum]+=5;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 6) {
					disableBtns();
					if (c.isSelected()) {
						score[gameNum]+=6;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 7) {
					disableBtns();
					if (c.isSelected()) {
						score[gameNum]+=7;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 8) {
					disableBtns();
					if (b.isSelected()) {
						score[gameNum]+=8;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 9) {
					disableBtns();
					if (a.isSelected()) {
						score[gameNum]+=9;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 10) {
					disableBtns();
					if (d.isSelected()) {
						score[gameNum]+=10;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 11) {
					disableBtns();
					if (b.isSelected()) {
						score[gameNum]+=11;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 12) {
					disableBtns();
					if (d.isSelected()) {
						score[gameNum]+=12;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 13) {
					disableBtns();
					if (d.isSelected()) {
						score[gameNum]+=13;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 14) {
					disableBtns();
					if (c.isSelected()) {
						score[gameNum]+=14;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 15) {
					disableBtns();
					if (a.isSelected()) {
						score[gameNum]+=15;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 16) {
					disableBtns();
					if (d.isSelected()) {
						score[gameNum]+=16;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 17) {
					disableBtns();
					if (b.isSelected()) {
						score[gameNum]+=17;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 18) {
					disableBtns();
					if (d.isSelected()) {
						score[gameNum]+=18;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 19) {
					disableBtns();
					if (b.isSelected()) {
						score[gameNum]+=19;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}

				else if (questionNum == 20) {
					disableBtns();
					if (d.isSelected()) {
						score[gameNum]+=20;
						correct(score);
					}
					else {
						incorrect();
					}
					answer.clearSelection();
				}
			}

			//Playing the game again
			if (whichOne.equals ("Play Again")) {
				resetGame();
				name[gameNum] = name[gameNum-1];
			}
			else if (whichOne.equals ("Play")) {
				resetGame();
				name[gameNum] = nameInput2.getText ();
			}
			else if (whichOne.equals ("Quit")) {
				System.exit(0);
			}
		}
	}

	public static void correct(final int[] score) {
		scoreLbl.setText("Your score: " + score[gameNum]);
		qLbl.setText ("Correct, please click the next question");
	}

	public static void incorrect() {
		lives--;

		if (lives == 2) {
			qLbl.setText ("Incorrect");
			livesLbl.setText("♥ ♥");
		}
		else if (lives == 1) {
			qLbl.setText ("Incorrect");
			livesLbl.setText("♥");
		}
		else if (lives == 0) {
			livesLbl.setText("");
			qLbl.setText ("Game over");

			//Disable buttons
			for (int i = 0; i < 20; i++) {
				btn[i].setEnabled(false);
			}
			//display gameover screen
			nameInput2.setText("");
			resultsLbl.setText("Your score: " + score[gameNum]);
			frame3.setVisible (true);

			//update leaderboard
			if (gameNum > 0) {
				sortScores();
			}
			else {
				rankLbl[gameNum].setText((gameNum + 1) + ". " + name[gameNum] + "     " + score[gameNum]);
			}
		}
	} 

	//procedural method to enable radio buttons
	public static void enableBtns() {
		a.setEnabled(true);
		b.setEnabled(true);
		c.setEnabled(true);
		d.setEnabled(true);
	}

	//procedural method to disable radio buttons after answer is submitted
	public static void disableBtns() {
		a.setEnabled(false);
		b.setEnabled(false);
		c.setEnabled(false);
		d.setEnabled(false);
	}

	public static void resetGame() {
		//enable buttons
		for (int i = 0; i < 20; i++) {
			btn[i].setEnabled(true);
			btn[i].setBackground (Color.decode("#6700ff"));
		}
		
		//reset components
		gameNum++;
		score[gameNum] = 0;
		frame3.setVisible (false);
		qLbl.setText ("Choose a question to begin");
		livesLbl.setText("♥ ♥ ♥");
		scoreLbl.setText("Your score: " + score[gameNum]);
		a.setText("A) ");
		b.setText("B) ");
		c.setText("C) ");
		d.setText("D) ");
		lives = 3;
	}

	public static void sortScores() {
		int hold = 0;
		String temp;
		//bubble sort scores
		for (int i = 0; i < gameNum; i++) {
			for (int j = 0; j < gameNum; j++) { //j < gameNum-1
				if (score[j] < score [j+1]) {
					hold = score[j];
					temp = name[j];
					score[j] = score[j+1];
					name[j] = name[j+1];
					score[j+1] = hold;
					name[j+1] = temp;
				}
			}
		}
		//display sorted leaderboard
		for (int i = 0; i < gameNum + 1; i++) {
			rankLbl[i].setText((i + 1) + ". " + name[i] + "     " + score[i]);
		}
	}

	public static Font titleFont(final int size) {
		try {
			final Font titleFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("C:\\Users\\miche\\eclipse-workspace\\Unit3\\TitleFont1.ttf"))).deriveFont(Font.PLAIN, size);
			return titleFont;
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return new Font("Tahoma", Font.BOLD, size);	        
	}

	public static Font startFont(final int size) {
		try {
			final Font startFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("C:\\Users\\miche\\eclipse-workspace\\Unit3\\TitleFont1.ttf"))).deriveFont(Font.PLAIN, size);
			return startFont;
		} catch (final Exception ex) {
			ex.printStackTrace();
		}
		return new Font("Tahoma", Font.BOLD, size);	        
	}

	public static void main (final String[] args)
	{
		javax.swing.SwingUtilities.invokeLater (new Runnable ()
		{
			public void run () 
			{
				guiApp ();
			}
		}
				);
	} // main method
}
