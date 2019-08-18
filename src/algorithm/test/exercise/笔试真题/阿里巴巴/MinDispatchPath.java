package algorithm.test.exercise.笔试真题.阿里巴巴;

import java.util.Scanner;

/**
 * 阿里评测，配送员的最短配送距离
 *
 * @author  j_cong
 * @date    2018/07/21
 * @version V1.0
 */
public class MinDispatchPath {

    private static Point START = new Point(0,0);
    private static int minPath = Integer.MAX_VALUE;

    public MinDispatchPath() {
    }

    public static int calculatePath(Point start, Point[] points, int sum, int count) {
        if (count == points.length) {
            minPath = Math.min(minPath, sum + start.getLength(START));
            return minPath;
        }
        for (int i = 0; i < points.length; i++) {
            if (!points[i].visited) {
                sum += points[i].getLength(start);
                if (sum < minPath) {
                    points[i].visited = true;
                    calculatePath(points[i], points, sum, count + 1);
                }
                sum -= points[i].getLength(start);
                points[i].visited = false;
            }
        }
        return minPath;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine().trim());
        Point[] points = new Point[num];
        for (int i = 0; i < num; i++) {
            String[] locations = sc.nextLine().trim().split(",");
            points[i] = new Point(Integer.parseInt(locations[0]), Integer.parseInt(locations[1]));
        }
        int min = calculatePath(START, points, 0, 0);

        System.out.println(min);
    }



    static class Point {
        int posX;
        int posY;
        boolean visited;

        public Point(int posX, int posY) {
            this.posX = posX;
            this.posY = posY;
            this.visited = false;
        }

        public int getLength(Point point) {
            return  Math.abs(posX - point.posX) + Math.abs(posY - point.posY);
        }
    }
}
