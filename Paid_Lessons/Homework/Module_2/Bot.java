package Paid_Lessons.Homework.Module_2;

import java.util.Random;

public class Bot extends Player {
    public Bot() {
        Random r = new Random();
        int x = r.nextInt(3);
        switch (x) {
            case 0:
                super.choice = VARIANTS.ROCK;
                break;
            case 1:
                super.choice = VARIANTS.SCISSORS;
                break;
            case 2:
                super.choice = VARIANTS.PAPER;
        }
        super.name = "Bot";
    }

}
