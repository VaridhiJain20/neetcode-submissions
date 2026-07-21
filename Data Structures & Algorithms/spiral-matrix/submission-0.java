class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int sr=0;
        int er= matrix.length-1;
        int sc=0;
        int ec= matrix[0].length-1;
        List<Integer> ans= new ArrayList<>();       


        while(sr<=er && sc<=ec){
            int i=sc;
            if(sr<=er){
            while(i<=ec){
                ans.add(matrix[sr][i++]);
            }
            sr++;
            }
            
            if(sc<=ec){
            i=sr;
            while(i<=er){
                ans.add(matrix[i++][ec]);
            }
            ec--;
            }

            if(sr<=er){
            i=ec;
            while(i>=sc){
                ans.add(matrix[er][i--]);
            }
            er--;
            }

            if(sc<=ec){
            i=er;
             while(i>=sr){
                ans.add(matrix[i--][sc]);
            }
            sc++;
            }

        }
        
        return ans;
    }
}
