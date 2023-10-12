import java.util.Calendar;
import java.util.Date;

/**
 * A classe Veiculo representa um veículo que pode estacionar em vagas.
 */
public class Veiculo {
    private String placa;
    private UsoDeVaga[] usos;
    private int ultimaPosicao;

    /**
     * Cria uma instância de Veiculo com a placa especificada.
     *
     * @param placa A placa do veículo.
     */
    public Veiculo(String placa) {
        this.placa = placa;
        this.usos = new UsoDeVaga[1000];
        this.ultimaPosicao = 0;
    }

    /**
     * Estaciona o veículo em uma vaga, se a vaga estiver disponível.
     *
     * @param vaga A vaga onde o veículo deve estacionar.
     */
    public void estacionar(Vaga vaga) {
        if (vaga.disponivel()) {
            usos[ultimaPosicao] = new UsoDeVaga(vaga);
            ultimaPosicao++;
        }
    }

    /**
     * Remove o veículo de uma vaga e calcula o valor a ser pago com base no tempo de estacionamento.
     * O valor é calculado em frações de 15 minutos, com um limite de R$50.
     *
     * @return O valor a ser pago pelo estacionamento.
     */
    public double sair() {
        double valorTotal = 0;

        for (int i = 0; i < ultimaPosicao; i++) {
            UsoDeVaga uso = usos[i];
            if (uso != null) {
                return uso.sair();
            }
        }

        return valorTotal;
    }

    /**
     * Calcula o valor total arrecadado com estacionamento deste veículo.
     *
     * @return O valor total arrecadado.
     */
    public double totalArrecadado() {
        double valorTotal = 0;

        for (int i = 0; i < ultimaPosicao; i++) {
            UsoDeVaga uso = usos[i];
            if (uso != null) {
                valorTotal += uso.valorPago();
            }
        }

        return valorTotal;
    }

    /**
     * Calcula o valor arrecadado no mês especificado.
     *
     * @param mes O número do mês (1 a 12) para o qual se deseja calcular o valor arrecadado.
     * @return O valor arrecadado no mês especificado.
     */
    public double arrecadadoNoMes(int mes) {
        double valorTotal = 0;
        Calendar calendar = Calendar.getInstance();

        for (int i = 0; i < ultimaPosicao; i++) {
            UsoDeVaga uso = usos[i];
            if (uso != null && uso.ehDoMes(mes)) {
                  valorTotal += uso.valorPago();

                }
            }
        return valorTotal;
    }

    /**
     * Calcula o total de usos registrados para este veículo.
     *
     * @return O total de usos registrados.
     */
    public int totalDeUsos() {
        int total = 0;

        for (int i = 0; i < ultimaPosicao; i++) {
            if (usos[i] != null) {
                total++;
            }
        }

        return total;
    }
}
