package modulos;

import java.util.List;
import java.util.Optional;

public class Ciclistas {

    private List<ContaUrbanBike> pedais;

    public void inserir(final ContaUrbanBike bike){
        pedais.add(bike);
    }

    public boolean remover(final ContaUrbanBike bike){
        return pedais.remove(bike);
    }

    public boolean remover(final int numeroDaConta){
        return pedais.removeIf(p -> p.getNumeroDaConta() == numeroDaConta);
    }
    public Optional<ContaUrbanBike> procurarPedal(final int numero) {
        return pedais.stream().filter(p -> p.getNumeroDaConta().equals(numero)).findFirst();
    }
    public boolean pedalar(final ContaUrbanBike conta, double valor){
        if(conta == null)
            return false;

        if(conta instanceof PedalPop){
            final PedalPop pop = (PedalPop) conta;

            if((pop.getSaldo() + pop.getTaxaDeOperacao()) < valor){
                return false;
            } else {
                pop.pedalar(valor);
            }
        } else {
            final PedalPremium premium = (PedalPremium) conta;

            if(premium.getSaldo() < -premium.getLimite()){
                return false;
            }

            premium.pedalar(valor);
        }

        return true;
    }
    @Override
    public String toString() {
        return "Ciclistas{" +
                "pedais=" + pedais +
                '}';
    }
}
