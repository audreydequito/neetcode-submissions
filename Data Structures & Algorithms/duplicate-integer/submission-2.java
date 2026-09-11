class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> ans = new HashSet<>();

        for (int i: nums){
            if (ans.contains(i)){
                return true;
            }
            ans.add(i);
        }
        return false;
    }
}