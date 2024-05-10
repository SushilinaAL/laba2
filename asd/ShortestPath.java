package asd;

import asd.Map;

import java.util.*;

import static java.lang.Math.pow;

public class ShortestPath {
    public static double findShortestPath(int unitX, int unitY, int moveToX, int moveToY) {
        int mapSize = 15;
        ArrayList<ArrayList<Boolean>> visited = new ArrayList<>(mapSize);
        ArrayList<ArrayList<Distances>> distances = new ArrayList<>(mapSize);

        for (int i = 0; i < mapSize; i++) {
            visited.add(new ArrayList<>(mapSize));
            distances.add(new ArrayList<>(mapSize));
            for (int j = 0; j < mapSize; j++) {
                visited.get(i).add(false);

                distances.get(i).add(new Distances(i, j, 1000));
            }
        }

        distances.get(unitX).get(unitY).setDistance(0);

        Deque<Distances> deque = new ArrayDeque<>();
        deque.add(distances.get(unitX).get(unitY));

        while (!deque.isEmpty()) {
            Distances block = deque.remove();
            int x = block.getX();
            int y = block.getY();
            double distance = block.getDistance();

            if (x == moveToX && y == moveToY) {
                return distance;
            }

            int[][] neighbors = {{x, y - 1}, {x, y + 1}, {x - 1, y}, {x + 1, y},
                    {x - 1, y - 1}, {x - 1, y + 1}, {x + 1, y - 1}, {x + 1, y + 1}};

            for (int[] neighbor : neighbors) {
                if (isValid(neighbor[0], neighbor[1]) && !visited.get(neighbor[0]).get(neighbor[1])
                        && !visited.get(neighbor[0]).get(neighbor[1])) {
                    double newDistance = distance;
                    char cellValue = Map.returnMap(neighbor[0], neighbor[1]);

                    if (cellValue == '@') {
                        newDistance += 2;
                    } else if (cellValue == '#') {
                        newDistance += 1.5;
                    } else if (cellValue == '!') {
                        newDistance += 1.2;
                    } else {
                        newDistance += 1;
                    }

                    if (x != neighbor[0] && y != neighbor[1]) {
                        newDistance += calculateDistance(x, y, neighbor[0], neighbor[1]) - 1;
                    }

                    distances.get(neighbor[0]).get(neighbor[1]).setDistance(newDistance);
                    deque.add(distances.get(neighbor[0]).get(neighbor[1]));
                    visited.get(neighbor[0]).set(neighbor[1], true);
                }
            }
        }

        return 0;
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < 15 && y >= 0 && y < 15;
    }

    private static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(pow((x1 - x2), 2) + pow((y1 - y2), 2));
    }
}

class Distances {
    private final int x;
    private final int y;
    private double distance;

    Distances(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distance = distance;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    double getDistance() {
        return distance;
    }

    void setDistance(double distance) {
        this.distance = distance;
    }
}