package fr.lataverne.randomreward;

import java.util.ArrayList;
import java.util.Arrays;

public class Reward {
    String plugin ;
    String nomItem;
    int count;
    double chance;
    int index;
    boolean isCustomItem = false;
    ArrayList<String> otherArg = new ArrayList<>();

    public Reward(String[] word) {
        this.plugin = word[0];
        this.nomItem = word[1];
        System.out.println(word[1]);
        this.count = Integer.parseInt(word[2]);
        this.chance = Double.parseDouble(word[3]);
        isCustomItem = (!word[0].toLowerCase().equals("minecraft"));
        otherArg.addAll(Arrays.asList(word).subList(4, word.length));
    }

    /** private boolean isCustomItem(String word) {
        return (word.equalsIgnoreCase("GoblinPickaxe" ) ||
                word.equalsIgnoreCase("GiantBoots"    ) ||
                word.equalsIgnoreCase("UnbreakableHoe") ||
                word.equalsIgnoreCase("RawBear"       ) ||
                word.equalsIgnoreCase("RawHorse"      ) ||
                word.equalsIgnoreCase("CookedBear"    ) ||
                word.equalsIgnoreCase("CookedHorse"   ) ||
                word.equalsIgnoreCase("ULU"           ) ||
                word.equalsIgnoreCase("IndianSpear"   ) ||
                word.equalsIgnoreCase("BaseballBat"   ) ||
                word.equalsIgnoreCase("FlyPotion"     ) ||
                word.equalsIgnoreCase("PhantomPotion" ) ||
                word.equalsIgnoreCase("MiningPotion"  ) ||
                word.equalsIgnoreCase("CreeperPotion" ) ||
                word.equalsIgnoreCase("SwimmingPotion"));
    } **/


    public double getChance() {
        return this.chance;
    }

    public void print() {
        System.out.println(this.nomItem +" "+ this.count +" " + this.chance +"% ");
    }

    public String getName() {
        return this.nomItem;
    }

    public String getString() {
        return (this.nomItem +" "+ this.count +" " + this.chance +"% ");
    }
}
