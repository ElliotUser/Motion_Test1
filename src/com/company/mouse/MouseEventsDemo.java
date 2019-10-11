package com.company.mouse;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseEventsDemo extends Frame implements MouseListener, MouseMotionListener {
    String msg = "";
    int mouseX = 0, mouseY = 0;

    public MouseEventsDemo() {
        addMouseListener(this);
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapter());
    }
    //обработать событие от щелчка кнопки мыши
    @Override
    public void mouseClicked(MouseEvent e) {
        msg = msg + " -- click received";
        repaint();
    }

    //Обработать событие нажатия кнопки мыши
    @Override
    public void mousePressed(MouseEvent e) {
        //сохранить координаты
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button down";
        repaint();
    }
    //обработать событие отпускания кнопки мыши
    @Override
    public void mouseReleased(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button Released";
        repaint();
    }

    //обработать событие наведения курсора мыши
    @Override
    public void mouseEntered(MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse entered.";
        repaint();
    }

    //обработка события отведения курсора мыши
    @Override
    public void mouseExited(MouseEvent e) {
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse exited";
        repaint();
    }

    //обработать событие перетаскивания курсора мыши
    @Override
    public void mouseDragged(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "*" + " mouse at " + mouseX +", "+ mouseY;
    }
    //обработать событие перемещения мыши
    @Override
    public void mouseMoved(MouseEvent e) {
        msg = "Moving mouse at "+e.getX() + ", " + e.getY();
        repaint();
    }

    //вывести сообщение в окне на текущей позиции
    //с координатами X, Y
    public void paint(Graphics g){
        g.drawString(msg, mouseX, mouseY);
    }

    public static void main(String[] args) {
        MouseEventsDemo appWindow = new MouseEventsDemo();

        appWindow.setSize(new Dimension(300,300));
        appWindow.setTitle("MouseEventsDemo");
        appWindow.setVisible(true);
    }
}

class MyWindowAdapter extends WindowAdapter{
    public void windowClosing(WindowEvent we){
        System.exit(0);
    }
}
