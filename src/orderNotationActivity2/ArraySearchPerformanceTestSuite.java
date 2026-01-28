package orderNotationActivity2;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

// TODO: Add a link to your google sheet here: 

public class ArraySearchPerformanceTestSuite implements PerformanceTestSuite {

    public static void main(String[] args) {
        PerformanceTester tester = new PerformanceTester(new ArraySearchPerformanceTestSuite());
        tester.testAcrossSizes(200, 6000);
        tester.dumpResults();
    }

    public List<String> getHeadings() {
        return Arrays.asList(
            "Sequential Search",
            "Binary Search"
        );
    }

    public List<Runnable> makeTasks(int size) {
        return Arrays.asList(
            new SequentialSearchTask(size),
            new BinarySearchTask(size)
        );
    }

    // –––––– Tasks to test ––––––

    private static class SequentialSearchTask implements Runnable {
        private final int maxSize;
        private final int[] array;
        private final Random randGenerator;

        SequentialSearchTask(int maxSize) {
            this.maxSize = maxSize;
            this.array = IntStream.range(0, maxSize).toArray();
            randGenerator = new Random();
        }

        @Override
        public void run() {
            int target = randGenerator.nextInt(maxSize);

            for(int i = 0; i < maxSize; i++ ) {
                if (array[i] == target){
                    return;
                }
            }
        }
    }

    private static class BinarySearchTask implements Runnable {
        private final int maxSize;
        private final int[] array;
        private final Random randGenerator;

        BinarySearchTask(int maxSize) {
            this.maxSize = maxSize;
            this.array = IntStream.range(0, maxSize).toArray();
            randGenerator = new Random();
        }

        @Override
        public void run() {
            int target = randGenerator.nextInt(maxSize);
            int left = 0;
            int right = array.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (array[mid] == target){
                    return;
                } else if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
    }
  }