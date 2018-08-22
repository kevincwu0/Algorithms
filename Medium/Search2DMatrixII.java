// 240. Search a 2D Matrix II

/*

1. Start top right corner
2. If target is greater than the value in curr position then target can not be entire row because sorted
3. If target is less than the value in current position cannot be in entire column
4. rule out one row or column each time

O(m+n)

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int col = matrix[0].length - 1;
        int row = 0;
        while(col >= 0 && row <= matrix.length - 1) {
            if(target == matrix[row][col]) return true;
            else if(target < matrix[row][col]) col--;
            else if(target > matrix[row[col]]) row++;
        }
        return false;
    }
}