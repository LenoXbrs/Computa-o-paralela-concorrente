package av3questao2;

public class Compra {
    private String[] produtos;
    private double[] quantidades;

    public Compra(String[] produtos, double[] quantidades) {
        this.produtos = produtos;
        this.quantidades = quantidades;
    }

	public String[] getProdutos() {
		return produtos;
	}

	public void setProdutos(String[] produtos) {
		this.produtos = produtos;
	}

	public double[] getQuantidades() {
		return quantidades;
	}

	public void setQuantidades(double[] quantidades) {
		this.quantidades = quantidades;
	}


}
