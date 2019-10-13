package com.company.AWT;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ResizeMe extends Frame {
    final int inc = 25;
    int max = 500;
    int min = 200;
    Dimension d;

    public ResizeMe(){
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int w = (d.width + inc) > max?min : (d.width + inc);
                int h = (d.height + inc) > max?min : (d.height + inc);
                setSize(new Dimension(w,h));
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
        Insets i = getInsets();
        d = getSize();

        g.drawLine(i.left, i.top, d.width-i.right,d.height-i.bottom);
        g.drawLine(i.left, d.height-i.bottom,d.width-i.right, i.top);
    }

    public static void main(String[] args) {
        ResizeMe resizeMe = new ResizeMe();

        resizeMe.setSize(new Dimension(200,200));
        resizeMe.setTitle("Resize");
        resizeMe.setVisible(true);
    }
}
