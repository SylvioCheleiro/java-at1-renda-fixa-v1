public class LCA extends RendaFixa implements Investimento {
    private double juros;

    public LCA(String nome, String cpf, String banco, double juros) {
        super(nome, cpf, banco);
        this.juros = 1.05;
    }

    public double calcularRendimento(double valorInvestido, int tempoMeses, double taxaSelic) {
        double rendimento = valorInvestido * Math.pow(1 + (juros / 100), tempoMeses);
        return rendimento;
    }
}