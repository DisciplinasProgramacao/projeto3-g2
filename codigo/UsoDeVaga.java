import java.time.LocalDateTime;
import java.util.ArrayList;

public class UsoDeVaga {

	private static final double FRACAO_USO = 0.25;
	private static final double VALOR_FRACAO = 4.0;
	private static final double VALOR_MAXIMO = 50.0;
	private Vaga vaga;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private double valorPago;
	private Cliente cliente;

	public Vaga UsoDeVaga(Vaga vaga, Cliente cliente, LocalDateTime entrada) {
		int fila;
		int numero;
		String nome;
		String id;
		this.vaga = vaga;
		this.cliente = cliente;
		this.entrada = entrada;
		return vaga;
	}

	public double sair(LocalDateTime saida) {
		if (saida.isAfter(entrada)) {
			this.saida = saida;
			valorPago();
		} else {
			System.out.println("Data invalida.");
		}
		return valorPago;
	}

	public boolean ehDoMes(int mes) {
		// a ser desenvolvido
		return false;

	}

	public double valorPago() {
		// a ser desenvolvido
		return valorPago;

	}

}
