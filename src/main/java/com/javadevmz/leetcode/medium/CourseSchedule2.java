package com.javadevmz.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 210. Course Schedule II

 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 */
public class CourseSchedule2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses]; // collect a graph where every prerequisite is an edge
        for (int i = 0; i < prerequisites.length; i++) {
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if (graph[pre] == null) graph[pre] = new ArrayList<>();
            graph[pre].add(course);
        }

        List<Integer> result = new ArrayList<>();
        boolean[] marked = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!marked[i]) {
                if (!dfs(graph, i, marked, recStack, result))
                    return new int[0]; // impossible to finish all
            }
        }

        Collections.reverse(result);
        return result.stream().mapToInt(x -> x).toArray();
    }

    private boolean dfs(List<Integer>[] graph, int v, boolean[] marked, boolean[] recStack, List<Integer> result) {
        if (recStack[v]) return false; // cycle detected
        if (marked[v]) return true; // visited

        marked[v] = true;
        recStack[v] = true;

        if (graph[v] != null) {
            for (int nei : graph[v]) {
                if (!dfs(graph, nei, marked, recStack, result)) return false;
            }
        }

        recStack[v] = false;
        result.add(v);
        return true;
    }
}
