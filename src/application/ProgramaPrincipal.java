package application;

import entities.Funcionario;

import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos funcionários deseja cadastrar? 📝 ");
        int n = sc.nextInt();

        Funcionario[] funcionarios = new Funcionario[n];
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println("\nFuncionário #" + (i + 1) + " 👤");
            System.out.println("----------------------------");

            int id;
            while (true) {
                System.out.print("Id: 🔢 ");
                id = sc.nextInt();
                sc.nextLine();

                boolean idExiste = false;
                for (int j = 0; j < i; j++) {
                    if (funcionarios[j].getId() == id) {
                        idExiste = true;
                        break;
                    }
                }

                if (idExiste) {
                    System.out.println("⚠️ Esse ID já existe! Digite outro.");
                } else {
                    break;
                }
            }

            System.out.print("Nome: 📝 ");
            String nome = sc.nextLine();

            System.out.print("Salário: 💰 ");
            double salario = sc.nextDouble();

            funcionarios[i] = new Funcionario(id, nome, salario);

        }

        System.out.print("\nDigite o ID do funcionário que irá receber o aumento: 🔍 ");
        int idBusca = sc.nextInt();

        Funcionario funcionarioEncontrado = null;
        for (int j = 0; j < funcionarios.length; j++) {
            if (funcionarios[j].getId() == idBusca) {
                funcionarioEncontrado = funcionarios[j];
                break;
            }
        }

        if (funcionarioEncontrado != null) {
            System.out.print("Digite a porcentagem do aumento: 📈 ");
            double porcentagem = sc.nextDouble();
            funcionarioEncontrado.aumentarSalario(porcentagem);
            System.out.println("✅ Aumento aplicado com sucesso!");
            System.out.println("------------------------------------");
        } else {
            System.out.println("❌ ID não encontrado, programa abortado.");
        }

        System.out.println("\nLista atualizada de funcionários: 📋");
        for (int i = 0; i < funcionarios.length; i++) {
            System.out.println("ID: " + funcionarios[i].getId() + " 🔢");
            System.out.println("Nome: " + funcionarios[i].getNome() + " 📝");
            System.out.printf("Salário: $ %.2f 💰%n", funcionarios[i].getSalario());
            System.out.println("---------------------------");
        }

        sc.close();
    }
}
