package com.company.adapter;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KeyAdapterDemo extends Frame {
    String msg = "";
    String keyState = "";

    public KeyAdapterDemo(){
        addKeyListener(new MyKeyAdapter(this));
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg,20,80);
        g.drawString(keyState, 20,100);
    }

    public static void main(String[] args) {

        KeyAdapterDemo appWind = new KeyAdapterDemo();

        appWind.setSize(200,200);
        appWind.setTitle("KeyAdapterDemo");
        appWind.setVisible(true);
    }
}

class MyKeyAdapter extends KeyAdapter {
    KeyAdapterDemo keyAdapterDemo;
    public MyKeyAdapter(KeyAdapterDemo keyAdapterDemo) {
        this.keyAdapterDemo = keyAdapterDemo;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keyAdapterDemo.keyState = "Key Down";
        keyAdapterDemo.repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keyAdapterDemo.keyState = "Key Up";
        keyAdapterDemo.repaint();
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        keyAdapterDemo.msg += ke.getKeyChar();
        keyAdapterDemo.repaint();
    }
}
class MyWindowAdapter extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}
