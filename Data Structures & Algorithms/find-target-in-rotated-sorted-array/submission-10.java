class Solution {
    public int search(int[] nums, int target) {
        /*
        minimum problem


        4 5 | 6 7 8 1 2 3

        */

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } 
            
            /*
                Cases:
                  1 2 3 | 4 5 6
                  4 5 6 | 1 2 3
                  6 1 2 | 3 4 5
                  3 4 5 | 6 1 2

            */
            else if (nums[mid] < nums[right]) {
                if (target > nums[mid] && target <= nums[right]) { 
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (target > nums[mid] || target < nums[left]) { 
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
