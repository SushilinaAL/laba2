package asd;

import java.util.*;

public class Map {
    private static final int mapSize = 15;
    private static final ArrayList<ArrayList<Character>> map = new ArrayList<>(mapSize);

    public static void createMap() {
        for (int i = 0; i < mapSize; i++) {
            map.add(new ArrayList<>(mapSize));
            for (int j = 0; j < mapSize; j++) {
                map.get(i).add('*');
            }
        }

        map.get(new Random().nextInt(13)+1).set(new Random().nextInt(15), '!');
        map.get(new Random().nextInt(13)+1).set(new Random().nextInt(15), '@');
        map.get(new Random().nextInt(13)+1).set(new Random().nextInt(15), '#');
        map.get(new Random().nextInt(13)+1).set(new Random().nextInt(15), '!');
        map.get(new Random().nextInt(13)+1).set(new Random().nextInt(15), '#');
        map.get(new Random().nextInt(13)+1).set(new Random().nextInt(15), '@');
        map.get(new Random().nextInt(13)+1).set(new Random().nextInt(15), '!');
    }

    public static Character returnMap(int x, int y) {
        return map.get(y).get(x);
    }


    public static void showMap() {
        for(int i = 0; i < 15; i++) {
            System.out.print(i);
            if (i>=0 && i < 10) {
                System.out.print("  ");
            }else {
                System.out.print(" ");
            }

        }
        System.out.println(" ");
        System.out.println(" ");
        for (int i = 0; i < mapSize; i++) {

            for (int j = 0; j < mapSize; j++) {
                System.out.print(map.get(i).get(j));
                System.out.print("  ");

            }
            System.out.print(i);
            System.out.println(" ");
        }
    }

    public static void addToMap(int x, int y, Character index) {
        map.get(y).set(x, index);
    }

    public static void removeFromMap(int x, int y) {
        map.get(y).set(x, '*');
    }
}
