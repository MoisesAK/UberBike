package modulos;

public class PedalPop  extends ContaUrbanBike{
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
    public double getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    public void setTaxaDeOperacao(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }


}
