class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> ans = new HashMap<>();

        for (int i: nums){
            if (ans.containsKey(i)){
                return true;
            }
            ans.put(i, 1);
        }

        return false;
    }
}