import java.util.Scanner;

public class App {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Estacionamento estacionamento = new Estacionamento("EstacionamentoG2", 20, 9);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Veículo a um Cliente");
            System.out.println("3. Estacionar Veículo");
            System.out.println("4. Sair do Estacionamento");
            System.out.println("5. Total Arrecadado");
            System.out.println("6. Arrecadação no Mês");
            System.out.println("7. Valor Médio por Uso");
            System.out.println("8. Top 5 Clientes");
            System.out.println("9. Sair do Programa");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar a nova linha

            switch (opcao) {
                case 1:
                    // Adicionar um cliente
                    estacionamento.addCliente(null);
                    break;
                case 2:
                    // Adicionar veículo a um cliente
                    Cliente cliente = new Cliente(null);
                    cliente.addVeiculo(null);
                    break;
                case 3:
                    // Estacionar veículo
                    Veiculo veiculo = new Veiculo(null);
                    veiculo.estacionar(null);
                    break;
                case 4:
                    Veiculo veiculo2 = new Veiculo(null);
                    veiculo2.sair();
                    // Sair do estacionamento
                    break;
                case 5:
                    Cliente cliente2 = new Cliente(null);
                    cliente2.arrecadadoTotal();

                    break;
                case 6:
                    // Arrecadação no mês
                    
                    Cliente cliente3 = new Cliente(null);
                    System.out.println("Digite o número do mês: ");
                    int mes = scanner.nextInt();                   
                    cliente3.arrecadadoNoMes(mes);
                    break;
                case 7:
                    estacionamento.valorMedioPorUso();
                    break;
                case 8:
                    // Top 5 Clientes
                     System.out.println("Digite o número do mês: ");
                    int mes2 = scanner.nextInt();   
                    estacionamento.top5Clientes(mes2);
                    break;
                case 9:
                    // Sair do programa
                    System.out.println("Saindo do programa.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}