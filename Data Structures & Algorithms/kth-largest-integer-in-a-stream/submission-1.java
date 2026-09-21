class KthLargest {
    PriorityQueue<Integer> stream;
    int K;
    public KthLargest(int k, int[] nums) {
        K = k;
        stream = new PriorityQueue<>();
        for (int i : nums){
            stream.offer(i);
            if (stream.size() > k){
                stream.poll();
            }
        }
    }
    
    public int add(int val) {
        stream.offer(val);

        if (stream.size() > K) {
            stream.poll();
        }

        return stream.peek();
    }
}
