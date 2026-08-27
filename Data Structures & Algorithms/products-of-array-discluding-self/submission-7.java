class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProducts = new int[nums.length];
        int[] suffixProducts = new int[nums.length];

        prefixProducts[0] = 1;
        suffixProducts[nums.length - 1] = 1;


        for (int i = 1, prefixProduct = 1, suffixProduct = 1; i < nums.length; i++) {
            prefixProduct *= nums[i - 1];
            prefixProducts[i] = prefixProduct;
            suffixProduct *= nums[nums.length - i];
            suffixProducts[nums.length - i - 1] = suffixProduct;
        }

        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = prefixProducts[i] * suffixProducts[i];
        }
        return arr;
    }
}


// [1, 2, 3, 4]

// prefixProducts

// [1, 1, 2, 6]

// suffixProducts

// [24, 12, 4, 1]