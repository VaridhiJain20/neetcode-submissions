class Solution {
    public void rotate(int[][] matrix) {
         
	        rotateAboutDiagonal(matrix);
	        rotateAboutMidCol(matrix);
	    }

	private void rotateAboutDiagonal(int[][] matrix) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < i; j++) {
				swap(matrix, i, j, j, i);
			}
		}
	}

	private void rotateAboutMidCol(int[][] matrix) {
		// TODO Auto-generated method stub
		
		int i=0;
		int j= matrix[0].length-1;
		
		while(i<j) {
			for (int k = 0; k < matrix.length; k++) {
				swap(matrix, k, i, k, j);
			}
			i++;
			j--;
		}
		
	}

	private void swap(int[][] matrix, int k, int i, int k2, int j) {
		// TODO Auto-generated method stub
		int temp= matrix[k][i];
		matrix[k][i]= matrix[k2][j];
		matrix[k2][j]= temp;
    }
}