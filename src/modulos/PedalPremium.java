package modulos;

public class PedalPremium extends ContaUrbanBike{
    private double limite;

    public PedalPremium(double limite){
        this.limite = limite;
    }

    public double getLimite(){
        return limite;
    }

}
