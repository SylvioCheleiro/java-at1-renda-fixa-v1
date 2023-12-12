public class Poupanca extends RendaFixa implements Investimento {
    private double juros;

    public Poupanca(String nome, String cpf, String banco, double juros) {
        super(nome, cpf, banco);
        this.juros = juros/100;
    }

    public double calcularRendimento(double valorInvestido, int tempoMeses, double taxaSelic) {
        double rendimento;
        if (taxaSelic >= 8.5) {
            rendimento = valorInvestido * Math.pow(1 + (juros / 100), tempoMeses);
        } else {
            rendimento = valorInvestido * Math.pow(1 + (0.7 * taxaSelic / 100 / 12), tempoMeses);
        }
        return rendimento;
    }
}
