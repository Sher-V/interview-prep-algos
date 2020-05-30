public class BreadthFirstSearch {
    final int[] dr = new int[]{-1, 1, 0, 0};
    final int[] dc = new int[]{0, 0, 1, -1};
    String[][] matrix;
    Point startingPoint, endPoint;
    boolean[][] marked;

    static class Point {
        int i;
        int j;

        public Point(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static class queueNode {
        Point point;
        int dist;

        public queueNode(Point point, int dist) {
            this.point = point;
            this.dist = dist;
        }
    }


    public BreadthFirstSearch(String[][] matrix) {
        this.matrix = matrix;
        marked = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("S")) startingPoint = new Point(i, j);
                if (matrix[i][j].equals("E")) endPoint = new Point(i, j);
            }
    }

    public int bfs() {
        Queue<queueNode> queue = new Queue<>();
        queue.enqueue(new queueNode(startingPoint, 0));
        marked[startingPoint.i][startingPoint.j] = true;

        while (!queue.isEmpty()) {
            queueNode node = queue.dequeue();
            if (node.point.i == endPoint.i && node.point.j == endPoint.j) return node.dist;
            for (int i = 0; i < 4; i++) {
                int rr = node.point.i + dr[i];
                int cc = node.point.j + dc[i];
                if (rr >= 0 && rr <= matrix.length - 1 && cc >= 0 && cc <= matrix[0].length - 1 && !matrix[rr][cc].equals("#")) {
                    if (!marked[rr][cc]) {
                        queue.enqueue(new queueNode(new Point(rr, cc), node.dist + 1));
                        marked[rr][cc] = true;
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(
                new String[][]{
                        {"S", ".", ".", "#", ".", ".", "."},
                        {".", "#", ".", ".", ".", "#", "."},
                        {".", "#", ".", ".", ".", ".", "."},
                        {".", ".", "#", "#", ".", ".", "."},
                        {"#", ".", "#", "E", ".", "#", "."},
                }
        );
        int val = breadthFirstSearch.bfs();
        System.out.println(val);
    }
}
