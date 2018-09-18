/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:

If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
*/


class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<> ();
        LinkedList<String> res = new LinkedList();
        
        for (String[] ticket : tickets) {
            PriorityQueue<String> pq = map.getOrDefault(ticket[0], new PriorityQueue<String> ());
            pq.offer(ticket[1]);
            map.put(ticket[0], pq);
        }
        
        dfs("JFK", map, res);
        
        return res;
    }
    
    private void dfs(String depart, Map<String, PriorityQueue<String>> map, LinkedList<String> res) {
        PriorityQueue<String> pq = map.get(depart);
        
        while (pq != null && !pq.isEmpty()) {
            dfs(pq.poll(), map, res);
        }
        res.addFirst(depart);
    }
}
