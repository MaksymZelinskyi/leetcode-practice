package com.javadevmz.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 399. Evaluate Division

 * You are given an array of variable pairs equations and an array of real numbers values,
 * where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i].
 * Each Ai or Bi is a string that represents a single variable.

 * You are also given some queries, where queries[j] = [Cj, Dj] represents
 * the jth query where you must find the answer for Cj / Dj = ?.

 * Return the answers to all queries. If a single answer cannot be determined, return -1.0.

 * Note: The input is always valid. You may assume that evaluating the queries
 * will not result in division by zero and that there is no contradiction.

 * Note: The variables that do not occur in the list of equations are undefined,
 * so the answer cannot be determined for them.
 */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        // a graph with numbers referring to their divisors along with the quotient
        Map<String, List<Object[]>> graph = new HashMap<>();
        for(int i = 0; i<equations.size(); i++) {
            String key = equations.get(i).get(0); //dividend
            graph.putIfAbsent(key, new ArrayList<>());
            graph.get(key).add(new Object[]{
                    equations.get(i).get(1), //divisor
                    values[i] //quotient
            });
            // do the same in the reverse order to make a bidirectional graph
            key = equations.get(i).get(1);
            graph.putIfAbsent(key, new ArrayList<>());
            graph.get(key).add(new Object[]{equations.get(i).get(0), 1.0/values[i]});
        }

        //execute queries
        for(int i = 0; i<queries.size(); i++) {
            List<String> query = queries.get(i);
            //impossible to calculate the query
            if(graph.get(query.get(0))==null || graph.get(query.get(1))==null) result[i] = -1.0;

            Double quotient = findQuotient(query.get(0), query.get(1), graph, new HashMap<>());
            if(quotient==null) {
                quotient = -1.0;
            }
            result[i] = quotient;
        }

        return result;
    }

    /*
    Depth-first search the divisor and compute the total quotient
     */
    Double findQuotient(String a, String b,  Map<String, List<Object[]>> graph, Map<String, Boolean> visited) {
        if(graph.get(a)==null) return null;
        if(a.equals(b)) return 1.0;
        visited.put(a, true);
        for(Object[] node : graph.get(a)) {
            if(visited.get((String)node[0])!=null) continue;
            if(node[0].equals(b)) return (Double)node[1];
            Double result = findQuotient((String)node[0], b, graph, visited);
            if(result!=null) return result * (Double)node[1];
        }
        return null;
    }

}
