
import java.util.Scanner;

public class Hackerman_and_his_chessboard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int r = scanner.nextInt();
        int c = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        String firstRow = ("X".repeat(b) + ".".repeat(b)).repeat(b);
        StringBuilder firstRowModified = new StringBuilder();

        firstRow = firstRow.repeat(c * b / 2);

        for (int i = 0; i < c * b; i++) {
            try {
                firstRowModified.append(firstRow.charAt(i));
            } catch (StringIndexOutOfBoundsException e) {
                // handle exception
            }
        }
        firstRow = firstRowModified.toString();

        String invert = (".".repeat(b) + "X".repeat(b)).repeat(b);
        StringBuilder invertModified = new StringBuilder();

        invert = invert.repeat((c * b) / 2);

        for (int i = 0; i < c * b; i++) {
            try {
                invertModified.append(invert.charAt(i));
            } catch (StringIndexOutOfBoundsException e) {
                // handle exception
            }
        }
        invert = invertModified.toString();

        String[] ans = new String[r * a];

        int idx = 0;
        for (int i = 0; i < r * a; ) {
            int ca = a;
            while (ca != 0 && i < r * a) {
                ans[idx++] = firstRow;
                ca--;
                i++;
            }
            ca = a;
            while (ca != 0 && i < r * a) {
                ans[idx++] = invert;
                ca--;
                i++;
            }
        }

        for (String row : ans) {
            System.out.println(row);
        }
    }
}
