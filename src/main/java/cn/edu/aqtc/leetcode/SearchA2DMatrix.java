package cn.edu.aqtc.leetcode;

/**
 * 74. 搜索二维矩阵
 * <p>
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *
 * @Description:
 * @ClassName: SearchA2DMatrix
 * @Author: zhangjj
 * @Date: 2021-03-30
 */
public class SearchA2DMatrix {

    public static void main(String[] args) {
        SearchA2DMatrix searchA2DMatrix = new SearchA2DMatrix();
        //int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        //int[][] matrix = {{1}};
        int[][] matrix = {{1}, {3}, {5}};
        searchA2DMatrix.searchMatrix(matrix, 3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchColumn(matrix, target);
        if (row == -1) {
            return false;
        }

        return binarySearch(matrix, target, row);
    }

    private boolean binarySearch(int[][] matrix, int target, int row) {
        int end = matrix[row].length - 1;
        int start = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    private int binarySearchColumn(int[][] matrix, int target) {
        int x = matrix.length;
        int end = x - 1;
        int start = -1;
        while (start < end) {
            int mid = start + (end - start + 1) / 2;
            if (target >= matrix[mid][0]) {
                start = mid;

            } else {
                end = mid - 1;
            }
        }
        return start;
    }


}
