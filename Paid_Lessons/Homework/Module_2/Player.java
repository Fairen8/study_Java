package Paid_Lessons.Homework.Module_2;

import java.util.Random;

public class Player {
    private String name = "Bot";
    private VARIANTS choice;

    public Player(VARIANTS choice, String name) {
        this.choice = choice;
        this.name = name;
    }

    public Player() {
        Random r = new Random();
        int x = r.nextInt(3);
        switch (x) {
            case 0:
                this.choice = VARIANTS.ROCK;
                break;
            case 1:
                this.choice = VARIANTS.SCISSORS;
                break;
            case 2:
                this.choice = VARIANTS.PAPER;
        }
    }
    public String whoWins(Player firstPlayer,Player secondPlayer) {
        if (firstPlayer.choice == secondPlayer.choice)
            return "Ничья";
        switch (firstPlayer.choice) {
            case ROCK:
                return (secondPlayer.choice == VARIANTS.SCISSORS ? firstPlayer.name : secondPlayer.name);
            case PAPER:
                return (secondPlayer.choice == VARIANTS.ROCK ? firstPlayer.name : secondPlayer.name);
            case SCISSORS:
                return (secondPlayer.choice == VARIANTS.PAPER ? firstPlayer.name : secondPlayer.name);
        }
        return null; //Бесполезная строка, но без неё выдаётся ошибка
    }
}
