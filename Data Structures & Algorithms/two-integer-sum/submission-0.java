class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> pairs = new HashMap<>();

        for (int i = 0; i < nums.length; i++){
            int complement = target-nums[i];

            if (pairs.containsKey(complement)){
                return new int[]{pairs.get(complement), i};
            }
            pairs.put(nums[i], i);
        }
        return new int[]{};
    }
}
