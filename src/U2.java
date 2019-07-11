public class U2 extends Rocket {
    public U2()
    {
        cost = 120;
        weight = 18000;
        maxWeight = 29000;
        launchExplosion = 0.0;
        landingCrash = 0.0;
        currentWeight = weight;
    }

    public boolean launch()
    {
        double randomValue = (int)((Math.random()*100) + 1);
        double crashLaunchProb = 4.0*((this.currentWeight-this.weight)/(this.maxWeight-this.weight));
        return crashLaunchProb<=randomValue;
    }

    public boolean land()
    {
        double randomValue = (int)((Math.random()*100) + 1);
        double crashLandProb = 8.0*((this.currentWeight-this.weight)/(this.maxWeight-this.weight));
        return crashLandProb<=randomValue;
    }
}
