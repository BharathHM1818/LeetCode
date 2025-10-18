class Solution {
    public void sortColors(int[] nums) {
        int start = 0, mid = 0, end = nums.length - 1;

        while(mid <= end)
        {
            switch(nums[mid])
            {
                case 0 :
                swap(nums, start, mid);
                start++;
                mid++;
                break;

                case 1 :
                mid++;
                break;

                case 2 :
                swap(nums, mid, end);
                end--;
                break;

            }
        }
    }
    public static void swap(int[] nums, int left, int right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++; right--;
        }
}