import java.util.Arrays;
public class Inversion {
    private int[] numArr;
    public Inversion(int[] arr){
        numArr = arr;
    }
    public Inversion(){
        numArr = new int[]{10, 3, 2, 1, 4, 5, 6, 7};
    }

    // returns the number of inversions
    // O(n^2)
    public int easyInversionCount(){
        int count = 0;

        for(int i = 0; i < numArr.length; i++) {
            for(int j = i + 1; j < numArr.length; j++) {
                if(i < j && numArr[i] > numArr[j]){
                    count++;
                }
            }
        }

        return count;
    }

    // O(nlog(n))
    public int fastInvCount(){
        return fastInversionCount(numArr, 0, numArr.length - 1);
    }
    private int fastInversionCount(int[] arr, int leftVal, int rightVal){
        int count = 0;

        if(leftVal < rightVal) {
            // find the length (r - l), divide by 2 to get mid,
            // add left to get the mid of that range
            int midVal = leftVal + (rightVal - leftVal) / 2;

            count += fastInversionCount(arr, leftVal, midVal);
            count += fastInversionCount(arr, midVal + 1, rightVal);

            // now merge the halves and count inversions
            count += mergeAndCount(arr, leftVal, midVal, rightVal);
        }

        return count;
    }

    private int mergeAndCount(int[] arr, int leftVal, int midVal, int rightVal){
        int[] leftArray = Arrays.copyOfRange(arr, leftVal, midVal + 1);
        int[] rightArray = Arrays.copyOfRange(arr, midVal + 1, rightVal + 1);

        int count = 0;
        int i = 0, j = 0; // array indexes
        int k = leftVal; // index for merged array... start with leftmost index of the range

        // first need to merge the left and right array back together... sorted
        while(i < leftArray.length && j < rightArray.length){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            } else { // means leftArray[i] > rightArray[j]
                arr[k] = rightArray[j];
                j++;

                // midval - leftVal = total number of comparisions before right array > left array
                // + 1 to be inclusive of the midval
                // - i because i is the number of elements already merged
                count += midVal - leftVal + 1 - i;
            }
            k++;
        }

        // if completely sorted and there's still remaining, copy those into the new array
        // start with left array
        while(i < leftArray.length){
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // now the right array
        while(j < rightArray.length){
            arr[k] = rightArray[j];
            j++;
            k++;
        }

        return count;
    }
}
