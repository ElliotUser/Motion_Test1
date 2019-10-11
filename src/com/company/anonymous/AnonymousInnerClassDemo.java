package com.company.anonymous;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AnonymousInnerClassDemo extends Frame {
    String msg = "";

    public AnonymousInnerClassDemo(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                msg = "Mouse Pressed";
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                msg = "Mouse Released";
                repaint();
            }
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg,20,50);
    }

    public static void main(String[] args) {
        AnonymousInnerClassDemo anonymousInnerClassDemo =
                new AnonymousInnerClassDemo();
        anonymousInnerClassDemo.setSize(200,150);
        anonymousInnerClassDemo.setTitle("Anonymous");
        anonymousInnerClassDemo.setVisible(true);
    }
}
