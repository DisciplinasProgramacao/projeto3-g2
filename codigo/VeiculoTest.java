import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class VeiculoTest {
    private Veiculo veiculo;
    private Vaga vaga;
    
    @Before
    public void setUp() {
        veiculo = new Veiculo("ABC1234");
        vaga = new Vaga(0, 0);
    }

    @Test
    public void testEstacionar() {
        veiculo.estacionar(vaga);
        assertEquals(1, veiculo.totalDeUsos());
    }

    @Test
    public void testSair() {
        veiculo.estacionar(vaga);
        double valorPago = veiculo.sair();
        assertTrue(valorPago >= 0);
    }

    @Test
    public void testTotalArrecadado() {
        veiculo.estacionar(vaga);
        double valorPago = veiculo.sair();
        assertEquals(valorPago, veiculo.totalArrecadado(), 0.001);
    }

    @Test
    public void testArrecadadoNoMes(UsoDeVaga uso[]) {
        veiculo.estacionar(vaga);
        UsoDeVaga uso = UsoDeVaga.uso[0];
        uso.setEntrLocalDateTime()(new Date(0)); // Defina a data de entrada como a data atual
        double valorPago = veiculo.sair();
        int mes = Calendar.getInstance().get(Calendar.MONTH) + 1; // Mês atual
        assertEquals(valorPago, veiculo.arrecadadoNoMes(mes), 0.001);
    }

    @Test
    public void testTotalDeUsos() {
        veiculo.estacionar(vaga);
        assertEquals(1, veiculo.totalDeUsos());
    }
}
