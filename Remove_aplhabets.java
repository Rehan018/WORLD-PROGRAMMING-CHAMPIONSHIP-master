import java.util.Scanner;

public class Remove_aplhabets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] s = scanner.nextLine().toCharArray();
        char[] stri = "CAMBRIDGE".toCharArray();
        StringBuilder ans = new StringBuilder();

        for (char ch : s) {
            ans.append(ch);
            ans.append(" ");
        }

        for (char ch : stri) {
            ans = new StringBuilder(ans.toString().replace(Character.toString(ch), " "));
        }

        char[] ansArray = ans.toString().toCharArray();
        StringBuilder finalAns = new StringBuilder();

        for (char ch : ansArray) {
            if (ch != ' ') {
                finalAns.append(ch);
            }
        }

        System.out.println(finalAns.toString());
    }
}
