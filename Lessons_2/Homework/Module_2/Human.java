package Lessons_2.Homework.Module_2;

import java.util.Scanner;

public class Human extends Player {
    public Human() {
        this.name = getName();
        this.choice = getChoice();
    }

    private VARIANTS getChoice() {
        Scanner in = new Scanner(System.in);
        System.out.print("Камень, ножницы или бумага?: ");
        String userInput = in.nextLine().toUpperCase();
        if (userInput.equals("КАМЕНЬ") || userInput.equals("ROCK"))
            return VARIANTS.ROCK;
        else if (userInput.equals("НОЖНИЦЫ") || userInput.equals("SCISSORS"))
            return VARIANTS.SCISSORS;
        else if (userInput.equals("БУМАГА") || userInput.equals("PAPER"))
            return VARIANTS.PAPER;
        System.out.println("Некорректный ввод! Попробуйте ещё раз!");
        getChoice();
        return null;
    }
    private String getName() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите ваше имя: ");
        return in.nextLine();
    }
}
