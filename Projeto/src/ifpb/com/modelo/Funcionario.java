package ifpb.com.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Funcionario extends Pessoa implements Serializable{
    private  int id;
    private int ctps;
    private float salario;
    
    public Funcionario(int id, int ctps, float salario, String nome, String cpf, String endereco, String nascimento, String email) {
        super(nome, cpf, endereco, nascimento, email);
        this.id = id;
        this.ctps = ctps;
        this.salario = salario;
    }

    public Funcionario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCtps() {
        return ctps;
    }

    public void setCtps(int ctps) {
        this.ctps = ctps;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
        hash = 71 * hash + this.ctps;
        hash = 71 * hash + Float.floatToIntBits(this.salario);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcionario other = (Funcionario) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.ctps != other.ctps) {
            return false;
        }
        if (Float.floatToIntBits(this.salario) != Float.floatToIntBits(other.salario)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "id=" + id + ", ctps=" + ctps + ", salario=" + salario + '}';
    }
    
    
    
}
