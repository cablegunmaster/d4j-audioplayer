package botty.io.commands;

import java.util.concurrent.ThreadLocalRandom;

public final class RandomQuotes {

    private final static Integer MIN = 0;
    private final static Integer MAX = 77;

    public static String getString() {
        int randomNum = ThreadLocalRandom.current().nextInt(RandomQuotes.MIN, RandomQuotes.MAX + 1);
        String output = "";
        switch (randomNum) {
            case 0:
                output = "I have been afflicted by the art history curse.\n" +
                        "[…] AAAARGH! I don’t even like art!”\n" +
                        "— **The party rogue**";
                break;
            case 1:
                output = "Are you trying to apply Morse code through the cat?";
                break;
            case 2:
                output = "The door does not get a turn";
                break;
            case 3:
                output = "“Turns out the fog machine was just hung over”\n" +
                        "— **a party member, on cauldrons**";
                break;
            case 4:
                output = "“I add my frozen right foot to my inventory”\n" +
                        "— **Our tiefling warlock**";
                break;
            case 5:
                output = "“Arson is a **SOMETIMES** crime.”";
                break;
            case 6:
                output = "“You know, an Orc You Wanna Pork!”\n" +
                        "\n" +
                        "-Describing theoretical attractive orcs";
                break;
            case 7:
                output = "“So long story short, our monk has become an expert at drawing butts.”";
                break;
            case 8:
                output = "“It’s easy to lose a gnome in a mud river.”";
                break;
            case 9:
                output = "“You literally tackle him out of his pants.”\n" +
                        "— **The DM as out half-orc bowls over a stripping dullahan**";
                break;
            case 10:
                output = "“I’m a fighter! I care not for literature!”\n" +
                        "— **the fighter**";
                break;
            case 11:
                output = "“Y'know, horses! With their spider legs!”\n" +
                        "— **the DM**";
                break;
            case 12:
                output = "“Don’t ever lie. If you lie again, they’ll make you play sports.”";
                break;
            case 13:
                output = "“WATER IN THE FOUNTAIN IS TURNING THE FRIGGIN FROGS SACRELIGIOUS”";
                break;
            case 14:
                output = "“You see the dragon in its shapeshifted elf form. She DOES have nipples, you know it in-character now, this matter is now CLOSED!”\n" +
                        "— **Dirty dungeoneering bastards**";
                break;
            case 15:
                output = "“I pull out my crossbow.”\n" +
                        "\n" +
                        "“I pull out my crossbow!”\n" +
                        "\n" +
                        "“I pull out MY crossbow!”\n" +
                        "\n" +
                        "“I pull out /MY/ crossbow!!”\n" +
                        "\n" +
                        "“I pull out //MY// crossbow!!!”\n" +
                        "\n" +
                        "DM:“DO YOU ALL HAVE CROSSBOWS?!”";
                break;
            case 16:
                output = "“Better that he’s naked and subdued than fully clothed and free.”";
                break;
            case 17:
                output = "*casts Zone of Truth to a turtle in a hat* “Are you stupid, or what?”";
                break;
            case 18:
                output = "That’s technically true, but, considering there’s an eldritch abomination in there, \n" +
                        "I’d rather just use the actual library when possible.";
                break;
            case 19:
                output = "“That completely negates the purpose of me sacrificing myself! You didn’t even know I was still alive!”\n" +
                        "\n" +
                        "-**Me (elven mage), telling off our bard for jumping into a time portal.**";
                break;
            case 20:
                output = "“Is there any spell better than fireball?”\n" +
                        "“Yes, a really good book”";
                break;
            case 21:
                output = "“Do human-sized jars exist? Oh wait, barrels.”\n" +
                        "— **The Druid**";
                break;
            case 22:
                output = "“They’ll add more flavor to the party!”\n" +
                        "“Our party is a potluck from hell!! We don’t NEED any more flavor!!!!”";
                break;
            case 23:
                output = "“We forgot to invite God!”\n" +
                        "—**Session planning**";
                break;
            case 24:
                output = "Rogue: I set the horses on fire and send them out into the town!\n" +
                        "Cleric: Are horses naturally flammable?\n" +
                        "R: Oiled horses are.";
                break;
            case 25:
                output = "I’m sorry! I thought it was a weirdly sexual elf sport!";
                break;
            case 26:
                output = "Warlock: If there’s a rabbit in the trap when I go check it, I think I may let it go.\n" +
                        "Paladin: No! Why not kill it for breakfast tomorrow?\n" +
                        "Warlock: I’m sad.\n" +
                        "\n";
                break;
            case 27:
                output = "If the DM doesn't show up in 15 minutes we're legally allowed to level ourselves up.";
                break;
            case 28:
                output = "I do clerical work. \n" +
                        "—**our cleric**";
                break;
            case 29:
                output = "“If everyone’s uncomfortable with the whole ‘beheading’ " +
                        "thing we could always just take his whole body, but that’s so HEAVY”\n" +
                        "— **Our “lawful good” Paladin**";
                break;
            case 30:
                output = "“I rolled a 14 to dodge the night.”";
                break;
            case 31:
                output = "I put on my robe and wizard hat \n" +
                        "—**Botty.io**";
                break;
            case 32:
                output = "“Those potions cost two kids worth of gold?!!”";
                break;
            case 33:
                output = "“Yeah but demons can’t lie.” \n" +
                        "“Of course they can.”\n" +
                        "“What? That demon lied to me!”";
                break;
            case 34:
                output = "“What kind of weird things are you into?”\n" +
                        "— **An NPC out of context that wasn’t supposed to be dirty \n" +
                        "but the PCs made it dirty**\n";
                break;
            case 35:
                output = "Can George….eat the goblin?";
                break;
            case 36:
                output = "The demon made me an offer I couldn’t refuse: money and power. ";
                break;
            case 37:
                output = "Always listen to your GM!! -- Botty.io";
                break;
            case 38:
                output = "“I know you’re all individuals, but stop acting like it!”\n" +
                        "— **The GM**";
                break;
            case 39:
                output = "“Are my demon powers DLC?”";
                break;
            case 40:
                output = "Hold on, I killed the wrong horse.\n" +
                        "\n" +
                        "-**Our DM**";
                break;
            case 41:
                output = "“I stuff the dragon in my bra.”";
                break;
            case 42:
                output = "42 the answer to life and everything";
                break;
            case 43:
                output = "“Shouldn’t the plant roll a reflex save?”\n" +
                        "\n" +
                        "“It’s a plant.”\n" +
                        "\n" +
                        "“Yeah, but it should get a reflex save, though.”";
                break;
            case 44:
                output = "“I am going to RESPECTFULLY knock on the casket.”\n" +
                        "— **Our Monk**";
                break;
            case 45:
                output = "“Please don’t get the warlock high.”\n" +
                        "— After offering catnip to my Catfolk Warlock in the future.\n";
                break;
            case 46:
                output = "*Orc mage throws a chair at enemy*\n" +
                        "“What did you do that for?!”\n" +
                        "“I’m out of spells!”";
                break;
            case 47:
                output = "“for valiantly withstanding your assault, the wall gains 800 xp. \n" +
                        "the wall levels up, and multiclasses into a door.”\n" +
                        "— **the dm, winging it**";
                break;
            case 48:
                output = "“Hey kid, I’ll show you my eyesocket for two gold.”\n" +
                        "— **our one-eyed, half-giant fighter**";
                break;
            case 49:
                output = "“You don’t need to involve bagel merchant in your harebrained schemes.”\n" +
                        "—** The Gm who’s sick of the players shenanigans**";
                break;
            case 50:
                output = "“We almost killed a bunch of people over a dildo.”";
                break;
            case 51:
                output = "““YOU’VE JUST BROUGHT A CROSSBOW TO A CHAIR FIGHT!”\n" +
                        "-**The Bard**”";
                break;
            case 52:
                output = "“I only have one boyfriend and it’s the lord. The lord’s a jealous lover.”";
                break;
            case 53:
                output = "“What can I say, I like flesh.”\n" +
                        "—** DM**";
                break;
            case 54:
                output = "“NO MORE BEES! NO MORE BEES! NO MORE BEES!”\n" +
                        "— Literally Everyone\n";
                break;
            case 55:
                output = "“I don’t think summoning a tiger in something’s throat counts as pacifism.\" ";
                break;
            case 56:
                output = "THINKING IS FOR PEOPLE, who aren't getting shot at! \n" +
                        "—**Barbarian**";
                break;
            case 57:
                output = "I used to be adventurer like you, but then I took a arrow to the knee \n" +
                        "—**Random guard**";
                break;
            case 58:
                output = "“I just feel like, if we see anything nice, we should leave.”\n" +
                        "—**Our Cleric**";
                break;
            case 59:
                output = "“Good job. You’ve lubed the goblin.”";
                break;
            case 60:
                output = "if you’re not wearing heavy armour you can make bad decisions faster";
                break;
            case 61:
                output ="“If they wanted us to go in the front door then they would have locked it!”";
                break;
            case 62:
                output ="As DM, can I reject these laws of physics?";
                break;
            case 63:
                output ="Cleric: Who are you?\n" +
                        "\n" +
                        "NPC: I’m this town’s most prestigious banker.\n" +
                        "\n" +
                        "Cleric: Ah, a sinner.";
                break;
            case 64:
                output ="\n" +
                        "Bard: “I never thought I would have to do this again”\n" +
                        "\n" +
                        "Rogue: “Again?”\n" +
                        "\n" +
                        "Bard: “I was a noble after all.”\n" +
                        "\n" +
                        "— **While disposing a body**\n";
                break;
            case 65:
                output = "“I steal the Gnome Bobblehead.”\n" +
                        "“Alarms sound immediately. Roll for initiative.”";
                break;
            case 66:
                output = "“I’m not going back there! They tried to make my girlfriend a sheep!”";
                break;
            case 67:
                output ="Guys, I’ve decided what we’re fighting for: Fully automated luxury gay space communism. That… is our mission.";
                break;
            case 68:
                output ="“Roll to look uncomfortable”\n" +
                        "— **Our DM to my character**";
                break;
            case 69:
                output ="They made a bad life choice by being worth XP.";
                break;
            case 70:
                output = "Not all evil things are evil! Wait….";
                break;
            case 71:
                output = "His nostrils seem honest";
                break;
            case 72:
                output = "“I’m not Undead, I’m just old!”\n" +
                        "- The Skeleton King";
                break;
            case 73:
                output = "Bard: I take the glove off its paw and I kiss it.\n" +
                        "\n" +
                        "DM: The hand or the glove?\n" +
                        "\n" +
                        "Bard: The bear.";
                break;
            case 74:
                output = "“Is there, like, a thing you can use to, like, get dark vision?”\n" +
                        "\n" +
                        "“Yeah. It’s called a torch.”";
                break;
            case 75:
                output ="DM: Okay, that’s a hit. Where do you swing your flame blade at the ogre? \n" +
                        "Druid: The neck area. \n" +
                        "DM: Any last words before you behead Shrek? \n" +
                        "Druid: **I Am The All Star Now** ";
                break;
            case 76:
                output = "“So, which direction does your pulsing rod guide us towards?”";
                break;
            case 77:
                output = "“So the better we rob him, the legaler it gets?”";
                break;
            default:
                output = "Always listen to your DM!! and tell him he is great he likes that" +
                        "--**DM**";

        }
        return output;
    }
}
