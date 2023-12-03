import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = scanner.nextInt();
        List<Integer> V = new ArrayList<>();
        while (v != 0) {
            V.add(scanner.nextInt());
            v--;
        }

        int n = scanner.nextInt();
        List<Integer> N = new ArrayList<>();
        while (n != 0) {
            N.add(scanner.nextInt());
            n--;
        }

        Set<Integer> ans = new HashSet<>(V);
        ans.addAll(N);

        int c = 0;
        for (int value : ans) {
            if (value <= 1440) {
                c++;
            }
        }
        System.out.println(c);

        c = 0;

        int l = Math.min(V.size(), N.size());
        for (int i = 0; i < l - 1; i++) {
            if ((V.get(i) > N.get(i) && V.get(i + 1) < N.get(i + 1))
                    || (V.get(i) < N.get(i) && V.get(i + 1) > N.get(i + 1))) {
                c++;
            }
        }
        System.out.println(c);
    }
}
