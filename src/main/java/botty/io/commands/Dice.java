package botty.io.commands;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    public static String roll(String[] dices) {
        StringBuilder output = null;
        int addedAmount = 0;
        int diceSize = 0;

        try {
            int amountOfDice = Integer.parseInt(dices[1]);

            if (dices[2].contains("+")) {
                String[] diceModifier = removeDFromString(dices[2]).split("\\+", 2);
                if (diceModifier.length == 2) {
                    addedAmount = Integer.parseInt(diceModifier[1]);
                    diceSize = Integer.parseInt((diceModifier[0]));
                }
            } else {
                diceSize = Integer.parseInt(removeDFromString(dices[1]));
            }

            if (amountOfDice > 50) {
                return "Too much dice for me, maybe you meant: '!roll" + diceSize + " " + amountOfDice + " **Botty.io**";
            }

            output = new StringBuilder("You have rolled: " + amountOfDice + " dice(s) of size: D" + diceSize + " boundary:" + (1 + addedAmount) + "-" + (diceSize + addedAmount) + "\n");
            for (int i = 1; i < amountOfDice; i++) {
                int randomNum = ThreadLocalRandom.current().nextInt((1 + addedAmount), (diceSize + addedAmount + 1));
                output.append("**D").append(randomNum).append("** ");
            }

        } catch (NumberFormatException ex) {
            output = new StringBuilder("This is not a number, make roll dice god happy by inputting a number!");
        }

        return output.toString();
    }

    public static String oneDice(String[] dices) {
        String output = null;
        int addedAmount = 0;
        int diceSize = 0;

        try {

            if (dices[1].contains("+")) {
                String[] diceModifier = removeDFromString(dices[1]).split("\\+", 2);
                if (diceModifier.length == 2) {
                    addedAmount = Integer.parseInt(diceModifier[1]);
                    diceSize = Integer.parseInt((diceModifier[0]));
                }
            } else {
                diceSize = Integer.parseInt(removeDFromString(dices[1]));
            }

            int randomNum = ThreadLocalRandom.current().nextInt((1 + addedAmount), (diceSize + addedAmount + 1));
            output = "You have rolled one: D" + diceSize + " boundary:" + (1 + addedAmount) + "-" + (diceSize + addedAmount) +
                    "\n **D" + randomNum + "**";
        } catch (NumberFormatException ex) {
            output = "This is not a number, make roll dice god happy by inputting a number!";
        }
        return output;
    }

    public static String removeDFromString(String input) {
        return input.toLowerCase().replaceAll("d", "");
    }
}
