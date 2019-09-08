package ru.java2e;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		/*THIS IS THE MENU OF GAME*/
		JFrame frame = new JFrame("RACING V1. MENU");
		frame.setSize(200, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JPanel pa = new JPanel(new GridBagLayout());
		JButton b1 = new JButton("START RACE");
		JButton b2 = new JButton("EXIT!");
		JProgressBar bar = new JProgressBar();
		bar.setMinimum(0);
	    Player pl = new Player();//load progress.
	    Iconpanel ran = new Iconpanel();//image of the rank.
	    JScrollPane pane = new JScrollPane(ran);
	    bar.setValue(pl.point);bar.setMaximum(pl.lab);int kar = bar.getValue();
	    JLabel prog = new JLabel(pl.point+"/"+pl.lab);
	    JLabel prog2 = new JLabel("Your rank: Beginner.");
	    switch(kar){
	    case 100:JOptionPane.showMessageDialog(frame, "Congratulations your new rank is: Pupil.");prog2.setText("Your rank: Pupil.");pl.point-=100;pl.lab=500;ran.setImage("images/copral.png");prog.setText(pl.point+"/500");break;
	    
	    }
	    switch(pl.lab){
	    case 500: ran.setImage("ru.java2e/images/copral.png");prog2.setText("Your rank: Pupil.");break;
	    }
	    
	    
	    
		frame.setLayout(new GridBagLayout());
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		JLabel l1 = new JLabel("click \"RIGHT\" to moving faster and \"LEFT\" to stop");
		JLabel l2 = new JLabel(" click \"UP\" to the up and \"DOWN\" to down");
		JLabel l3 = new JLabel("Author of program: (c) Осипов О.,11-508, 2016г.");
		pa.add(bar, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,20,20,20),0,0));
		pa.add(prog, new GridBagConstraints(1,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,20,20,20),0,0));
		pa.add(pane, new GridBagConstraints(3,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,20,20,20),0,0));
		pa.add(bar, new GridBagConstraints(0,0,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,20,20,20),0,0));
		pa.add(l1, new GridBagConstraints(0,1,3,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,20,20,20),0,0));
		pa.add(l2, new GridBagConstraints(0,2,3,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,20,20,20),0,0));
		pa.add(b1,  new GridBagConstraints(0,3,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,20,20,20),0,0));
		pa.add(b2,  new GridBagConstraints(0,4,1,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,20,20,20),0,0));
		pa.add(l3, new GridBagConstraints(0,5,3,1,1,1,GridBagConstraints.NORTH,GridBagConstraints.HORIZONTAL,new Insets(20,20,20,20),0,0));
		frame.add(pa);
		b1.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){ frame.remove(pa);frame.setVisible(false);
			/* THIS IS THE GAME WINDOW*/
		 JFrame frame = new JFrame("RACING V1.");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(1100, 625);
			frame.add(new Road(pl));
			frame.setResizable(false);
			frame.setVisible(true);
		}});
		b2.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){
		pl.save();	
		System.exit(0);}});
		frame.pack();
		frame.setVisible(true);
	}

}
