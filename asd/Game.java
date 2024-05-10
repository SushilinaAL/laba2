package asd;

import asd.Bot;
import asd.Map;
import asd.Unit;
import asd.Actions;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);
    private static boolean playerSide = true;

    public static void createOptions() {


        if (checkIfEnded()) {
            showEndMenu();
            System.exit(0);
        }
        if (!playerSide) {
            Bot.makeAMove();
        }

        Menu.clearConsole();

        Map.showMap();
        int x;
        int y;

        System.out.print("Выберете следующее действие: \n1. Атака\n2. Передвижение\n");
        switch (scanner.nextInt()) {
            case 1:
                System.out.print("Введите координату X юнита, которым атакуете: ");
                x = scanner.nextInt();
                System.out.print("Введите координату Y юнита, которым атакуете: ");
                y = scanner.nextInt();
                attack(x, y);
                break;
            case 2:
                System.out.print("Введите координату X юнита, которым атакуете: ");
                x = scanner.nextInt();
                System.out.print("Введите координату Y юнита, которым атакуете: ");
                y = scanner.nextInt();
                move(x, y);
        }
    }

    public static void attack(int x, int y) {
        ArrayList<Unit> units = UnitCreation.getUnits();

        for (Unit unit : units) {
            if (unit.getCoords()[0] == x && unit.getCoords()[1] == y) {

                System.out.print("Введите координату X юнита, которого атакуете: ");
                int moveToX = scanner.nextInt();
                System.out.print("Введите координату Y юнита, которого атакуете: ");
                int moveToY = scanner.nextInt();

                if (checkGivenPointForAttack(moveToX, moveToY)) {
                    Actions.attack(unit, x, y, moveToX, moveToY, Bot.getUnits());
                } else {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            }
        }

        createOptions();
    }

    private static void move(int x, int y) {
        ArrayList<Unit> units = UnitCreation.getUnits();

        for (Unit unit : units) {
            if (unit.getCoords()[0] == x && unit.getCoords()[1] == y) {

                System.out.print("Введите координату X, куда хотите переместить юнита: ");
                int moveToX = scanner.nextInt();
                System.out.print("Введите координату Y, куда хотите переместить юнита: ");
                int moveToY = scanner.nextInt();

                if (checkGivenPoint(moveToX, moveToY)) {
                    Actions.move(unit, x, y, moveToX, moveToY);
                } else {
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                break;
            }
        }

        createOptions();
    }

    private static boolean checkGivenPoint(int x, int y) {
        char cellValue = Map.returnMap(x, y);

        if (x < 0 || x > 14 || y < 0 || y > 14) {
            System.out.println("\nВы вышли за границу карту\n");
            return false;
        } else if (cellValue == '#' || cellValue == '@' || cellValue == '!') {
            System.out.println("\nВы наткнулись на препятствие\n");
            return false;
        } else if (cellValue != '*') {
            System.out.println("\nЗанято другим юнитом\n");
            return false;
        } else {
            return true;
        }
    }

    private static boolean checkGivenPointForAttack(int x, int y) {
        char cellValue = Map.returnMap(x, y);

        if (x < 0 || x > 14 || y < 0 || y > 14) {
            System.out.println("\nВы вышли за границу карту\n");
            return false;
        } else if (cellValue == '#' || cellValue == '@' || cellValue == '!') {
            System.out.println("\nВы наткнулись на препятствие\n");
            return false;
        } else if (cellValue == '*') {
            System.out.println("\nНекого атаковать\n");
            return false;
        } else {
            return true;
        }
    }

    public static void changeSide(boolean side) {
        playerSide = side;
    }

    public static boolean getSide() {
        return playerSide;
    }

    private static boolean checkIfEnded() {
        return UnitCreation.getUnits().isEmpty() || Bot.getUnits().isEmpty();
    }

    private static void showEndMenu() {
        Menu.clearConsole();

        if (UnitCreation.getUnits().isEmpty()) {
            System.out.println("ВЫ ПРОГРАЛИ");
        } else if (Bot.getUnits().isEmpty()) {
            System.out.println("ВЫ ВЫИГРАЛИ");
        }
    }
}


