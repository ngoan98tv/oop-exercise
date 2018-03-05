package buoi1_bai3;

/**
 *
 * @author Ngoan Tran
 */
import java.util.Arrays;

public class Buoi1_Bai3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        float[] A;
        int n = args.length;
        A = new float[n];
        System.out.println("Arguments: " + Arrays.toString(args));
        
        for (int i=0; i<n; i++){
            try {
                A[i] = Float.parseFloat(args[i]);
            } catch (NumberFormatException e){
                A[i] = 0;
            }
        }
        System.out.println("Float Array: " + Arrays.toString(A));
        System.out.println("Max of the array: " + getMax(A,n));
        System.out.println("Sum all of elements: " + getSum(A,n));
    }

    private static float getMax(float A[], int n){
        float max = A[0];
        for (int i=1; i<n; i++){
            if (max < A[i])
                max = A[i];
        }
        return max;
    }

    private static float getSum(float A[], int n){
        float sum = 0;
        for (int i=0; i<n; i++){
            sum += A[i];
        }
        return sum;
    }
}
