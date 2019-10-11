package com.company.adapter;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdapterDemo extends Frame {
    String msg = "";

    public AdapterDemo(){
        addMouseListener(new MyMouseAdapter(this));
        addMouseMotionListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg,20,80);
    }

    public static void main(String[] args) {
        AdapterDemo appWindow = new AdapterDemo();

        appWindow.setSize(200,150);
        appWindow.setTitle("AdapterDemo");
        appWindow.setVisible(true);
    }

    private class MyMouseAdapter  extends MouseAdapter {
        AdapterDemo adapterDemo;

        public MyMouseAdapter(AdapterDemo adapterDemo){
            this.adapterDemo = adapterDemo;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            adapterDemo.msg = "Mouse clicked";
            adapterDemo.repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            adapterDemo.msg = "Mouse dragged";
            adapterDemo.repaint();
        }
    }

    private class MyWindowAdapter  extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
