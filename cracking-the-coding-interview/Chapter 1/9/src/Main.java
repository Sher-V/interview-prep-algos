import java.util.HashMap;

public class Main {


    private static boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return isSubstring(s1, s2);
    }

    private static boolean isSubstring(String s1, String s2) {
        HashMap<Character, Integer> s1Characters = new HashMap<>();
        HashMap<Character, Integer> s2Characters = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            Character ch1 = s1.charAt(i), ch2 = s2.charAt(i);
            if (s1Characters.containsKey(ch1)) s1Characters.put(ch1, s1Characters.get(ch1) + 1);
            else s1Characters.put(ch1, 1);
            if (s2Characters.containsKey(ch2)) s2Characters.put(ch2, s2Characters.get(ch2) + 1);
            else s2Characters.put(ch2, 1);
        }

        return s1Characters.equals(s2Characters);
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isRotation("waterbottle!", "erbottle!wat"));
    }
}
