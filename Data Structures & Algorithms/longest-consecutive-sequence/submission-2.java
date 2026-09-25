class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int longest = 1;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums){
            set.add(num);
        }

        for(int num : set){

            if (set.contains(num-1)){
                continue; //go to next number in the set
            }

            int currNum = num;
            int currSeq = 1;

            while(set.contains(currNum+1)){
                currNum++;
                currSeq++;
            }
            
            longest = Math.max(longest, currSeq);
        }

        return longest;
        

    }
}
