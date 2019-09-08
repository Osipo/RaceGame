package ru.java2e;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;


@SuppressWarnings("serial")

public class Road extends JPanel implements ActionListener{
	  

	URL url = Road.class.getResource("images/road.jpg");//for packing in jar file. class name is that is what class is uses resource.
	Image img = Toolkit.getDefaultToolkit().getImage(url);//image of our road.
	Player p;
	JLabel l;
	Timer mainTime = new Timer(20, this);//Timer;
	Music m = new Music();//thread
	Thread myThread = new Thread(m);//thread
	int k = 0;
public Road(Player pa){//constructor.
	 p=pa;l = new JLabel("Points: "+p.s);
		mainTime.start();
		addKeyListener(new MyKeyAdapter());
		setFocusable(true);
		myThread.start();
	}
	//class, what implements key press, when we want to increase car's speed, or change location.
    private class MyKeyAdapter extends KeyAdapter {
    	public void keyPressed(KeyEvent e){
    	
    		p.keyPressed(e);
    		
    	}
    	public void keyReleased(KeyEvent e){
    		p.keyReleased(e);
    	}
    }

	public void paint(Graphics g){
		g = (Graphics2D) g;
		l.setText("Points: "+p.s);
        g.setFont(new Font("Verdana",Font.BOLD,15));//for drawString.
        g.setColor(Color.WHITE);//for drawString
		g.drawImage(img,p.layer1,0,null);//this is road
		g.drawImage(img,p.layer2,0,null);//this is continue of our road.
		g.drawString(l.getText(), 950, 550);//drawing String.
		g.drawImage(p.img,p.x,p.y,null);//this is player's car.
		g.drawImage(p.vr.img,p.vr.x,p.vr.y,null);//this is enemy's car.
	}
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e){
		p.move();
		repaint();//paint again.
		k++;
		if(p.x+251>=p.vr.x&&p.y>=p.vr.y-97&&p.y<=p.vr.y+116){JOptionPane.showMessageDialog(null,"GAME OVER! YOUR POINTS ARE: "+p.s);
	    p.save();
		
		System.exit(0);}
		if(k>=250*50){myThread.stop();myThread = new Thread(m);myThread.start();k =0; }
	}

}
