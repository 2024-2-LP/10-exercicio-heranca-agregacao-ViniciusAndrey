package school.sptech;

public class Desenvolvedor {
    protected String nome;
    protected Integer qtdHoras;
    protected Double valorHora;


    // Construtor

    public Desenvolvedor() {

    }

    public Desenvolvedor(String nome, Integer qtdHoras, Double valorHora) {
        this.nome = nome;
        this.qtdHoras = qtdHoras;
        this.valorHora = valorHora;
    }


    // Mêtodos

    public Double calcularSalario() {
        return qtdHoras * valorHora;
    }


    // Getter & Setter


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(Integer qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }
}
