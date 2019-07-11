package modulos;

import gerenciadores.Imprimivel;

public class PedalPremium extends ContaUrbanBike implements Imprimivel {
    private double limite;

    public PedalPremium(double limite){
        this.limite = limite;
    }

    public double getLimite(){
        return limite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PedalPremium that = (PedalPremium) o;
        return Double.compare(that.limite, limite) == 0;
    }

    @Override
    public String toString() {
        return "PedalPremium{" +
                "urbanBike=" + super.toString() +
                "limite=" + limite +
                '}';
    }

}
