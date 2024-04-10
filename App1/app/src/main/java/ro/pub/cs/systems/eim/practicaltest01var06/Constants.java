package ro.pub.cs.systems.eim.practicaltest01var06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.*;
public class Constants {

    public static HashSet<String> symbols = new HashSet<>(Arrays.asList("*", "1", "2", "3"));

    public static int REQUEST_CODE = 1473;

    public static ArrayList<String> generateRandom() {
        // Create a Random object
        Random random = new Random();
        ArrayList<String> generated = new ArrayList<>();

        // Generate and print 3 random elements (with possible repetition)
        for (int i = 0; i < 3; i++) {
            int randomIndex = random.nextInt(symbols.size());
            List<String> list = new ArrayList<>(symbols);
            String randomElement = list.get(randomIndex);
            generated.add(randomElement);
        }

        return generated;
    }


    public static boolean checkWin(ArrayList<String> generated) {
        String n1 = generated.get(0);
        String n2 = generated.get(1);
        String n3 = generated.get(2);

        return (n1 == n2 && n2 == n3) || (n1 == "*" && n2 == n3) || (n2 == "*" && n1 == n3) || (n3 == "*" && n1 == n2)
                || (n1 == "*" && n2 == "*") || (n1 == "*" && n3 == "*") || (n2 == "*" && n3 == "*");
    }

    public static int winAmount(Integer checks) {
        if (checks == 0) {
            return 100;
        }

        if (checks == 1) {
            return 50;
        }

        if (checks == 2) {
            return 10;
        }

        return 0;
    }
}
