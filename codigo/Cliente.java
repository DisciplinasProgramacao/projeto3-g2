

public class Cliente {

	private String nome;
	private String id;
	private Veiculo[] veiculos;

	public Cliente(String nome, String id) {
		this.nome = nome;
		this.id = id;
	}

	public void addVeiculo(Veiculo veiculo) {
		for (int i = 0; i <= veiculos.length; i++) {
			if (veiculos[i] == null) {
				veiculos[i] = veiculo;
			} 
		}
	}

	public Veiculo possuiVeiculo(String placa) {
		Veiculo veiculo = new Veiculo(placa);

		return veiculo;
	}

	public int totalDeUsos() {
		return veiculos.length;
	}

	public double arrecadadoPorVeiculo(String placa) {
		Veiculo veiculo = new Veiculo(placa);
		double valorArrecadado = veiculo.totalArrecadado();

		return valorArrecadado;
	}

	public double arrecadadoTotal() {
		double total = 0;

		for (int i = 0; i <= veiculos.length; i++) {
			total += veiculos[i].totalArrecadado();
		}

		return total;
	}

	public double arrecadadoNoMes(int mes) {
		double totalMes = 0;

		for (int i = 0; i <= veiculos.length; i++) {
			totalMes += veiculos[i].arrecadadoNoMes(mes);
		}

		return totalMes;
	}

}
