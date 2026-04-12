class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length, up = 0, down = m - 1, left = 0, right = n - 1;
        while (result.size() < m * n){
            for (int i = left; i <= right; i++){
                result.add(matrix[up][i]);
            }

            for (int i = up + 1; i <= down; i++){
                result.add(matrix[i][right]);
            }

            if (up != down){
                for (int i = right - 1; i >= left; i--){
                    result.add(matrix[down][i]);
                }
            }

            if (left != right){
                for (int i = down - 1; i > up; i--){
                    result.add(matrix[i][left]);
                }
            }

            up++;
            down--;
            right--;
            left++;
        }
        return result;
    }
}
