package Lessons_2.Homework.Module_2;

public abstract class Player {
    protected String name;
    protected VARIANTS choice;

    public String whoWins(Player firstPlayer,Player secondPlayer) {
        if (firstPlayer.choice == secondPlayer.choice)
            return "Ничья";
        switch (firstPlayer.choice) {
            case ROCK:
                return (secondPlayer.choice == VARIANTS.SCISSORS ? win(firstPlayer.name) : win(secondPlayer.name));
            case PAPER:
                return (secondPlayer.choice == VARIANTS.ROCK ? win(firstPlayer.name) : win(secondPlayer.name));
            case SCISSORS:
                return (secondPlayer.choice == VARIANTS.PAPER ? win(firstPlayer.name) : win(secondPlayer.name));
        }
        return null;
    }
    private String win(String Player) {
        return "Победил игрок с именем: " + Player;
    }

}
