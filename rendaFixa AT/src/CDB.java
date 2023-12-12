public class CDB extends RendaFixa implements Investimento {
    private double juros;
    public CDB(String nome, String cpf, String banco, double juros) {
        super(nome, cpf, banco);
        this.juros = juros/10;
    }

    public double calcularRendimento(double valorInvestido, int tempoMeses, double taxaSelic) {
        double rendimento = valorInvestido * Math.pow(1 + (juros / 100), tempoMeses);
        double descontoIR = calcularDescontoIR(tempoMeses);
        return rendimento - descontoIR;
    }
    private double calcularDescontoIR(int tempoMeses) {
        double descontoIR = 0;

        if (tempoMeses <= 6) {
            descontoIR = 0.225;
        }
        else if (tempoMeses <= 12) {
            descontoIR = 0.20;
        }
        else if (tempoMeses <= 24) {
            descontoIR = 0.175;
        }
        else {
            descontoIR = 0.15;
        }

        return descontoIR;
    }

}
