package Paid_Lessons.Homework.Module_2;

public abstract class Player {
    protected String name;
    protected VARIANTS choice;

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
        return null;
    }

}
