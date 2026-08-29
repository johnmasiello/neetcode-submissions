class Solution {
    public int findMin(int[] nums) {
        // Partition left | right.
        // Notice the first and last value of each partition.
        // Notate as ll, lr, rl, rr

        // if ll <= lr && rl <= rr, then if ll < rl, then ll, otherwise rl.

        // if ll <= lr && rl > rr, then take the right partition

        // otherwise, take the left partition

        /* 
          Example:


          input := [4 1 2 3]

          [4 1] [2 3] -> select left

          [4] [1] -> select the minimum of the left value between the two partitions [4] and [1]. Since the partitions of size 1, -> 4 is the 'left' value of [4] and 1 is the 'left' value of [1]

          1 is the minimum. Done.


          Example:

          input := [1 2 3]

          [1 2] [3] -> paritions are complete -> ll <= lr && rl <= rr is satisfied

          [1 2] [3] -> select the minimum left value between the two partitions

          i < 3 => 1

          1 is the minimum. Done.

        */


        // trace n = 4, initialize i:= 0, j:= 3

        // part -> i,j

        // midpoint -> (i + j) / 2

        // ll := nums[i], lr := nums[mid]; rl := nums[mid + 1], rr: nums[j]

        if (nums.length == 1) {
            return nums[0];
        }

        int i = 0;
        int j = nums.length - 1;
        int mid = (i + j) / 2;

        while (nums[i] > nums[mid] || nums[mid + 1] > nums[j]) { // Select partitions L | R until both L and R are monotonically increasing
            if (nums[mid + 1] > nums[j]) { // Select right partition
                i = mid + 1;
            } else { // Select left partition
                j = mid;
            }
            mid = (i + j) / 2;
        }

        // Choose the min value of the partition that is ordered least
        return Math.min(nums[i], nums[mid + 1]);
    }
}
