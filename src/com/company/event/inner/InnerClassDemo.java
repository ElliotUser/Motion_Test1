package com.company.event.inner;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerClassDemo extends Frame {
    String msg = "";

    public InnerClassDemo(){
        addMouseListener(new MyMouseAdapter());
        addWindowListener(new MyWindowAdapter());
    }

    class MyMouseAdapter extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            msg = "Mouse Pressed";
            repaint();
        }
    }

    class MyWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg,20,50);
    }

    public static void main(String[] args) {
        InnerClassDemo appWin = new InnerClassDemo();
        appWin.setSize(new Dimension(200,150));
        appWin.setTitle("InnerClassDemo");
        appWin.setVisible(true);
    }
}
