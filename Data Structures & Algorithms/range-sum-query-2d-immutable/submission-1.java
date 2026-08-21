class NumMatrix {
    int[][]sum;

    public NumMatrix(int[][] matrix) {
        sum= new int[matrix.length][matrix[0].length];
        sum[0][0]= matrix[0][0];
        for(int i=1; i<matrix.length; i++){
            sum[i][0]= sum[i-1][0]+matrix[i][0];
        }

        for(int i=1; i<matrix[0].length; i++){
            sum[0][i]= sum[0][i-1]+ matrix[0][i];
        }

        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                sum[i][j]= sum[i-1][j]+ sum[i][j-1]- sum[i-1][j-1]+ matrix[i][j];
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int a= sum[row2][col2];
        int b=0;
        if(col1>0){
            b= sum[row2][col1-1];
        }

        int c=0;
        if(row1>0){
            c= sum[row1-1][col2];
        }

        int d=0;
        if(row1>0 && col1>0){
            d= sum[row1-1][col1-1];
        }
        int ans= a-b-c+d;

        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */