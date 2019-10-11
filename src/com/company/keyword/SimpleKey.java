package com.company.keyword;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class SimpleKey extends Frame implements KeyListener {

    String msg = "";
    String keyState = "";

    public SimpleKey() {
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    //обрадотка событий от ввода с клавиатуры
    @Override
    public void keyTyped(KeyEvent e) {
        msg += e.getKeyChar();
        repaint();
    }

    //обработать событие от нажатия клавиши
    @Override
    public void keyPressed(KeyEvent e) {
        keyState = "Key Down";
        repaint();
    }

    //обработка событий от отпускания клавиши
    @Override
    public void keyReleased(KeyEvent e) {
        keyState = "Key up";
        repaint();
    }

    //отобразить нажатие клавиши
    public void paint(Graphics g) {
        g.drawString(msg, 20, 100);
        g.drawString(keyState, 20, 50);
    }

    public static void main(String[] args) {
        SimpleKey appWindow = new SimpleKey();

        appWindow.setSize(new Dimension(200,500));
        appWindow.setTitle("SimpleKey");
        appWindow.setVisible(true);
    }
}

//закрыть окно и выйти из программы при
//нажатии экранной кнопки закрытия окна
class MyWindowAdapter extends WindowAdapter {
    public void windowClosing(WindowEvent e){
        System.exit(0);
    }
}
