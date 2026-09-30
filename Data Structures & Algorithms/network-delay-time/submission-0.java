class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        // Build Adjacency List

        //node -> list of [neighbor, weight]
        for (int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];

            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[]{v,w});

            // computeIfAbsent(key, func to put new value) returns value of the key
            // our value is an array list so we want to add the node and the time 
            // it takes to get from the key to the next note (u->v) takes while

        }

        // DIST[i] is shortest known time from k to i

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        // MIN HEAP STORING [totalTime, node]

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));

        minHeap.offer(new int[]{0, k});

        //DIJKSTRA - populating dist correctly

        while (!minHeap.isEmpty()){
            int[] curr = minHeap.poll();

            int currTime = curr[0];
            int currNode = curr[1];

            //stale entry was added before

            if (currTime > dist[currNode]){
                continue;
            }

            if (!graph.containsKey(currNode)){
                continue;
            }

            for (int[] edge : graph.get(currNode)){
                int neighbor = edge[0];
                int weight = edge[1];

                int newTime = currTime + weight;

                if (newTime < dist[neighbor]){
                    dist[neighbor] = newTime;
                    minHeap.offer(new int[]{newTime, neighbor});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++){
            if (dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }

        return ans;

    }
}
