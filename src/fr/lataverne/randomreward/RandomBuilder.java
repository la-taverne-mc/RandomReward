package fr.lataverne.randomreward;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RandomBuilder {

    private final ArrayList<Reward> rewards = new ArrayList<>();
    private final HashMap<Integer,Reward> rewardHashMap = new HashMap<>();
    private int indexMax = 0;

    public RandomBuilder() {
        try {
            File myObj = new File("src\\fr\\lataverne\\randomreward\\filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                String[] words = data.split(" ");
                if(!Objects.equals(words[0], "#"))
                    this.rewards.add(new Reward(words[0],words[1],words[2]));
            }
            myReader.close();
            this.initialiseIndexs();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private void initialiseIndexs() {
        int	indexTotal = 0;
        for (Reward reward : this.rewards){
            indexTotal += (int) (reward.getChance()*100);
            rewardHashMap.put(indexTotal,reward);
        }
        this.indexMax = indexTotal;
    }

    public static void main(String[] args){
        RandomBuilder randomBuilder= new RandomBuilder();
        randomBuilder.printRewards();

        HashMap<String, Integer> stat = new HashMap<>();
        for(int i = 0; i<500 ; i++) {
            Reward reward = randomBuilder.getRandomReward();
            if(reward == null)
                System.out.println("on est naze patron");
            else
                if(!stat.containsKey(reward.getName()))
                    stat.put(reward.getName(),1);
                else
                    stat.put(reward.getName(),stat.get(reward.getName())+1);
        }

        System.out.println(stat);
    }

    public void printRewards(){
        for (Integer index : rewardHashMap.keySet()){
            System.out.print("index:"+index+" ");
            rewardHashMap.get(index).print();
        }
    }

     /**
     * Retourne
     * @return
     */
    public Reward getRandomReward(){
        int indexRandom = (int) Math.floor(Math.random() * indexMax);
        System.out.println("indexRandom:" + indexRandom);
        return get(indexRandom);
    }

    private Reward get(int indexRandom) {
        Object[] keys = this.rewardHashMap.keySet().toArray();
        Arrays.sort(keys);

        int lastIndex = -1;
        for(Object index : keys){
            System.out.println("indexx:" + index);
            if(indexRandom <= (int) index && lastIndex == -1) {
                lastIndex = (int) index;
            }
        }

        return rewardHashMap.get(lastIndex);
    }
}

