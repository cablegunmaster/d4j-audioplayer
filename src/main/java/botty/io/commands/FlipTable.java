package botty.io.commands;

import java.util.concurrent.ThreadLocalRandom;

public final class FlipTable {

	private final static Integer MIN = 0;
	private final static Integer MAX = 9;

	public static String getString() {
		int randomEmoticon = ThreadLocalRandom.current().nextInt(FlipTable.MIN, FlipTable.MAX + 1);
		int randomText = ThreadLocalRandom.current().nextInt(FlipTable.MIN, FlipTable.MAX + 1);
		String emoticon = "";
		String text = "";

		switch (randomEmoticon) {
			case 1:
				emoticon = "┣ﾍ(^▽^ﾍ)Ξ(ﾟ▽ﾟ*)ﾉ┳━┳ ";
				break;
			case 2:
				emoticon = "┬──┬ ノ( ゜-゜ノ)";
				break;
			case 3:
				emoticon = "┬──┬﻿ ¯(ツ)";
				break;
			case 4:
				emoticon = "(ヘ･･)ヘ┳━┳";
				break;
			case 5:
				emoticon = "ヘ(´° □°)ヘ┳━┳";
				break;
			case 6:
				emoticon = "┣ﾍ(≧∇≦ﾍ)… (≧∇≦)/┳━┳";
				break;
		}

		switch (randomText) {
			case 1:
				text = "There we go~♪";
				break;
			case 2:
				text = " I put it back for you, don't touch it again!";
				break;
			case 3:
				text = "Ah a fresh new table! From Ikea! yes, clean.";
				break;
			case 4:
				text = "That table ! I put it back for you.";
				break;
			case 5:
				text = "DONT TOUCH MAH TABLE!";
				break;
			case 6:
				text = "Table table, I fix it for you, I got nothing else to do anyway.";
				break;
			case 7:
				text = "OH MAH GOD . MAH TABLE.. now im sad :(";
				break;
			case 8:
				text = "Really, you just did that?";
				break;
			case 9:
				text= "I put that table back, now don't touch it again , okay?";
				break;
		}

		return emoticon + " " + text;
	}
}
