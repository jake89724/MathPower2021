/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceduralgeneration;

/**
 *
 * @author Jake
 */
public class Player {

    public static int x = 475;
    public static double y;
    public static double angle;

    public Player() {

    }

    public static void checkUnder(Movement m) {
        Point next;
        Point prev;
        Point cent;
        for (int i = 0; i < Generate.list.size(); i++) {
            if (Movement.directionR) {
                if (Generate.list.get(i).x > 425 && Generate.list.get(i).x < 475) {

                    next = Generate.list.get(i + 1);
                    //xPos(Generate.list.get(i), next, 475);
                    y = getY(Generate.list.get(i), next, 475);
                    //y = Generate.list.get(i).y - 5;
                }
            } else {
                if (Generate.list.get(i).x > 475 && Generate.list.get(i).x < 525) {

                    next = Generate.list.get(i - 1);
//                        xPos(Generate.list.get(i), next, 475);

                    y = getY(Generate.list.get(i), next, 475);
                    //y = Generate.list.get(i).y - 5;
                }
            }
        }
    }

    public static int xPos(Point p1, Point p2, int myX) {

        double oppLength;
        double originalOpp;
        double adjLength;
        if (p1.y > p2.y) {
            oppLength = p1.y - p2.y;
            adjLength = 50;
        } else {
            oppLength = p2.y - p1.y;
            adjLength = 50;
        }
        originalOpp = oppLength;
        oppLength *= oppLength;
        adjLength *= adjLength;
        double hyp = adjLength + oppLength;
        hyp = Math.sqrt(hyp);


        // sin opposite/hypotenuse 
        //angle = Math.sin(originalOpp / hyp);
        System.out.println(angle);
        return 6;
    }

    public static double getY(Point p1, Point p2, int xPos) {
        if (Movement.directionR) {
            double rise;

            rise = p2.y - p1.y;

            double run = 50;
            double yPos = (rise / run);
            angle = Math.sin(rise / run);
            //yPos*=p1.x;

            // x = distance between p1.x and center screen (475)
            //if(number is negative) { make it poisitve}
            double diffX = 475 - p1.x;

            //if (yPos < 0) {
            //    yPos *= -1;
            //}
            yPos *= diffX;

            yPos += p1.y;

            //System.out.println("set y: " + yPos);
            return yPos;

        } else {

            double rise;

            rise = p2.y - p1.y;

            double run = 50;
            double yPos = (rise / run);
            angle = Math.sin(rise / run);
            //yPos*=p1.x;

            // x = distance between p1.x and center screen (475)
            //if(number is negative) { make it poisitve}
            double diffX = p1.x - 475;

            //if (yPos < 0) {
            //    yPos *= -1;
            //}
            yPos *= diffX;

            yPos += p1.y;

            return yPos;
        }

    }
}
