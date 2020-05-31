import java.util.*;

class Main {
    private final int[] dr = new int[]{1, -1, 0, 0};
    private final int[] dc = new int[]{0, 0, 1, -1};
    private final int[][] matrix;
    private final boolean[][] seen;

    public Main(int[][] matrix) {
        this.matrix = matrix;
        seen = new boolean[matrix.length][matrix[0].length];
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private boolean isValid(Point point) {
        return point.x >= 0 && point.y >= 0 && point.x < matrix.length && point.y < matrix[0].length;
    }

    public int dfs(int x, int y) {
        Stack<Point> stack = new Stack<>();
        Point startingPoint = new Point(x, y);
        stack.push(startingPoint);
        seen[x][y] = true;
        int count = 1;

        while (!stack.isEmpty()) {
            Point current = stack.pop();

            for (int i = 0; i < 4; i++) {
                Point point = new Point(current.x + dr[i], current.y + dc[i]);
                if (isValid(point) && !seen[point.x][point.y] && matrix[point.x][point.y] == 1) {
                    seen[point.x][point.y] = true;
                    stack.push(point);
                    count++;
                }
            }
        }
        return count;
    }

    public List<Integer> riverSizes() {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !seen[i][j]) {
                    result.add(dfs(i, j));
                }
            }
        return result;
    }

    public static void main(String[] args) {
        Main main = new Main(new int[][]{
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0},
        }
        );
        System.out.println(main.riverSizes());
    }
}
