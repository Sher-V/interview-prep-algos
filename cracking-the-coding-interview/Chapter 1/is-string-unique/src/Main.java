import java.util.HashMap;

public class Main {

    public boolean isUnique(String str) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (dict.containsKey(str.charAt(i)))
                return false;
            dict.put(str.charAt(i), 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isUnique("abca"));
    }
}
