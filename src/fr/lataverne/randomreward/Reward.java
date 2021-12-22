package fr.lataverne.randomreward;

public class Reward {
    String nomItem;
    int count;
    double chance;
    int index;
    boolean isCustomItem = false;

    public Reward(String word, String word1, String word2) {
        this.nomItem = word;
        System.out.println(word1);
        this.count = Integer.parseInt(word1);
        this.chance = Double.parseDouble(word2);
        isCustomItem = isCustomItem(word);
    }

    private boolean isCustomItem(String word) {
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
    }


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
