package ru.java2e;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.JPanel;

public class Iconpanel extends JPanel{
private URL url;
private Image img;
    public void setImage(String s){
        url = Icon.class.getResource(s);
        img = Toolkit.getDefaultToolkit().getImage(url);
    }
    public Image getImg(){
        return img;
    }
    public Iconpanel(){
        setLayout(null);
        setPreferredSize(new Dimension(78,74));
        setImage("images/begin.png");
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(true){
            g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
            repaint();
        }
    }
}

