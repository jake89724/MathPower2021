/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceduralgeneration;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 *
 * @author Jake
 */
public class Movement {

    // 37 left
    //39 right
    final int LEFT = 37;
    final int RIGHT = 39;

    public static boolean directionR = false;
    boolean directionL = false;
    boolean right = false;
    boolean left = false;

    public Movement() {
        arrowKeys();
    }

    public void arrowKeys() {
        Screen.frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                int keyCode = e.getKeyCode();
                if (keyCode == LEFT) {
                    left = true;
                    directionR = false;
                }
                if (keyCode == RIGHT) {
                    right = true;
                    directionR = true;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == LEFT) {
                    left = false;
                }
                if (keyCode == RIGHT) {
                    right = false;
                }
            }

        });
    }

    public void move() {
        if (left) {
            for (int i = 0; i < Generate.list.size(); i++) {
                Generate.list.get(i).x += 3;
            }
        }
        if (right) {
            for (int i = 0; i < Generate.list.size(); i++) {
                Generate.list.get(i).x -= 3;
            }
        }
    }

    public boolean isRight() {
        if (directionR) {
            return true;
        } else {
            return false;
        }

    }

}
