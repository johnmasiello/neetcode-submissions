class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length -1;

        int maxArea = 0;

        while (left < right) {
            int area = Math.min(heights[left], heights[right]) * (right - left);
            if (area > maxArea) {
                maxArea = area;
            }
            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else if (Math.min(heights[left], heights[right - 1]) > Math.min(heights[left + 1], heights[right])) { // tie breaker -> maximize water area on next step
                right--;
            } else {
                left++;
            }
        }

        return maxArea;
    }
}
