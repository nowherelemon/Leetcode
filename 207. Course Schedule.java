/*
There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
*/



class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<> ();
        
        for (int[] edge : prerequisites) {
            Set<Integer> nodes = map.getOrDefault(edge[1], new HashSet<Integer> ());
            
            nodes.add(edge[0]);
            map.put(edge[1], nodes);
        }
        
        boolean[] visited = new boolean[numCourses];
        for (int key : map.keySet()) {
            boolean[] round = new boolean[numCourses];
            if (!dfs(visited, round, map, key)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean dfs(boolean[] visited, boolean[] round, Map<Integer, Set<Integer>> map, int start) {
        System.out.println(start);
        if (round[start]) return false;
        if (visited[start]) return true;
        visited[start] = true;
        round[start] = true;
        if (map.containsKey(start)) {
          for (int next : map.get(start)) {
            if (!dfs(visited, round, map, next)) {
                return false;
                }
            }  
        }
        round[start] = false;
        
        return true;
        
        
    }
}
