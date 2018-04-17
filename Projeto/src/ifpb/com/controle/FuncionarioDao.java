package ifpb.com.controle;

import java.util.List;
import ifpb.com.modelo.Funcionario;
import java.io.IOException;

/**
 * Interface generica para FuncionarioDao(Data Access Object)
 * @version 1
 * @author Alisson Almeida
 */
public interface FuncionarioDao {

/**
* Metodo que salva um Objeto.
* @param f
* @return Objeto Funcionario 
* @throws java.io.IOException 
* @throws java.lang.ClassNotFoundException 
*/   
public boolean salvar(Funcionario f)throws IOException, ClassNotFoundException;
    
/**
* Metodo que busca um objeto atraves do codigo 
* @param codigo  
* @return Objeto Funcionario 
* @throws java.io.IOException 
* @throws java.lang.ClassNotFoundException 
*/ 
public Funcionario buscar(int codigo)throws IOException, ClassNotFoundException;

/**
* Metodo que lista os dados que estão em uma lista.
* @return Lista de Funcionario 
* @throws java.io.IOException 
* @throws java.lang.ClassNotFoundException 
*/ 
public List<Funcionario> listar() throws IOException, ClassNotFoundException;
   
/**
* Metodo deleta um objeto Funcionario. 
* @param f
* @return Objeto Funcionario 
* @throws java.io.IOException 
* @throws java.lang.ClassNotFoundException 
*/    
public boolean deletar(Funcionario f)throws IOException, ClassNotFoundException;
 
/**
* Metodo que busca um objeto atualiza o mesmo 
* @param f
* @return Objeto Funcionario 
* @throws java.io.IOException 
* @throws java.lang.ClassNotFoundException 
*/    
public boolean atualizar(Funcionario f)throws IOException, ClassNotFoundException;
}
