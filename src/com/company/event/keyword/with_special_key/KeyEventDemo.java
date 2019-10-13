package com.company.event.keyword.with_special_key;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class KeyEventDemo extends Frame implements KeyListener {

    String msg = "";
    String keyState = "";

    public KeyEventDemo() {
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        msg += ke.getKeyChar();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        keyState = "Key Down";

        int key = ke.getKeyCode();
        switch(key) {
            case KeyEvent.VK_F1:
                msg += "<F1>";
                break;
            case KeyEvent.VK_F2:
                msg += "<F2>";
                break;
            case KeyEvent.VK_F3:
                msg += "<F3>";
                break;
            case KeyEvent.VK_PAGE_DOWN:
                msg += "<PgUp";
                break;
            case KeyEvent.VK_PAGE_UP:
                msg += "<PgUp>";
                break;
            case KeyEvent.VK_LEFT:
                msg += "<Left Arrow>";
                break;
            case KeyEvent.VK_RIGHT:
                msg += "<Right Arrow>";
                break;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        keyState = "KeyUp";
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg,20,100);
        g.drawString(keyState,20,50);
    }

    public static void main(String[] args) {
        KeyEventDemo appWindow = new KeyEventDemo();

        appWindow.setSize(200,150);
        appWindow.setTitle("KeyEventDemo");
        appWindow.setVisible(true);
    }

    private class MyWindowAdapter extends WindowAdapter {
        public void windowClosing(WindowEvent we){
            System.exit(0);
        }
    }
}
