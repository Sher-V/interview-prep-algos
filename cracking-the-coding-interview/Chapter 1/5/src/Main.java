public class Main {

    public boolean isOneAway(String str1, String str2) {
        if (Math.abs(str1.length() - str2.length()) > 1) return false;

        boolean flag = false;

        for (int i = 0, j = 0; i < str1.length() && j < str2.length(); i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                if (flag) return false;
                flag = true;
                if (str1.length() < str2.length()) i--;
                else if (str2.length() < str1.length()) j--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.isOneAway("pale", "bale"));
    }
}
