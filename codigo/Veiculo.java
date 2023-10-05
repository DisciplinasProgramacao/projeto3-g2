/**
 * A classe Veiculo representa um veículo que pode estacionar em vagas.
 */
public class Veiculo {

    private String placa;
    private UsoDeVaga[] usos;
    private int ultimaPosicao;

    /**
     * Construtor da classe Veiculo.
     *
     * @param placa A placa do veículo.
     */
    public Veiculo(String placa) {
        this.placa = placa;
        this.usos = new UsoDeVaga[1000]; // Inicializa o array de usos com tamanho máximo de 1000.
        this.ultimaPosicao = 0; // Inicializa a última posição de uso como 0.
    }

    /**
     * Estaciona o veículo em uma vaga se a vaga estiver disponível.
     *
     * @param vaga A vaga em que o veículo deseja estacionar.
     */
    public void estacionar(Vaga vaga) {
       if(vaga.disponivel() == true ){
			this.usos = new UsoDeVaga[1000];
			this.usos = new UsoDeVaga[ultimaPosicao];
			ultimaPosicao++;
		} 
		 else {
            System.out.println("A vaga não está disponível.");
        }
    }

    /**
     * Registra a saída do veículo da vaga e calcula o valor a ser pago.
     *
     * @return O valor a ser pago pelo uso da vaga.
     */
    public double sair() {
        double total = 0.0;
        for (int i = 0; i < ultimaPosicao; i++) {
            total += usos[i].calcularValor();
            usos[i] = null; // Limpa a referência ao uso da vaga.
        }
        ultimaPosicao = 0; // Reseta a última posição de uso.
        return total;
    }

    /**
     * Calcula o total arrecadado pelo veículo desde o início.
     *
     * @return O total arrecadado.
     */
    public double totalArrecadado() {
        double total = 0.0;
        for (int i = 0; i < ultimaPosicao; i++) {
            total += usos[i].calcularValor();
        }
        return total;
    }

    /**
     * Calcula o total arrecadado pelo veículo em um determinado mês.
     *
     * @param mes O mês desejado (1 a 12).
     * @return O total arrecadado no mês especificado.
     */
    public double arrecadadoNoMes(int mes) {
        double total = 0.0;
        for (int i = 0; i < ultimaPosicao; i++) {
            if (usos[i].getMes() == mes) {
                total += usos[i].calcularValor();
            }
        }
        return total;
    }

    /**
     * Obtém o total de usos registrados pelo veículo.
     *
     * @return O total de usos.
     */
    public int totalDeUsos() {
        return ultimaPosicao;
    }
	
}
