import java.util.HashMap;

public class Main {

    public boolean isPermutation(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Character key = str.charAt(i);
            if (key == ' ') continue;
            if (hashMap.containsKey(key)) hashMap.put(key, hashMap.get(key) + 1);
            else hashMap.put(key, 1);
        }

        boolean flag = false;

        for (Integer value :  hashMap.values()) {
            if (value % 2 != 0) {
                if (flag) return false;
                flag = true;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isPermutation("tactcoapapa"));
    }
}
