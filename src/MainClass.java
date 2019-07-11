import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainClass {
    public static void main(String args[]) throws FileNotFoundException {
        Simulation sim = new Simulation();
        ArrayList<Item> Phase1 = sim.loadItems("/home/saikat/IdeaProjects/Spaceship/phase1.txt");
        ArrayList<Item> Phase2 = sim.loadItems("/home/saikat/IdeaProjects/Spaceship/phase2.txt");

        ArrayList <Rocket> U1Phase1 = sim.loadU1(Phase1);
        ArrayList <Rocket> U1Phase2 = sim.loadU1(Phase2);

        int budgetU1P1 = sim.runSimulation(U1Phase1);
        int budgetU1P2 = sim.runSimulation(U1Phase2);
        System.out.println("The budget for U1 Phase 1 is " + budgetU1P1 + " millions");
        System.out.println("The budget for U1 Phase 2 is " + budgetU1P2 + " millions");
        System.out.println("Total budget is " + (budgetU1P1+budgetU1P2) + " millions");

        ArrayList <Rocket> U2Phase1 = sim.loadU2(Phase1);
        ArrayList <Rocket> U2Phase2 = sim.loadU2(Phase2);

        int budgetU2P1 = sim.runSimulation(U2Phase1);
        int budgetU2P2 = sim.runSimulation(U2Phase2);
        System.out.println("The budget for U2 Phase 1 is " + budgetU2P1 + " millions");
        System.out.println("The budget for U2 Phase 2 is " + budgetU2P2 + " millions");
        System.out.println("Total budget is " + (budgetU2P1+budgetU2P2) + " millions");
    }
}
