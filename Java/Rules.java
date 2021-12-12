import java.util.Scanner;

public class Rules {
    static void TellRules() {
        System.out.println("\n\nThis is a long set of rules!");
        System.out.println("1. Each player begins with one finger raised on each hand. After the first player turns proceed clockwise.");
        System.out.println("2. On a player's turn, they must either attack, split or swap, but only one per turn.");
        System.out.println("3. To attack, a player uses one of their live hands to strike an opponent's live hand. The number of fingers on the opponent's struck hand will increase by the number of fingers on the hand used to strike.");
        System.out.println("4. To split, a player strikes their own two hands together, and transfers raised fingers from one hand to the other as desired.");
        System.out.println("5. To swap, the player who's turn it is swaps their two hand values, using up their turn.");
        System.out.println("6. A player may revive their own dead hand using a split or swap, as long as they abide by the rules for splitting. However, players may not revive opponents' hands using an attack. Therefore, a player with two dead hands can no longer play and is eliminated from the game.");
        System.out.println("7. If any hand of any player reaches five or more fingers, then it is considered a \"dead hand\".");
        System.out.println("8. A player wins once all opponents are eliminated (by each having two dead hands at once).");
        System.out.println("9. There is no variation in which a player can kill their own hand.");
        System.out.println("Press \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }


}
