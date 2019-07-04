package modulos;

public abstract class ContaUrbanBike {
    private double saldo;
    private Integer numeroDaConta;



    public ContaUrbanBike(Integer numeroDaConta, double saldo){
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
    }
    protected ContaUrbanBike(){

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
