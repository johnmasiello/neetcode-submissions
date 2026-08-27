class Solution {
    public int[] productExceptSelf(int[] nums) {
        int indexOfFirstZero = -1;
        int product = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (indexOfFirstZero > -1) {
                    product = 0;
                    break;
                } else {
                    indexOfFirstZero = i;
                }
            } else {
                product *= nums[i];
            }
        }

        int arr[] = new int[nums.length];

        if (indexOfFirstZero > -1) {
            arr[indexOfFirstZero] = product;
            return arr;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                arr[i] = product;
            } else {
                arr[i] = product / nums[i];
            }
        }
        return arr;
    }
}  
