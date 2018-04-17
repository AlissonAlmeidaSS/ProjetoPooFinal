package ifpb.com.controle;

import ifpb.com.modelo.Produto;
import java.io.IOException;
import java.util.List;

/**
 * Interface generica para ProdutoDao(Data Access Object)
 * @version 1
 * @author Alisson Almeida
 */
public interface ProdutoDao {
    
/**
* Metodo que salva um Objeto.
* @param p
* @return Objeto Produto 
* @throws java.io.IOException 
* @throws java.lang.ClassNotFoundException 
*/
    public boolean salvar(Produto p)throws IOException, ClassNotFoundException;

/**
* Metodo que busca um objeto atraves do codigo 
* @param codigo  
* @return Objeto Produto 
* @throws java.io.IOException 
* @throws java.lang.ClassNotFoundException 
*/    
    public Produto buscar(int codigo)throws IOException, ClassNotFoundException;
    
/**
* Metodo que lista os dados que estão em uma lista.
* @return Lista de Produto 
* @throws java.io.IOException 
* @throws java.lang.ClassNotFoundException 
*/    
    public List<Produto> listar() throws IOException, ClassNotFoundException;
    
/**
* Metodo deleta um objeto produto. 
* @param p  
* @return Objeto Produto 
* @throws java.io.IOException 
* @throws java.lang.ClassNotFoundException 
*/    
    public boolean deletar(Produto p)throws IOException, ClassNotFoundException;
 
/**
* Metodo que busca um objeto atualiza o mesmo 
* @param p  
* @return Objeto Produto 
* @throws java.io.IOException 
* @throws java.lang.ClassNotFoundException 
*/    
    public boolean atualizar(Produto p)throws IOException, ClassNotFoundException;
}