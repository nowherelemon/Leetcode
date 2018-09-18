/*
Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0. 
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? . 
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.

*/

import javafx.util.Pair; 
class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    
        Map<String, List<Pair<String, Double>>> map = new HashMap<> ();
        Set<String> dict = new HashSet<> ();
        
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            map.putIfAbsent(equation[0], new ArrayList<Pair<String, Double>> ());
            map.get(equation[0]).add(new Pair<String, Double> (equation[1], values[i]));
            if (values[i] != 0) {
                map.putIfAbsent(equation[1], new ArrayList<Pair<String, Double>> ());
                map.get(equation[1]).add(new Pair<String, Double> (equation[0], 1.0 / values[i])); 
            }
            
            dict.add(equation[0]);
            dict.add(equation[1]);
        }
        System.out.println(map.size());
       
        double[] res = new double[queries.length];
        
        
        
        for (int i = 0; i < res.length; i++) {
             Set<String> visited = new HashSet<> ();
            res[i] = calculate(map, queries[i][0], queries[i][1], dict, visited);
        }
        return res;
    }
    
    private double calculate(Map<String, List<Pair<String, Double>>> map, String start, String end, Set<String> dict, Set<String> visited) {
        if (!dict.contains(start) || !dict.contains(end) || visited.contains(start)) {
            //System.out.println("hit here");
            return -1.0;
        }
        if (start.equals(end)) {
            //System.out.println("HIT HERE");
            return 1.0;
            
        }
        visited.add(start);
        for (int i = 0; i < map.getOrDefault(start, new ArrayList<Pair<String, Double>>()).size(); i++) {
            //System.out.println(start + " " + pair.getKey());
            
            Pair<String, Double> cur = map.get(start).get(i);
            if (!visited.contains(cur.getKey())) {
                double res = calculate(map, cur.getKey(), end, dict, visited);
                if (res != -1.0) {
                    return cur.getValue() * res;
                }  
            }
            
        }
        visited.remove(start);
        return -1.0;
    }
}
