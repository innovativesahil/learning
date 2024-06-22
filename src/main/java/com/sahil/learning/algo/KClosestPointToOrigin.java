package com.sahil.learning.algo;

import com.sahil.learning.future.Post;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
* 973. K Closest Points to Origin
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).*/
public class KClosestPointToOrigin {

    public static void main(String[] args) {
        int[][] points = new int[][] {{3,3},{5,-1},{-2,4}};
        System.out.println(Arrays.deepToString(kClosest(points, 2)));
        System.out.println(Arrays.deepToString(kClosest(points, 1)));
        int[][] points2 = new int[][] {{1,1},{0,0},{0,1}, {1, 0}, {2,1}, {1,2}, {2,2}};
        System.out.println(Arrays.deepToString(kClosest(points2, 7)));
        System.out.println(Arrays.deepToString(kClosest(points2, 6)));
        System.out.println(Arrays.deepToString(kClosest(points2, 5)));
        System.out.println(Arrays.deepToString(kClosest(points2, 4)));
        System.out.println(Arrays.deepToString(kClosest(points2, 3)));
        System.out.println(Arrays.deepToString(kClosest(points2, 2)));
        System.out.println(Arrays.deepToString(kClosest(points2, 1)));

    }

    static class PointComparator implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2) {
            return  (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1]);
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        Queue<int[]> maxHeap = new PriorityQueue<>(k, new PointComparator());
        for (int i = 0; i < points.length; i++) {
            maxHeap.offer(points[i]);
            if(maxHeap.size() > k ){
                maxHeap.poll();
            }
        }


        int[][] result = new int[k][2];
        while(k > 0){
            result[--k] = maxHeap.poll();
        }
        return result;
    }

    private float calculateDistance() {
        return 0;
    }

    record Point(int index, int distance){}
}
