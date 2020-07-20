import java.util.Arrays;

public class Main {

    public int[][] rotate(int[][] matrix) throws IllegalArgumentException {
        if (matrix.length == 0 || matrix.length != matrix[0].length)
            throw new IllegalArgumentException("Length of an array is not acceptable");

        int length = matrix.length / 2;

        for (int layer = 0; layer < length / 2; layer++) {
            int last = length - 1 - layer;

            for (int i = layer; i < last; i++) {
                int offset = i - layer;

                int top = matrix[layer][i];

                // top equals to left
                matrix[layer][i] = matrix[last - offset][layer];

                // left equals to bottom
                matrix[last - offset][layer] = matrix[last][last - offset];

                // bottom equals to right
                matrix[last][last - offset] = matrix[i][last];

                // right equals to top
                matrix[i][last] = top;
            }

        }

        return matrix;
    }


    public static void main(String[] args) {

        Main main = new Main();
        System.out.println(Arrays.deepToString(main.rotate(
                new int[][]{
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16},
                })));

    }
}
