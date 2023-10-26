import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crie um estacionamento
        Estacionamento estacionamento = new Estacionamento("Meu Estacionamento", 5, 10);

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
                    System.out.print("Nome do cliente: ");
                    String nomeCliente = scanner.nextLine();
                    System.out.print("ID do cliente: ");
                    String idCliente = scanner.nextLine();
                    Cliente cliente = new Cliente(nomeCliente, idCliente);
                    estacionamento.addCliente(cliente);
                    break;
                case 2:
                    // Adicionar veículo a um cliente
                    System.out.print("ID do cliente: ");
                    String idClienteAddVeiculo = scanner.nextLine();
                    Cliente clienteAddVeiculo = estacionamento.getClienteById(idClienteAddVeiculo);

                    if (clienteAddVeiculo != null) {
                        System.out.print("Placa do veículo: ");
                        String placaVeiculo = scanner.nextLine();
                        Veiculo veiculo = new Veiculo(placaVeiculo);
                        clienteAddVeiculo.addVeiculo(veiculo);
                        System.out.println("Veículo adicionado ao cliente com sucesso.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;
                case 3:
                    // Estacionar veículo
                    System.out.print("Placa do veículo: ");
                    String placaEstacionar = scanner.nextLine();
                    Veiculo veiculoEstacionar = estacionamento.estacionar(veiculoEstacionar);;

                    if (veiculoEstacionar != null) {
                        Vaga vagaDisponivel = estacionamento.estacionar(veiculoEstacionar);
                        if (vagaDisponivel != null) {
                            System.out.println("Veículo estacionado na vaga: " + vagaDisponivel.getId());
                        } else {
                            System.out.println("Não há vagas disponíveis.");
                        }
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 4:
                    // Sair do estacionamento
                    System.out.print("Placa do veículo: ");
                    String placaSair = scanner.nextLine();
                    Veiculo veiculoSair = estacionamento.getVeiculoByPlaca(placaSair);

                    if (veiculoSair != null) {
                        double valorPago = estacionamento.sair(veiculoSair);
                        System.out.println("Valor a ser pago: R$" + valorPago);
                    } else {
                        System.out.println("Veículo não encontrado.");
                    }
                    break;
                case 5:
                    // Total arrecadado
                    double totalArrecadado = estacionamento.totalArrecadado();
                    System.out.println("Total arrecadado: R$" + totalArrecadado);
                    break;
                case 6:
                    // Arrecadação no mês
                    System.out.print("Mês (1-12): ");
                    int mes = scanner.nextInt();
                    double arrecadacaoNoMes = estacionamento.arrecadacaoNoMes(mes);
                    System.out.println("Arrecadação no mês " + mes + ": R$" + arrecadacaoNoMes);
                    break;
                case 7:
                    // Valor médio por uso
                    double valorMedioPorUso = estacionamento.valorMedioPorUso();
                    System.out.println("Valor médio por uso: R$" + valorMedioPorUso);
                    break;
                case 8:
                    // Top 5 Clientes
                    System.out.print("Mês (1-12): ");
                    int mesTop5 = scanner.nextInt();
                    String top5Clientes = estacionamento.top5Clientes(mesTop5);
                    System.out.println("Top 5 Clientes no mês " + mesTop5 + ":\n" + top5Clientes);
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