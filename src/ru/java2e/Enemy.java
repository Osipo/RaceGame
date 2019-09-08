package ru.java2e;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class Enemy {
URL url = Enemy.class.getResource("images/enemy.png");
Image img = Toolkit.getDefaultToolkit().getImage(url);
int x,y;
public Enemy(int x,int y){
this.x=x;this.y=y;
}
}
