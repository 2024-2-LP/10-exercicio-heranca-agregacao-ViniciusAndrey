package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    // Construtor

    public Consultoria() {
        desenvolvedores = new ArrayList<>();
    }

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<Desenvolvedor>();
    }

    // Mêtodos

    public Boolean contratar(Desenvolvedor desenvolvedor) {
            if(desenvolvedores.size() >= vagas) {
                return false;
            }
            desenvolvedores.add(desenvolvedor);
            return true;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor != null && desenvolvedor.isFullstack()) {
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;

    }

    public Double getTotalSalarios() {
        double salario = 0.0;
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            salario += desenvolvedor.calcularSalario();
        }
        return salario;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer contador = 0;
        for (Desenvolvedor desenvolvedorMobile : desenvolvedores) {
            if(desenvolvedorMobile instanceof DesenvolvedorMobile) {
                contador++;
            }
        }
        return contador;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> resultado = new ArrayList<>();
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() >= salario) {
                resultado.add(desenvolvedor);
            }
        }
        return resultado;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }

        Desenvolvedor menorSalarioDev = desenvolvedores.get(0);
        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if (desenvolvedor.calcularSalario() < menorSalarioDev.calcularSalario()) {
                menorSalarioDev = desenvolvedor;
            }
        }
        return menorSalarioDev;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {

        List<Desenvolvedor> resultadoTec = new ArrayList<>();

        for (Desenvolvedor desenvolvedor : desenvolvedores) {
            if(desenvolvedor instanceof DesenvolvedorMobile) {
                if(((DesenvolvedorMobile) desenvolvedor).getPlataforma().equalsIgnoreCase(tecnologia) ||
                        ((DesenvolvedorMobile) desenvolvedor).getLinguagem().equalsIgnoreCase(tecnologia)) {
                    resultadoTec.add(desenvolvedor);
                }
            }
            if (desenvolvedor instanceof DesenvolvedorWeb) {
               if(((DesenvolvedorWeb) desenvolvedor).getBackend().equalsIgnoreCase(tecnologia) ||
               ((DesenvolvedorWeb) desenvolvedor).getFrontend().equalsIgnoreCase(tecnologia) ||
               ((DesenvolvedorWeb) desenvolvedor).getSgbd().equalsIgnoreCase(tecnologia)) {
                   resultadoTec.add(desenvolvedor);
               }
            }
        }
        return resultadoTec;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
            double salario = 0.0;
            List<Desenvolvedor> salarioTec = buscarPorTecnologia(tecnologia);
            for (Desenvolvedor desenvolvedor : salarioTec) {
                salario += desenvolvedor.calcularSalario();
            }
            return salario;
    }

    // Getter & Setter

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
