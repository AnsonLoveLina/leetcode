package cn.sinobest.Solution149;

import java.util.*;

/**
 * Created by zhouyi1 on 2016/5/9 0009.
 */
public class Solution149 {

    /**
     * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
     */
    public int maxPoints(Point[] points) {
        if (points.length < 1) {
            return 0;
        }
        if (points.length ==1){
            return 1;
        }
        int maxLineSum = 2;
        Map<Integer, Set<Point>> lineSum = new HashMap<Integer, Set<Point>>();
        for (int i = 0; i < points.length-1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double[] lineFunc = findLineFunc(points[i], points[j]);
                int v = Arrays.hashCode(lineFunc);
                if (lineSum.containsKey(v)) {
                    Set<Point> setPoints = lineSum.get(v);
                    setPoints.add(points[i]);
                    setPoints.add(points[j]);
//                    System.out.println("v = " + v);
//                    System.out.println("points = " + points[i] + points[j]);
                    System.out.println(setPoints.size());
                    maxLineSum = Math.max(maxLineSum,setPoints.size());
                } else {
                    Set<Point> setPoints = new HashSet<Point>();
                    setPoints.add(points[i]);
                    setPoints.add(points[j]);
                    lineSum.put(v, setPoints);
                }
            }
        }
        return maxLineSum;
    }

    private double[] findLineFunc(Point point1, Point point2) {
        double a = (point2.y - point1.y) == 0 ? 0 : ((double)(point1.x - point2.x) / (double)(point2.y - point1.y));
        double b = -(a * point2.y + point2.x);
        return new double[]{a, b};
    }
}
