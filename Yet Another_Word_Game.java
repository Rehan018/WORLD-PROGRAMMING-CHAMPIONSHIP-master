import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Yet_Another_Word {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        List<List<String>> arr = new ArrayList<>();
        List<Integer> pointer = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            arr.add(new ArrayList<>());
            pointer.add(0);
        }

        while (t != 0) {
            String s = scanner.nextLine();
            int ind = Math.abs('a' - s.charAt(0));
            arr.get(ind).add(s);
            arr.get(ind).sort(String::compareTo);

            t--;
        }

        String[] choices = scanner.nextLine().split(" ");

        for (String choice : choices) {
            int ind = Math.abs('a' - choice.charAt(0));
            System.out.println(arr.get(ind).get(pointer.get(ind)));

            pointer.set(ind, (pointer.get(ind) + 1) % arr.get(ind).size());
        }
    }
}
