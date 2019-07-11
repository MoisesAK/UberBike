package modulos;

import gerenciadores.Imprimivel;

public abstract class ContaUrbanBike implements Imprimivel {
    private double saldo;
    private Integer numeroDaConta;



    public ContaUrbanBike(Integer numeroDaConta, double saldo){
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
    }
    protected ContaUrbanBike(){

    }
    public boolean transferir( ContaUrbanBike urbanBike,Double valor ){

        if(this.saldo < valor){
            return false;
        }

        this.pedalar(valor);
        urbanBike.creditar(valor);


        return true;
    }

    @Override
    public String toString() {
        return "UrbanBike{" +
                "accountNumber='" + numeroDaConta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
    public void pedalar (double valor){
        this.saldo -= valor;
    }
    public void creditar (double valor){
        this.saldo += valor;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Integer getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(Integer numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

}
