/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceduralgeneration;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Jake
 */
public class Screen extends JPanel {

    Graphics g;
    int x = 0;
    int y = 0;
    public static JFrame frame = new JFrame("Generation");
    Movement motion = new Movement();
    Rectangle rec = new Rectangle();

    public Screen() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 550);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(this);
        JButton button = new JButton("Test");
        this.add(button);
        button.setVisible(true);
        button.setLocation(475, 500);

        timer();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 400, frame.getWidth(), 400);
        g.drawString(Generate.list.size() + ": Number Of Dots", 100, 450);
        //draws points
        for (int i = 0; i < Generate.list.size(); i++) {
            g.fillOval(Generate.list.get(i).x, Generate.list.get(i).y, 10, 10);
        }
        //draws lines between points
        for (int i = 0; i < Generate.list.size() - 1; i++) {
            g.drawLine(Generate.list.get(i).x + 5,
                    Generate.list.get(i).y + 5,
                    Generate.list.get(i + 1).x + 5,
                    Generate.list.get(i + 1).y + 5);
        }

        Graphics2D g2d = (Graphics2D) g;
        rec.setBounds(475, (int) Player.y - 25, 10, 30);
        g.drawString("Y:" + (int) rec.getY(), 465, (int) Player.y - 35);
        //g2d.rotate(Player.angle, 475, Player.y);
        g2d.fill(rec);
        //g.fillRect(475, Player.y - 45, 30, 50);

    }

    /**
     * calls run 60fps and repaints
     */
    private void timer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                motion.move();
                Generate.generateMore();
                Player.checkUnder(motion);
                repaint();
                getMousePos();
            }

        }, 0, 17);
    }   private void getMousePos() {
       PointerInfo a = MouseInfo.getPointerInfo();
        java.awt.Point b = a.getLocation();
        int x = (int)b.getX();
        int y = (int)b.getY();
        
        System.out.println("X: " + x + " Y: " + y);
        
    }

}
