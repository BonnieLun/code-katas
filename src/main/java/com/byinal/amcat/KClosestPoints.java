package com.byinal.amcat;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
PriorityQueue creation O(n) deletion and addition O(logn) k times O(klogn) total => O(n+klogn)
 */
public class KClosestPoints {

    public static void main(String[] args) {
        Point[] points = {new Point(-1, 2), new Point(2, 3), new Point(2, 0), new Point(3, 1), new Point(2, -2)};
        printKclosestPoints(points, 3);

    }

    private static void printKclosestPoints(Point[] points, int k) {
        for (Point point : points) {
            point.distance = findDistance(point);
        }

        PriorityQueue<Point> distanceQueue = new PriorityQueue<>(k, Comparator.comparing(Point::getDistance).reversed());

        for (int i = 0; i < k; i++) {
            distanceQueue.add(points[i]);
        }

        for (int i = k; i < points.length; i++) {
            Point peek = distanceQueue.peek();
            if (peek != null && points[i].distance < peek.distance) {
                distanceQueue.remove();
                distanceQueue.add(points[i]);
            }
        }

        for (Point point : distanceQueue) {
            System.out.println(point);
        }

    }

    private static double findDistance(Point point) {
        return Math.sqrt((point.x * point.x) + (point.y * point.y));
    }

}

class Point {
    int x;
    int y;
    Double distance;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("(");
        sb.append(x);
        sb.append(", ").append(y);
        sb.append(')').append(" w/ Distance: ").append(distance);
        return sb.toString();
    }
}
