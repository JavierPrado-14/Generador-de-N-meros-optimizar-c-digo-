import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

 class SortNumbers {
    public static void main(String[] args) {
        int[] numbers = generateRandomNumbers(1000000);
        String fileName = "randomNumbers.txt";
        saveNumbersToFile(numbers, fileName);
        bubbleSort(numbers);
        saveNumbersToFile(numbers, "bubbleSortNumbers.txt");
        numbers = generateRandomNumbers(1000000);
        saveNumbersToFile(numbers, fileName);
        shellSort(numbers);
        saveNumbersToFile(numbers, "shellSortNumbers.txt");
        numbers = generateRandomNumbers(1000000);
        saveNumbersToFile(numbers, fileName);
        insertionSort(numbers);
        saveNumbersToFile(numbers, "insertionSortNumbers.txt");
    }

    public static int[] generateRandomNumbers(int size) {
        Random rand = new Random();
        int[] numbers = new int[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt() % 1000000;
        }
        return numbers;
    }

    public static void saveNumbersToFile(int[] numbers, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < numbers.length; i++) {
                writer.write(numbers[i] + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occurred while saving the numbers to file: " + e.getMessage());
        }
    }

    public static void bubbleSort(int[] numbers) {
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void shellSort(int[] numbers) {
        int n = numbers.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = numbers[i];
                int j;
                for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap) {
                    numbers[j] = numbers[j - gap];
                }
                numbers[j] = temp;
            }
        }
    }

    public static void insertionSort(int[] numbers) {
        int n = numbers.length;
        for (int i = 1; i < n; ++i) {
            int key = numbers[i];
            int j = i - 1;
            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
            }
            numbers[j + 1] = key;
        }
    }
}