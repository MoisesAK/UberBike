package modulos;

import gerenciadores.Imprimivel;

public class PedalPop  extends ContaUrbanBike implements Imprimivel {
    private double taxaDeOperacao;

    public PedalPop (double taxaDeOperacao){
        this.taxaDeOperacao = taxaDeOperacao;

    }

    @Override
    public void pedalar(double valor) {
        super.pedalar(valor);

        this.pedalar(taxaDeOperacao);
    }

    @Override
    public void creditar(double valor) {
        super.creditar(valor);

        this.creditar(taxaDeOperacao);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PedalPop pedalPop = (PedalPop) o;
        return Double.compare(pedalPop.taxaDeOperacao, taxaDeOperacao) == 0;
    }


    public double getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    public void setTaxaDeOperacao(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }


}
