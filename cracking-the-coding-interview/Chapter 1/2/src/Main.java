import java.util.ArrayList;

public class Main {
    public void replace(ArrayList<Character> str) {
        boolean isSpace, isEnd = true;
        for (int i = str.size() - 1; i > -1; i--) {
            isSpace = str.get(i).equals(' ');
            if (isEnd && isSpace) {
                str.remove(i);
                continue;
            }
            else isEnd = false;
            if (isSpace) {
                str.set(i, '%');
                str.add(i + 1, '2');
                str.add(i + 2, '0');
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        Main main = new Main();
        ArrayList<Character> str = new ArrayList<>();
        for (char c : "Mr John Smith     ".toCharArray()) {
            str.add(c);
        }
        main.replace(str);
    }
}
