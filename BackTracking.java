public class BackTracking {

    public static void changeArr(int arr[], int i, int val){
        if(i == arr.length){
            printArr(arr);
            return;
        }

        arr[i] = val;
        changeArr(arr, i+1, val+1);
        arr[i] = arr[i] - 2;
    }

    public static void printArr(int arr[]){
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void findsubset(String str,int i, String ans ){
        if(i == str.length()){
            if(ans.length() == 0){
                System.out.println("null");
            }else{
                System.out.println(ans);   
            }
            return;
        }
        

        //Yes Choice
        findsubset(str, i+1, ans + str.charAt(i));

        //Not Choice
        findsubset(str, i+1, ans);
    }

    public static void findPermutation(String str, String ans){
        //Base Case
        if(str.length() == 0){
            System.out.println(ans);
            return;
        }
        //recursion - O(N*N)
        for(int i = 0 ; i < str.length(); i++){
            char curr = str.charAt(i);
            //"abcde" = "abc" + "de" = "abde"
            String newStr = str.substring(0, i) + str.substring(i+1);

            findPermutation(newStr, ans + curr);
        }
    }

    public static boolean isSafe(char board[][], int row, int col){
        //Vertical up
        for(int i = row - 1; i >=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        //Diagnol left
        for(int i = row -1 , j = col - 1; i >=0 && j >= 0; i--,j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //Diagnol right
        for(int i = row -1, j = col + 1; i >=0 && j < board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    //print all solutions
    public static void nQueens(char board[][], int row){
        //Base Case
        if(row == board.length){
            printBoard(board);
            return;
        }
        for(int j = 0 ; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueens(board, row + 1);
                board[row][j] = 'x';
            }
        }
    }

    static int count = 0; //Global variable

    //Count Ways
    public static void nQueensCount(char board[][], int row){
        //Base Case
        if(row == board.length){
            //printBoard(board);
            count++;
            return;
        }

        //Column Loop
        for(int j = 0 ; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                nQueensCount(board, row + 1);
                board[row][j] = 'x';
            }
        }
    }

    public static boolean nQueens1(char board[][], int row){
        //Base Case
        if(row == board.length){
            printBoard(board);
            return true;
        }
        //Colum Loop
        for(int j = 0 ; j<board.length; j++){
            if(isSafe(board, row, j)){
                board[row][j] = 'Q';
                if(nQueens1(board, row + 1)){
                    return true;
                }
                board[row][j] = 'x'; //BackTracking Step
            }
        }
        return false;
    }

    //print 1 solutions
    public static void printBoard(char board[][]){
        System.out.println("------ Chess Board ------");
        for(int i = 0 ; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int gridways(int i, int j, int n, int m){
        //base case
        if(i == n - 1 && j == m - 1){
            return 1;
        }else if(i == n || j == m){
            return 0;
        }

        int w1 = gridways(i+1, j, n, m);
        int w2 = gridways(i, j+1, n, m);
        return w1 + w2;
    }

    public static boolean isSafeSudoku(int sudoku[][], int row, int col, int digit){
        //Column
        for(int i= 0; i <=8; i++){
            if(sudoku[i][col] == digit){
                return false;
            }
        }

        //Row
        for(int j =0; j<=8; j++){
            if(sudoku[row][j] == digit){
                return false;
            }
        }

        //Grid
        int sr = (row/3) * 3;
        int sc = (col/3) * 3;

        //3*3 Grid
        for(int i = sr; i < sr+3; i++){
            for(int j = sc; j < sc+3; j++){
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudokuSolver(int sudoku[][], int row, int col){
        //base case 
        /*if(row == 9){
            return true;
        }
        */
        if(row == 9 && col == 0){
            return true;
        }else if(row == 9){
            return false;
        }

        //recursion
        int nextRow = row, nextCol = col + 1;
        if(col+1 == 9){
            nextRow = row + 1;
            nextCol = 0;
        }

        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit = 1; digit<=9; digit++){
            if(isSafeSudoku(sudoku, row, col, digit)){
                sudoku[row][col] = digit;
                if(sudokuSolver(sudoku, nextRow, nextCol)){
                    // solve exists
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }

    public static void printsudoku(int sudoku[][]){
        for(int i = 0; i <9; i++){
            for(int j = 0; j < 9; j++){
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Rate In Maze
    public static void printSolRateInMaze(int[][] sol){
        for(int i = 0; i < sol.length;i++){
            for(int j = 0; j<sol.length;j++){
                System.out.print(" " + sol[i][j] + " ");
            }System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int x, int y){
        //if ( x, y outsize maze) return false
        return (x >=0 && x < maze.length && y >=0 && y < maze.length && maze[x][y] == 1);
    }

    public static boolean solveMaze(int maze[][]){
        int N = maze.length;
        int sol[][] = new int[N][N];

        if(solveMazeUtil(maze, 0, 0, sol) == false){
            System.out.println("Solution doesn't exist");
            return false;
        }
        printSolRateInMaze(sol);
        return true;
    }

    public static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]){
        if(x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1){
            sol[x][y] = 1;
            return true;
        }
        //check if maze[x][y] is Valid
        if(isSafe(maze, x, y) == true){
            if(sol[x][y] == 1){
                return false;
            }
            sol[x][y] = 1;
            if(solveMazeUtil(maze, x+1, y, sol)){
                return true;
            }
            if(solveMazeUtil(maze, x, y +1, sol)){
                return true;
            }
            sol[x][y]=0;//backtracking
            return false;
        }

        return false;
    }

    final static char[][] L = {{},{}, {'a','b','c'}, {'d','e','f'},
                     {'g','h','i'}, {'j','k','l'}, {'m', 'n', 'o'},
                     {'p','q','r'}, {'s','t','v'},{'w','x','y','z'}};

    public static void letterCombination(String d){
        int len = d.length();
        if(len == 0){
            System.out.println("");
            return;
        }
        bfs(0, len, new StringBuilder(), d);
    }

    public static void bfs(int pos, int len, StringBuilder sb, String d){
        if(pos == len){
            System.out.println(sb.toString());
        }else{
            char[] letters = L[Character.getNumericValue(d.charAt(pos))];
            for(int i =0; i < letters.length; i++){
                bfs(pos+1, len, new StringBuilder(sb).append(letters[i]), d);
            }
        }
    }

    

    public static void main(String[] args) {
        int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);

        // String str = "abc";
        // findsubset(str, 0, "");

        // String str = "abc";
        // findPermutation(str, "");

        // N Queen
        int n = 5;
        char board[][] = new char[n][n];
        //Intilize
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = '.';
            }
        }

        //print all solutions
        //nQueens(board, 0);

        //Count Ways
        // nQueensCount(board, 0);
        // System.out.println("Totall ways to solve n Queens = " + count);

        //print 1 solutions
        //nQueens1(board, 0);

        //no. of way reach from (0,0) to (N-1, M-1) :- gridProblem
        // int N = 3, M = 3;
        // System.out.println(gridways(0, 0, N, M));
 
        //Sudoku Solver
        // int sudoku[][] = {{0, 0, 8, 0, 0, 0, 0, 0, 0},
        // {4, 9, 0, 1, 5, 7, 0, 0, 2},
        // {0, 0, 3, 0, 0, 4, 1, 9, 0},
        // {1, 8, 3, 0, 6, 0, 0, 2, 0},
        // {0, 0, 0, 0, 2, 0, 0, 6, 0},
        // {9, 6, 0, 4, 0, 5, 3, 0, 0},
        // {0, 3, 0, 0, 7, 2, 0, 0, 4},
        // {0, 4, 9, 0, 3, 0, 0, 5, 7}, 
        // {8, 2, 7, 0, 0, 9, 0, 1, 3}};

        // if(sudokuSolver(sudoku, 0, 0)){
        //     System.out.println("Solution exists");
        //     printsudoku(sudoku);
        // }else{
        //     System.out.println("Solution does not exist");
        // }

        //Rate In Maze
        // int maze[][] = {{1, 0, 0, 0},
        //                 {1, 1, 0, 1},
        //                 {0, 1, 0, 1},
        //                 {1, 1, 1, 1}};

        // solveMaze(maze);

        letterCombination("2");

    }
}