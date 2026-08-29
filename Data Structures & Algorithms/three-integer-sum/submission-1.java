class Solution {
    public List<List<Integer>> threeSum(int[] nums) { // Solved in O(n^2). Ignore the inner most loop that is just advancing over duplicates in the same traversal loop.
        Arrays.sort(nums);

        int leftleft = 0;
        int left;
        int right;
        int leftTuple = nums[leftleft];
        int middleTuple;

        List<List<Integer>> arr = new ArrayList<>();

        // Least value in tuple must be <= 0
        while (leftTuple < 1) {
            left = leftleft + 1;
            right = nums.length - 1;
            int val;
            int target = -leftTuple;

            while (left < right) {
                val = nums[left] + nums[right];

                if (val < target) {
                    left++;
                } else if (val > target) {
                    right--;
                } else {
                    middleTuple = nums[left];
                    arr.add(List.of(leftTuple, middleTuple, nums[right]));

                    do { // enforces unique tuple for choice of index j
                        left++;
                        if (left == nums.length) {
                            return arr;
                        }

                     } while (nums[left] == middleTuple);

                    right--;

                    // Keeping finding more integral pairs...
                }
            }
            // advance to unique value of num on least value in tuple
            do { // enforces unique tuple for choice of index i
                leftleft++;
                if (leftleft == nums.length) {
                    return arr;
                }

             } while (nums[leftleft] == leftTuple);

            leftTuple = nums[leftleft];
        }

        return arr;
    }
}
