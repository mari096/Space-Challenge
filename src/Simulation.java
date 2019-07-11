import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public Simulation() {}

    public ArrayList<Item> loadItems(String filename) throws FileNotFoundException{
        File file = new File(filename);
        Scanner sc = new Scanner(file);
        ArrayList<Item> items = new ArrayList<>();
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] oneItem = line.split("=");
            items.add(new Item(oneItem[0],Integer.valueOf(oneItem[1])));
        }
        return items;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> list)
    {
        ArrayList<Rocket> fleet = new ArrayList<>();
        Rocket r = new U1();

        for(Item i:list){
            while(!r.canCarry(i)){
                fleet.add(r);
                r = new U1();
            }
            r.carry(i);
        }
        fleet.add(r);
        return fleet;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> list)
    {
        ArrayList<Rocket> fleet = new ArrayList<>();
        Rocket r = new U2();

        for(Item i:list){
            while(!r.canCarry(i)){
                fleet.add(r);
                r = new U2();
            }
            r.carry(i);
        }
        fleet.add(r);
        return fleet;
    }

    public int runSimulation(ArrayList<Rocket> rockets)
    {
        int num = 0;

        for(Rocket r:rockets){
            while(!r.launch()){
                r.launch();
                num++;
            }
            while(!r.land()){
                r.land();
                num++;
            }
        }
        int budget = rockets.get(0).cost * (rockets.size() + num);
        return budget;
    }
}
