class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length, up = 0, down = m - 1, left = 0, right = n - 1;
        while (list.size() < m * n){
            for (int i = left; i <= right; i++){
                list.add(matrix[up][i]);
            }

            for (int i = up + 1; i <= down; i++){
                list.add(matrix[i][right]);
            }

            if (up != down){
                for (int i = right - 1; i >= left; i--){
                    list.add(matrix[down][i]);
                }
            }

            if (left != right){
                for (int i = down - 1; i > up; i--){
                    list.add(matrix[i][left]);
                }
            }

            up++;
            down--;
            left++;
            right--;
        }

        return list;
    }
}
