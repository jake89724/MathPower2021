/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceduralgeneration;

import java.util.LinkedList;

/**
 *
 * @author Jake
 */
public class Generate {

    static int originX = 0;

    public static LinkedList<Point> list = new LinkedList();

    public Generate() {
        int x = -50;
        int y = 100;
        Point point = new Point(10, 10);
        for (int i = 0; i < 21; i++) {
            list.add(new Point(x, random(50, 300)));
            x+=50;
            
            // y += 5;
        }
        originX = list.getFirst().x;

    }

    private static int random(int low, int high) {
        
        double seed = Math.random();
        double L = (double) low;
        double H = (double) high;
        double number = (H - L + 1) * seed + L;
        return (int) number;
    }

    public static void generateMore() {
        if (list.getLast().x < Screen.frame.getWidth() - 50) {
            list.addLast(new Point(Screen.frame.getWidth(), random(50, 300)));
        }

        if (list.getFirst().x > 0) {
            list.addFirst(new Point(-50, random(50, 300)));
        }

    }
    
 
}
