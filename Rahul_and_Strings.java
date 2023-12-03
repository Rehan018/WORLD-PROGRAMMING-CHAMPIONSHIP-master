import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Rahul_and_Strings  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        while (t != 0) {
            char[] A = scanner.nextLine().toCharArray();
            char[] B = scanner.nextLine().toCharArray();

            int i = 0;
            List<Character> cb = new ArrayList<>();
            for (char ch : B) {
                cb.add(ch);
            }
            List<Character> ans = new ArrayList<>();

            while (B.length != 0) {
                if (A.length == 0) {
                    break;
                }

                if (Character.toLowerCase(B[i]) == Character.toLowerCase(A[0])) {
                    ans.add(B[i]);
                    B = removeElement(B, i);

                    A = removeElement(A, 0);
                } else {
                    A = removeElement(A, 0);
                }
            }

            if (isEqual(ans, cb)) {
                int flag = 0;

                if (A.length != 0) {
                    for (char ch : A) {
                        if (ch >= 'A' && ch <= 'Z') {
                            flag = 1;
                            break;
                        }
                    }
                }

                if (flag == 0) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                System.out.println(0);
            }

            t--;
        }
    }

    private static char[] removeElement(char[] arr, int index) {
        char[] newArray = new char[arr.length - 1];
        System.arraycopy(arr, 0, newArray, 0, index);
        System.arraycopy(arr, index + 1, newArray, index, arr.length - index - 1);
        return newArray;
    }

    private static boolean isEqual(List<Character> list1, List<Character> list2) {
        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }

        return true;
    }
}
