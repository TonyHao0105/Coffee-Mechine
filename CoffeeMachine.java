package machine;

import java.util.Objects;
import java.util.Scanner;

class Coffee {

    public enum inputAction {
        buy, fill, take, remaining, exit
    }

    public static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public enum coffeeVariant {
        espresso, latte, cappuccino
    }
}
public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int beans = 120;
        int disposableCups = 9;
        int money = 550;
        Coffee.inputAction status = Coffee.inputAction.valueOf(Coffee.input());
        while (status != Coffee.inputAction.exit) {
            switch (status) {
                case remaining:
                    printState(water, milk, beans, disposableCups, money);
                    break;
                case buy:
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
                    String choice = Coffee.input();
                        switch (choice) {
                            case "1":
                                if (water >= 250 && beans >= 16 && disposableCups >= 1) {
                                    water -= 250;
                                    beans -= 16;
                                    disposableCups -= 1;
                                    money += 4;
                                    System.out.println("I have enough resources, making you a coffee!");
                                } else {
                                    if (water < 250) {
                                        System.out.println("Sorry, not enough water!");
                                    } else if (beans < 16) {
                                        System.out.println("Sorry, not enough coffee beans!");
                                    } else {
                                        System.out.println("Sorry, not enough disposable cups!");
                                    }
                                }
                                break;
                            case "2":
                                if (water >= 350 && milk >= 75 && beans >= 20 && disposableCups >= 1) {
                                    water -= 350;
                                    milk -= 75;
                                    beans -= 20;
                                    disposableCups -= 1;
                                    money += 7;
                                    System.out.println("I have enough resources, making you a coffee!");
                                } else {
                                    if (water < 350) {
                                        System.out.println("Sorry, not enough water!");
                                    } else if (milk < 75) {
                                        System.out.println("Sorry, not enough milk!");
                                    } else if (beans < 20) {
                                        System.out.println("Sorry, not enough coffee beans!");
                                    } else {
                                        System.out.println("Sorry, not enough disposable cups!");
                                    }
                                }
                                break;
                            case "3":
                                if (water >= 200 && milk >= 100 && beans >= 12 && disposableCups >= 1) {
                                    water -= 200;
                                    milk -= 100;
                                    beans -= 12;
                                    disposableCups -= 1;
                                    money += 6;
                                    System.out.println("I have enough resources, making you a coffee!");
                                } else {
                                    if (water < 200) {
                                        System.out.println("Sorry, not enough water!");
                                    } else if (milk < 100) {
                                        System.out.println("Sorry, not enough milk!");
                                    } else if (beans < 12) {
                                        System.out.println("Sorry, not enough coffee beans!");
                                    } else {
                                        System.out.println("Sorry, not enough disposable cups!");
                                    }
                                }
                                break;
                        }
                    break;
                case fill:
                    System.out.println("Write how many ml of water you want to add:");
                    water += Integer.parseInt(Coffee.input());
                    System.out.println("Write how many ml of milk you want to add:");
                    milk += Integer.parseInt(Coffee.input());
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    beans += Integer.parseInt(Coffee.input());
                    System.out.println("Write how many disposable cups of coffee you want to add:");
                    disposableCups += Integer.parseInt(Coffee.input());
                    break;
                case take:
                    System.out.printf("I gave you $%d", money);
                    money = 0;
                    break;
                case exit:
                    break;
            }
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            status = Coffee.inputAction.valueOf(Coffee.input());
        }
    }
    private static void printState(int water, int milk, int beans, int disposableCups, int money) {
        System.out.printf("The coffee machine has:\n%d ml of water\n" +
                "%d ml of milk\n%d g of coffee beans\n" +
                "%d disposable cups\n$%d of money", water, milk, beans, disposableCups, money);
        System.out.println();
    }
}
