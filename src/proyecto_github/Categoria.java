package proyecto_github;

public enum Categoria {
	TRES(3),DOCE(12),DIECISEIS(16),DIECIOCHO(18);

    private final int valor;

    private Categoria(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
