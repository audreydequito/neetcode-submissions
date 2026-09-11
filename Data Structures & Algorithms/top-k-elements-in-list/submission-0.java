class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k){
            return nums;
        }

        Map<Integer, Integer> counts = new HashMap<>();

        for(int n: nums){
            counts.put(n, counts.getOrDefault(n, 0)+1); //if in already looks for key n and the current value and returns the current value, if already in we just want to increment by 1 vs if its not in then should just be 0+1=1
        }

        Queue<Integer> heap = new PriorityQueue<>( //min priority queue want smallest count to leave
            (a,b) -> counts.get(a)-counts.get(b) //neg = a before b, pos = b before a
        );

        for (int n: counts.keySet()){ //for all keys in counts want to fill heap up to k elements
            heap.add(n);
            if(heap.size()> k){
                heap.poll();
            }
        }

        int[] ans = new int[k];

        for(int i = 0; i<ans.length; i++){
            ans[i] = heap.poll();
        }

        return ans;
    }
}
