import java.util.Arrays;
import java.util.Collection;
import java.util.*;;
public class BasicSort {

    public static void bubbleSort(int[] numbers){
        int n = numbers.length;
        for(int tern = 0 ; tern < n - 1; tern++ ){
            for(int j = 0; j < n-1- tern; j++){
                if(numbers[j] > numbers[j+1]){
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void bubbleSortReverse(int[] numbers){
        int n = numbers.length;
        for(int tern = 0 ; tern < n - 1; tern++ ){
            for(int j = 0; j < n-1- tern; j++){
                if(numbers[j] < numbers[j+1]){
                    int temp = numbers[j + 1];
                    numbers[j + 1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    // as optimization we just reduce the swap but the T.C is stil O(N) couse using 2 loop - 1 is outer for tern ans 2. innerloop for check one by one
    // check that i is smallert then j // 2. for comparison
    public static void selectionSort(int[] numbers){
        int n = numbers.length;
        for(int i = 0 ; i < n - 1; i++ ){
            int minpos = i ;
            for(int j = i + 1; j< n -1; j++){
                if(numbers[minpos] > numbers[j]){
                    minpos = j;
                }
            }
            // swap
            int temp = numbers[minpos];
            numbers[minpos] = numbers[i];
            numbers[i] = temp;            
        }
    }

    public static void selectionSortReverse(int[] numbers){
        int n = numbers.length;
        for(int i = 0 ; i < n - 1; i++ ){
            int minpos = i ;
            for(int j = i + 1; j<= n -1; j++){
                if(numbers[minpos] < numbers[j]){
                    minpos = j;
                }
            }
            // swap
            int temp = numbers[minpos];
            numbers[minpos] = numbers[i];
            numbers[i] = temp;            
        }
    }

    public static void insertionSort(int[] numbers){
        int n = numbers.length;
        for(int i = 1; i < n - 1; i++){
            int curr = numbers[i];
            int prev = i-1;
            while(prev >= 0 && numbers[prev] > curr){
                numbers[prev + 1] = numbers[prev];
                prev--;
            }

            //Insertion 
            numbers[prev + 1 ] = curr;
        }
    }

    public static void insertionSortReverse(int[] numbers){
        int n = numbers.length;
        for(int i = 1; i <= n - 1; i++){
            int curr = numbers[i];
            int prev = i-1;
            while(prev >= 0 && numbers[prev] < curr){
                numbers[prev + 1] = numbers[prev];
                prev--;
            }

            //Insertion 
            numbers[prev + 1 ] = curr;
        }
    }

    public static void countSort(int[] numbers){
        int largest = Integer.MIN_VALUE;
        // to know the lenth of our frequency array
        for(int i = 0; i < numbers.length; i++){
            largest = Math.max(largest, numbers[i]);
        }

        int count[] = new int[largest + 1]; // becouse of zero base indexing and we don't want we get out of bound
        for(int i =0; i < numbers.length; i++){
            count[numbers[i]]++;
        }
        // Sorting
        int j = 0; // here we traverse and put the index of count array and write in original array
        for(int i = 0; i < count.length; i++){
            while(count[i] >0){
                numbers[j] = i; // just updating or sortion the original numbers array
                j++; // just ging to next index of original nubers array
                count[i]--; // just reducing value one by one in each iteration
            }
        }
    }

    public static void countSortReverse(int[] numbers){
        int largest = Integer.MIN_VALUE;
        // to know the lenth of our frequency array
        for(int i = 0; i < numbers.length; i++){
            largest = Math.max(largest, numbers[i]);
        }

        int count[] = new int[largest + 1]; // becouse of zero base indexing and we don't want we get out of bound
        for(int i =0; i < numbers.length; i++){
            count[numbers[i]]++;
        }
        // Sorting
        int j = 0; // here we traverse and put the index of count array and write in original array
        for(int i = 0; i < count.length; i++){
            while(count[i] > 0){
                numbers[j] = i; // just updating or sortion the original numbers array
                j++; // just ging to next index of original nubers array
                count[i]--; // just reducing value one by one in each iteration
            }
        }
    }


    public static void printArr(int[] numbers){
        for(int i = 0 ; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
    }

    // fuction overloaing for used Collection class becouse Collection ony take object not take primity data type
    public static void printArr(Integer[] numbers){
        for(int i = 0 ; i < numbers.length; i++){
            System.out.print(numbers[i] + " ");
        }
    }
    public static void main(String[] args) {
        int[] numbers= {5, 6, 3, 1, 2, 6};
        //Integer[] numbers= {5, 6, 3, 1, 2, 6}; // for using collection sort inbuid algo

        //bubbleSort(numbers);
        //bubbleSortReverse(numbers);

        //selectionSort(numbers);
        //selection SortReverse(numbers);

        //nsertionSort(numbers);
        //insertionSortReverse(numbers);

        // Inbuid sorting in acending order, first import java.util.ArrayList;
        //Arrays.sort(numbers); // for acending order

        //Arrays.sort(numbers, 0, 3); // for sort in certain range always remember last index when you write index alway writ +1 more becouse of non-inclosure property.

        // decending order sort first import java.util.Collection 
        //Arrays.sort(numbers, Collections.reverseOrder());

        //Arrays.sort(numbers, 0, 3, Collections.reverseOrder()); // for sort ecending order in certain range

        //countSort(numbers);
        countSortReverse(numbers);
        printArr(numbers);
    }
}
