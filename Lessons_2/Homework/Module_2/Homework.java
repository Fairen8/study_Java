package Lessons_2.Homework.Module_2;

public class Homework {
    public static void main(String[] args) {
        Bot bot = new Bot();
        Human alex = new Human();
        System.out.println(bot.whoWins(bot, alex));
    }
}
