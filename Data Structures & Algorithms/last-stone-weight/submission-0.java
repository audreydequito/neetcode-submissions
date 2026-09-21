class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int stone : stones){
            heap.offer(stone); 
            //adds all the stones into the max heap (automatically large->small)
        }
        while (!heap.isEmpty()){
            if (heap.size() == 1){ //if theres only one stone left just return that
                return heap.poll();
            }
            int x = heap.poll(); //take the two heaviest stones
            int y = heap.poll();
            if (x < y){ //which is greater 
                heap.offer(y-x);
            } else if (x > y){
                heap.offer(x-y);
            }
        }
        return 0;
    }
}
