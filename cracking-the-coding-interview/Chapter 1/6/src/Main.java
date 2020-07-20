public class Main {

    public String compress(String str) {

        int counter = 1;
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i == 0) {
                res.append(str.charAt(i));
                continue;
            }
            if (str.charAt(i) == str.charAt(i - 1)) counter++;
            else if (counter == 1) res.append(str.charAt(i));
            else {
                res.append(counter);
                res.append(str.charAt(i));
                counter = 1;
            }
            if (i == str.length() - 1) {
                if (counter != 1) res.append(counter);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.compress("aabcda"));

    }
}
