import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        CDB cd1 = new CDB("sylvo", "150", "itau", 12);
        double rendimentoCDB = cd1.calcularRendimento(1000, 10,10);
        System.out.printf("Montante final do CDB com 1000 reais investidos: R$ %.2f%n", rendimentoCDB);

        LCA lca1 = new LCA("pedro", "151", "bradesco", 10.5);
        double rendimentoLCA = lca1.calcularRendimento(1000, 10,10);
        System.out.printf("Montante final do LCA com 1000 reais investidos: R$ %.2f%n", rendimentoLCA);

        LCI lci1 = new LCI("joao", "152", "nubank", 10);
        double rendimentoLCI = lci1.calcularRendimento(1000, 10,10);
        System.out.printf("Montante final do LCI com 1000 reais investidos: R$ %.2f%n", rendimentoLCI);

        Poupanca p1 = new Poupanca("alfredo","152", "santander", 5);
        double rendimentoPoupanca = p1.calcularRendimento(1000, 10,9);
        System.out.printf("Montante final da poupança com 1000 reais investidos: R$ %.2f%n", rendimentoPoupanca);


        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Informe o banco: ");
        String banco = scanner.nextLine();

        RendaFixa rendaFixa = new RendaFixa(nome, cpf, banco);

        System.out.print("1- Valor Investido (R$): ");
        double valorInvestido = scanner.nextDouble();

        System.out.print("2- Tempo de Investimento (meses): ");
        int tempoMeses = scanner.nextInt();

        System.out.print("3- Taxa SELIC (%): ");
        double taxaSelic = scanner.nextDouble();
        taxaSelic *= taxaSelic/100;

        double resultado = calcularRendimentoSelic(valorInvestido, tempoMeses, taxaSelic);


        System.out.print("Nome do arquivo que deseja salvar:");
        String nomeArquivo = scanner.next();
        nomeArquivo = nomeArquivo + ".txt";



        rendaFixa.escreverResultados(valorInvestido, resultado, nomeArquivo);
        scanner.close();
    }
    private static double calcularRendimentoSelic(double valorInvestido, int tempoMeses, double taxaSelic) {
        return valorInvestido * Math.pow((1 + (taxaSelic / 100)), tempoMeses);
    }


}
