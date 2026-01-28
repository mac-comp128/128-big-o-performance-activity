package orderNotationActivity2;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class BigODrills2 {
    
    // 1.
    // TODO: What is O(     ) of the following code?
    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    // 2.
    // TODO: What is O(     ) of the following code?
    public static boolean areYouHere(int[] arr1, int[] arr2) {
        for (int el1 : arr1) {
            for (int el2 : arr2) {
                if (el1 == el2) {
                    return true;
                }
            }
        }
        return false;
    }

    // 3. 
    // TODO: What is O(     ) of the following code?
    public static int[] doubleArrayValues(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
        return array;
    }

    // 4.
    // TODO: What is O(     ) of the following code?
    public static void createPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                System.out.println(arr[i] + ", " + arr[j]);
            }
        }
    }

    // 5.
    // TODO: What is O(     ) of the following code?
    public static List<Integer> generateFib(int num) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                result.add(0); // You can assume that add is O(1)
            } else if (i == 2) {
                result.add(1);
            } else {
                result.add(result.get(i - 2) + result.get(i - 3)); // You can assume that get is O(1)
            }
        }
        return result;
    }

    // 6.
    // TODO: What is O(     ) of the following code?
    public static int findRandomElement(int[] arr) {
        Random rand = new Random();
        return arr[rand.nextInt(arr.length)];
    }

    // 7. 
    // TODO: What is O(     ) of the following code?
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 8. 
    // TODO: What is O(     ) of the following code?
    public static boolean isPrimeAlternative(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true; // 2 and 3 are prime
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        // Check only numbers of the form 6k ± 1
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }


    // 9. 
    // TODO: What is O(     ) of the following code?
    public static int factorialOf(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialOf(n - 1);
    }

    // 10. 
    // TODO: What is O(     ) of the following code?.
    public static int generateFibRecursive(int num) {
        if(num < 2) {
            return num;
        }
        else {
            return generateFibRecursive(num - 1) + generateFibRecursive(num - 2);
        }
    }
}
