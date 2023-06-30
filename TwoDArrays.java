import java.util.Scanner;

public class TwoDArrays {

    public static void linearsearch(int matrix[][], int key){
        for(int i =0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length; j++){
                if( key == matrix[i][j]){
                    System.out.print("key found on index :- (" + i + ", " + j + ")");
                    return;
                }
            }
        }
        System.out.println("key not found");
    }

    public static void spiralmatrix(int matrix[][]){
        int startRow = 0, endRow = matrix.length - 1;
        int startCol = 0, endCol = matrix[0].length - 1;

        while(startRow <= endRow && startCol <= endCol ){
            //Top
            for(int j = startCol; j <= endCol; j++){
                System.out.print(matrix[startRow][j] + " ");
            }

            //right
            for(int i = startRow + 1; i <= endRow; i++){
                System.out.print(matrix[i][endCol] + " ");
            }

            //bottom
            for(int j = endCol - 1; j >= startCol; j--){
                // not want to top elent if printed the just avoid it to print again
                /*  
                if(startRow == startCol){
                    break;
                }
                */
                System.out.print(matrix[endRow][j] + " ");
            } 

            //left
            for(int i = endRow - 1; i >= startRow + 1; i--){
                // right element not print twice in left
                /*
                if(startCol == endCol){
                    break;
                }
                */
                System.out.print(matrix[i][startCol] + " ");
            }

            startCol++; startRow++;
            endCol--; endRow--;
        }
    }

    public static void diagonal(int matrix[][]){
        int sum = 0;
        // /* O(N^2) - T.C
        for(int i = 0 ; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if( i == j){
                    sum += matrix[i][j];
                }
                if(i + j == matrix.length - 1){
                    sum += matrix[i][j];
                }
            }
        }
        

        /* O(N) - T.C
        for(int i = 0 ; i < matrix.length; i++){
            // 1st diagonal
            sum += matrix[i][i];

            //2nd diagonal
            if( i != matrix.length - 1 -i){ // if one diagonal are sum include then dont's include it twice
                sum += matrix[i][matrix.length - 1 - i];
            }   
        }
        */
        System.out.println("Totall sum :- " + sum);
    }

    public static void Ssearchinortedmatrix(int matrix[][], int key){
        /*
        int row = 0, col = matrix[0].length - 1;
        T.C = O(N + M) numbers of distance on row and col
        while( row < matrix.length && col >= 0){
            if(matrix[row][col] == key){
                System.out.print("key found on index :- (" + row + ", " + col + ")");
                return;
            }else if(key < matrix[row][col]){
                col--;
            }
            else{
                row++;
            }
        }
        */
        int row = matrix.length - 1, col = 0;
        //T.C = O(N + M) numbers of distance on row and col
        while( row >= 0 && col < matrix[0].length ){
            if(matrix[row][col] == key){
                System.out.print("key found on index :- (" + row + ", " + col + ")");
                return;
            }else if(key < matrix[row][col]){
                row--;
            }
            else{
                col++;
            }
        }
        System.out.print("key is not found " );
    }

    //practice questions
    public static void frequenceNumber(int matrix[][], int key){
        int count = 0;
        for(int i = 0; i < matrix.length;i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == key){
                    count++;
                }
            }
        }
        if(count == 0){
            System.out.print("key is not foundS");
        }
        System.out.println("Totall no. of appear of Numbers : - " + count);
    }

    public static void secondndrowsum(int nums[][]){
        int sum = 0;

        // sum of 2nd row element
        for(int j = 0; j < nums[0].length; j++){
            sum += nums[1][j];
        }
        System.out.println("2nd row total sum :- " + sum);
    }
    public static void printoriginalmatrix(int matrix[][]){
        for(int i = 0; i < matrix.length; i++){
            for(int j =0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }      
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* 
        int n = sc.nextInt(); int m = sc.nextInt();
        int matrix[][] = new int[n][m];
        
        // input taking
        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                matrix[i][j] = sc.nextInt();
            }
        }

        // output
        for(int i = 0; i < n; i++){
            for(int j =0; j < m; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        */
        int matrix[][] = {{1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}};
    
        int matrixodd[][] = {{1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}};
        
        int key = 4;
        //linearsearch(matrix, key);// O(N^2)   
        
        //spiralmatrix(matrix);

        //diagonal(matrix);

        //Ssearchinortedmatrix(matrix, key);

        int array[][] = {{1, 2, 7},
                           {4, 8, 7}};
        key = 7;
        //frequenceNumber(array, key);

        //print the sum of 2nd row
        int nums[][] = {{1, 4, 9},
                        {11, 4, 3},
                        {2, 2, 3}};
        secondndrowsum(nums);

        //transposer of matrix

        int row = 2, column = 3;
        int newmatrix[][] = {{2, 3, 7},
                            {5, 6, 7}}; 
        
        printoriginalmatrix(newmatrix);

        int transposer[][] = new int[column][row];
        for(int i = 0; i < row; i++){
            for(int j = 0 ; j < column; j++){
                transposer[j][i] = matrix[i][j];
            }
        }
        printoriginalmatrix(transposer);

    }
}
