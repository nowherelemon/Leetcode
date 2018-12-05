/*
There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Note:
N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 1 <= w <= 100.

*/




//dijastra



class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<> ();
        PriorityQueue<int[]> pq = new PriorityQueue<> ((a, b) -> a[1] - b[1]);

        for (int[] time : times) {
        	if (!map.containsKey(time[0])) {
        		map.put(time[0], new HashMap<> ());
        	}
        	map.get(time[0]).put(time[1], time[2]);
        } 

        pq.offer(new int[] {K, 0});

        int max = - 1;

      	Map<Integer, Integer> dis = new HashMap<> ();
      	dis.put(K, 0);

        while (!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (map.containsKey(cur[0])) {
        		for (int key : map.get(cur[0]).keySet()) {
        			int len = map.get(cur[0]).get(key) + cur[1];
        			if (!dis.containsKey(key) || (dis.containsKey(key) && dis.get(key) > len)) {
        				dis.put(key, len);
                        pq.offer(new int[] {key, len});
        			}
        		}
        	}

        }
        for (int value : dis.values()) {
    		max = Math.max(max, value);
    	}
    	return dis.size() == N ? max : -1;
    }
}
