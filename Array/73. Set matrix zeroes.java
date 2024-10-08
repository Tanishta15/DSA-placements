class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) firstRow = true;
                    if(j == 0) firstCol = true;
                    matrix[i][0] = 0;//make all rows 0
                    matrix[0][j] = 0;//make all cols 0
                    }
                    }
                    }
                    for(int i = 1; i < m; i++){
                        for(int j = 1; j < n; j++){
                            // 
                            if(matrix[i][0] == 0 || matrix[0][j] == 0|| matrix[i][j] == 0){
                                matrix[i][j] = 0;
                                }
                                }
                                }
                                if(firstRow){ //if false then row=0
                                    for(int i = 0; i < n; i++){
                                        matrix[0][i] = 0;
                                        }
                                        }
                                        if(firstCol){//if false then col=0
                                            for(int i = 0; i < m; i++){
                                                matrix[i][0] = 0;
                                                }
                                                }
                                                }
                                                }