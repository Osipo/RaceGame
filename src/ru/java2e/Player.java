package ru.java2e;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;








public class Player {
	URL url = Player.class.getResource("images/player.png");
Image img = Toolkit.getDefaultToolkit().getImage(url);
public static final int MAX_V = 50, MAX_TOP = 10, MAX_BUTTOM = 470; //this constants control our speed and car location.
int v = 1;//speed
int dv = 0;//acceleration
int s = 0;//path or points.
int layer1 = 0; int layer2 = 1200;//coordinates of our road.
int x = 30; int y = 50;//coordinates of our car.
int dy = 0;//changes y.
Integer point;//Exp.
Integer lab;//NExp.
public Player(){
	File fa = new File("C:/RaceGame");point = 0; lab = 100;
	fa.mkdir();
	load();
}
Random g = new Random(170);
Enemy vr = new Enemy(g.nextInt(913),g.nextInt(502));
public void move(){
	if (layer2 - v<=0){
		layer1 = 0; layer2 = 1200;
		vr = new Enemy(1100,g.nextInt(502));
	} 
	else {
	    s+=v;
	    point+=s/100;
	    v+=dv;
	    if (v>MAX_V) v = MAX_V;
	    if(v<=0) v = 0;
	    layer1 -=v; vr.x-=v;
	    layer2 -=v;
	    y-=dy;
	    if(y<=MAX_TOP) y = MAX_TOP;
	    if(y>=MAX_BUTTOM) y = MAX_BUTTOM;   
	}
                  }
public void load(){
	try{
	point =  (Integer) Serialzier.load(new File("C:/RaceGame/Exp.txt"));
	lab = (Integer) Serialzier.load(new File("C:/RaceGame/NExp.txt"));
}catch(ClassNotFoundException|IOException e){}
}
public void save(){
	try{
	Serialzier.store(point,new File("C:/RaceGame/Exp.txt"));
	Serialzier.store(lab,new File("C:/RaceGame/NExp.txt"));
}catch(IOException e){}
}
public void keyPressed(KeyEvent e){
	int key = e.getKeyCode();
	if (key==KeyEvent.VK_RIGHT){
		dv = 1;
	}
	else if (key==KeyEvent.VK_LEFT){
		dv = -1; 
	}
	else if (key==KeyEvent.VK_UP){
		dy = 10;}
	else if (key==KeyEvent.VK_DOWN){
		dy = -10;
	}
}
public void keyReleased(KeyEvent e){
	int key = e.getKeyCode();
	if (key==KeyEvent.VK_RIGHT||key==KeyEvent.VK_LEFT){ dv = 0;}
	if (key==KeyEvent.VK_UP||key==KeyEvent.VK_DOWN){dy = 0;}
}
}
