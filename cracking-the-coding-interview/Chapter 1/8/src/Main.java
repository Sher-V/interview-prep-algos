import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public int[][] setMatrix(int[][] matrix) {

        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    hashSet1.add(i);
                    hashSet2.add(j);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (hashSet1.contains(i) || hashSet2.contains(j))
                    matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(Arrays.deepToString(main.setMatrix(new int[][]{
                {1, 2, 3, 4},
                {0, 2, 0, 4},
                {1, 2, 3, 4},
        })));
    }
}
