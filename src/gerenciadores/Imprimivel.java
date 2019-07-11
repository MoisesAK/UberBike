package gerenciadores;

public interface Imprimivel {
    default void mostrarDados() {
        System.out.println(this.toString());
}


}
