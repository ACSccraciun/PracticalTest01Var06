package ro.pub.cs.systems.eim.practicaltest01var06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.*;
public class Constants {

    public static HashSet<String> symbols = new HashSet<>(Arrays.asList("*", "1", "2", "3"));

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

}
