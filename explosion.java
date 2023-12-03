import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class explosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] S1 = scanner.nextLine().toCharArray();
        char[] S2 = scanner.nextLine().toCharArray();

        if (isEqual(S1, S2)) {
            System.out.println("00:00:00");
        } else {
            StringBuilder s1 = new StringBuilder();
            StringBuilder s2 = new StringBuilder();

            for (char c : S1) {
                if (c != '\r') {
                    s1.append(c);
                }
            }

            for (char c : S2) {
                if (c != '\r') {
                    s2.append(c);
                }
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            try {
                Date date1 = dateFormat.parse(s1.toString());
                Date date2 = dateFormat.parse(s2.toString());

                long diff = date2.getTime() - date1.getTime();
                long seconds = diff / 1000;
                long minutes = seconds / 60;
                long hours = minutes / 60;

                System.out.printf("%02d:%02d:%02d%n", hours, minutes % 60, seconds % 60);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
    private static boolean isEqual(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
