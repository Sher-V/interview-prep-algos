import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 6, 2, 4, 6, 19};
        int firstNum = arr[0], secondNum = arr[0], thirdNum = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= firstNum) {
                thirdNum = secondNum;
                secondNum = firstNum;
                firstNum = arr[i];
            } else if (arr[i] >= secondNum) {
                thirdNum = secondNum;
                secondNum = arr[i];
            } else if (arr[i] > thirdNum)
                thirdNum = arr[i];
        }

        System.out.println(Arrays.toString(new int[]{firstNum, secondNum, thirdNum}));
    }
}

// expected output: 19, 10, 6
