package botty.io.commands;

import java.util.concurrent.ThreadLocalRandom;

public final class Eightball {

	private final static Integer MIN = 0;
	private final static Integer MAX = 19;

	public static String getString(){
		int randomNum = ThreadLocalRandom.current().nextInt(Eightball.MIN, Eightball.MAX + 1);
		String output = "";
		switch (randomNum){
			case 0:
				output = "It is certain";
				break;
			case 1:
				output = "It is decidedly so";
				break;
			case 2:
				output = "Without a doubt";
				break;
			case 3:
				output = "Yes – definitely";
				break;
			case 4:
				output = "You may rely on it";
				break;
			case 5:
				output = "As I see it, yes";
				break;
			case 6:
				output = "Most likely";
				break;
			case 7:
				output = "Outlook good";
				break;
			case 8:
				output = "Yes";
				break;
			case 9:
				output = "Signs point to yes";
				break;
			case 10:
				output = "Reply hazy, try again";
				break;
			case 11:
				output = "Ask again later";
				break;
			case 12:
				output = "Better not tell you now";
				break;
			case 13:
				output = "Cannot predict now";
				break;
			case 14:
				output = "Concentrate and ask again";
				break;
			case 15:
				output = "Don't count on it";
				break;
			case 16:
				output = "My reply is no";
				break;
			case 17:
				output = "My sources say no";
				break;
			case 18:
				output = "Outlook not so good";
				break;
			case 19:
				output = "Very doubtful";
				break;
		}
		return output;
	}
}
