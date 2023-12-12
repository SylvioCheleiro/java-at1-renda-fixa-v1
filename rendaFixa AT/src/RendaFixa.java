import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RendaFixa {
    private String nome;
    private String cpf;
    private String banco;

    public RendaFixa(String nome, String cpf, String banco) {
        this.nome = nome;
        this.cpf = cpf;
        this.banco = banco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public void escreverResultados(double valorInvestido, double rendimento,  String nomeArquivo) {

        File arquivo = new File(nomeArquivo);

        if (arquivo.exists()) {
            System.out.println("Excluindo arquivo existente: " + nomeArquivo);
            arquivo.delete();
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            writer.write("Nome: " + nome);
            writer.newLine();
            writer.write("CPF: " + cpf);
            writer.newLine();
            writer.write("Banco: " + banco);
            writer.newLine();
            writer.write("Investimento Inicial: R$ " + valorInvestido);
            writer.newLine();
            writer.write("Rendimento:  " + rendimento);
            writer.newLine();
            System.out.println("Resultados escritos no arquivo: " + nomeArquivo);
        }
        catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo.");
            e.printStackTrace();
        }

    }
}
