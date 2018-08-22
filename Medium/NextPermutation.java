// #31 LeetCode Next Permutation

class Solution {
    public void nextPermutation(int[] nums) {
        
    }
}

/*
We need to find the next lexicographic permutation of the given list of numbers than the number formed by the given array.


Thoughts: 

Collections.sort()
Comparator function 
in-place 

Approach 1: Brute Force
- Find out every possible permutation of list formed by the elements
- Find out the permutation which is just larger than the given one
- Requires us to find out every possible permutation - take a long time
- O(n!) total permutations

Approach 2: Single Pass
- Observe that for any given sequence that is in descending order, no next 
larger permutation is possible. (e.g. [9, 5, 4, 3, 1]) not possible
- Find pair of two successive numbers a[i] and a[i - 1] from the right which satisfy a[i] > a[a - 1]

*/

public class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if(i >= 0) {
            int j = nums.length - 1;
            while(j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    
    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while(i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}