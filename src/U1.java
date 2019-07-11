public class U1 extends Rocket {
    public U1()
    {
        cost = 100;
        weight = 10000;
        maxWeight = 18000;
        launchExplosion = 0.0;
        landingCrash = 0.0;
        currentWeight = weight;
    }

    public boolean launch()
    {
        double randomValue = (int)((Math.random()*100) + 1);
        double crashLaunchProb = 5.0*((this.currentWeight-this.weight)/(this.maxWeight-this.weight));
        return crashLaunchProb<=randomValue;
    }

    public boolean land()
    {
        double randomValue = (int)((Math.random()*100) + 1);
        double crashLandProb = 1.0*((this.currentWeight-this.weight)/(this.maxWeight-this.weight));
        return crashLandProb<=randomValue;
    }
}
