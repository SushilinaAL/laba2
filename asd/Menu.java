
package asd;
import asd.Bot;

import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);

    static int shownBalance = 100;

    public static void clearConsole() {
        for (int i = 1; i <= 30; i++)
            System.out.println("\n");
    }

    public static void initMainMenu() {
        showMainMenu();

        int respond = scanner.nextInt();
        switch (respond) {
            case 1: // start
                Bot.initBot();
                Game.createOptions();
                break;
            case 2: // buy
                clearConsole();
                initUnitMenu();
                break;
            case 3: // return
                clearConsole();
                initReturnMenu();
                break;
            default:
                initMainMenu();
        }
    }

    private static void initUnitMenu() {
        showUnitMenu();
        Purchase.buyUnit(scanner.nextInt());
    }

    private static void initReturnMenu() {
        showUnitMenu();
        Purchase.returnUnit(scanner.nextInt());
    }

    private static void showMainMenu() {
        System.out.println("Выберете действие:\n1. Начать игру \n2. Купить юнита \n3. Вернуть юнита\n");
    }

    private static void showUnitMenu() {
        System.out.println("Ваш баланс: " + shownBalance
                + "\nВыберете юнита:\n" +
                "1. Мечник\n" +
                "2. Копьеносец\n" +
                "3. Топорщик\n" +
                "4. Лучник с длинным луком\n" +
                "5. Лучник с коротким луком\n" +
                "6. Арбалетчик\n" +
                "7. Рыцарь\n" +
                "8. Кирасир\n" +
                "9. Конный лучник");
    }
}
