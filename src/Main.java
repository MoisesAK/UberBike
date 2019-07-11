import gerenciadores.Relatorio;
import modulos.Ciclistas;
import modulos.ContaUrbanBike;
import modulos.PedalPop;
import modulos.PedalPremium;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Ciclistas ciclistas = new Ciclistas();

        System.out.println("inicio");

        while (true) {

            showMainMenu();

            final int opcao = SCANNER.nextInt();

            switch (opcao) {
                case 1:
                    ciclistas.inserir(createAccount());
                    break;
                case 2:
                    int accountNumber = getAccountNumber();

                    if (ciclistas.remover(accountNumber)) {
                        System.out.println("Pedal removido com sucesso!");
                        System.out.println();
                    } else {
                        System.out.printf("Pedal não encontrado com o número: %s\n", accountNumber);
                    }
                    break;
                case 3:
                    System.out.println("Gerando relatório: ");
                    new Relatorio(ciclistas).gerarRelatorio();
                    System.out.println("....");
                    break;
                case 4:
                    System.out.println("Digite o número da conta: ");
                    final Optional<ContaUrbanBike> conta = ciclistas.procurarPedal(SCANNER.nextInt());

                    if (!conta.isPresent()) {
                        System.out.println("Conta não encontrada...");
                        continue;
                    }
                    showAccountMenu(ciclistas, conta.get());
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inexistente...");
                    break;
            }
        }


    }

    private static void showMainMenu() {
        System.out.println("Escolha uma opção: ");
        System.out.println();
        System.out.println(
                "1. Criar pedal\n" +
                        "2. Remover Pedal: o usuário informa o número do Pedal. Se existe, então é excluído e uma mensagem de sucesso é informada. Senão, informar mensagem de Pedal inexistente.\n" +
                        "3. Gerar relatório: mostra os dados de todos os Pedals cadastrados no Ciclistas.\n" +
                        "4. Selecionar Pedal: o usuário informa o número do pedal. Se existir, mostra o menu abaixo (A até E). Caso contrário, mostra mensagem de Pedal inexistente.\n" +
                        "5. Finalizar: terminar a aplicação.\n"
        );
    }

    private static void showAccountMenu(final Ciclistas ciclistas, final ContaUrbanBike conta) {
        System.out.println("Escolha uma opção: ");

        System.out.println("1. Creditar: recebe um valor e deposita na carteira.\n" +
                "2. Pedalar: recebe um valor e tenta usar.\n" +
                "3. Transferir: recebe um valor e o número de outro Pedal. Caso exista, transfere o valor de um Pedal para o outra. Senão, informar mensagem de Pedal inexistente.\n" +
                "4. Gerar relatório: mostra os dados do Pedal selecionado.\n" +
                "5. Retornar ao menu anterior: exibe o menu anterior (opções 1 a 2).");

        final int opcao = SCANNER.nextInt();

        while (true){
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor a ser depositado: ");
                    final double valor = SCANNER.nextDouble();
                    conta.creditar(valor);
                    break;
                case 2: {
                    System.out.println("Digite a quantidade a pedalar: ");
                    final double distance = SCANNER.nextDouble();
                    final boolean resultado = ciclistas.pedalar(conta, distance);

                    if (false) {
                        System.out.println("Não foi possível pedalar");
                    } else {
                        System.out.println("Pedalado com sucesso!");
                    }

                    break;
                }
                case 3: {
                    final Optional<ContaUrbanBike> pedal = ciclistas.procurarPedal(getAccountNumber());

                    if (pedal.isEmpty()) {
                        System.out.println("Pedal não encontrado");
                        break;
                    }

                    System.out.println("Digite o valor a transferir: ");

                    final boolean resultado = conta.transferir(pedal.get(),  SCANNER.nextDouble());

                    if(!resultado){
                        System.out.println("Não foi possível transferir");
                        break;
                    }

                    System.out.println("Dinheiro transferido com sucesso!");
                    conta.mostrarDados();

                    break;
                }
                case 4:{
                    conta.mostrarDados();
                    break;
                }
                case 5:
                    return;
                default:
                    System.out.printf("Opção inválida: %s%n", opcao);
                    break;
            }
        }
    }

    private static ContaUrbanBike createAccount() {
        //Para ser Pedal Premium é obrigatório creditar um mínimo de R$100,00 na carteira na criação.
        System.out.println("Digite o número da conta: ");
        final int numeroDaConta = SCANNER.nextInt();

        System.out.println("Escolha o tipo de conta: ");
        System.out.println("1 - Conta Pedal Pop");
        System.out.println("2 - Conta Pedal Premium");

        final int tipo = SCANNER.nextInt();

        if(tipo == 1){
            System.out.println("Digite a taxa de operação: ");

            PedalPop pedal = new PedalPop(SCANNER.nextDouble());

            System.out.println("Digite o saldo inicial da conta: ");

            pedal.setSaldo(SCANNER.nextDouble());
            pedal.setNumeroDaConta(numeroDaConta);

            return pedal;
        } else {
            System.out.println("Digite o limite da conta: ");
            PedalPremium pedal = new PedalPremium(SCANNER.nextDouble());

            System.out.println("Digite o saldo inicial da conta: ");

            pedal.setSaldo(SCANNER.nextDouble());
            pedal.setNumeroDaConta(numeroDaConta);
            return pedal;
        }
    }

    private static int getAccountNumber() {
        System.out.println("Digite o número da conta: ");
        return SCANNER.nextInt();
    }
}
