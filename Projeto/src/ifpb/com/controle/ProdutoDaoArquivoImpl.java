package ifpb.com.controle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import ifpb.com.modelo.Produto;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * Classe FuncionarioDaoArquivoImpl(Data Access Object)
 * Essa classe possui metodos herdados do da Classe ProdutoDao que a mesma cria CRUD
 * CRUD (Create, Read, Update e Delete) 
 * @version 1
 * @author Alisson Almeida
 */
public class ProdutoDaoArquivoImpl implements ProdutoDao{ 
    
    private File file;
/**
 * Contrutor da Classe aonde ele cria Arquivo bin de produto e a mesma gera uma exceção se não conseguir criar o arquivo
 * @throws IOException[]
 */
    public ProdutoDaoArquivoImpl() throws IOException {
    
    file = new File("Arquivos/produto.bin");

        if (!file.exists()) {
            file.createNewFile();
        }
    }

/**
 * Metodo adiciona um produto a lista atraves ADD que e um servico de List 
 * O mesmo antes de adicionar ele irar fazer uma busca pelo ID do funcionario
 * pra saber se o mesmo nao esta ja gravado no arquivo
 * @param f
 * @return objeto funcionario
 * @throws ClassNotFoundException 
 * @throws IOException
 */     
    @Override
    public boolean salvar(Produto p) throws IOException, ClassNotFoundException {
        
        if (buscar(p.getCodigo()) == null) {
            List<Produto> produto = listar();

            if (produto.add(p)) {
                atualizarArquivo(produto);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

/**
 * Metodo buscar um produto na lista atraves coidgo passado pelo usuario 
 * @return objeto funcionario
 * @param codigo
 * @throws ClassNotFoundException
 * @throws IOException
 */    
    @Override
    public Produto buscar(int codigo) throws IOException, ClassNotFoundException {

        List<Produto> produtos = listar();

        for (Produto f : produtos) {
            if (f.getCodigo()== codigo) {
                return f;
            }
        }
        return null;

    }

/**
 * Metodo deletar um produto da lista atraves remove que e um servico de List
 * @param p
 * @return boolean
 * @throws ClassNotFoundException
 * @throws IOException
 */    
    @Override
    public boolean deletar(Produto p) throws IOException, ClassNotFoundException {
       
        List<Produto> produtos = listar();
        if (produtos.remove(p)) {
            atualizarArquivo(produtos);
            return true;
        }else{
            return false;
        }
    }

/**
 * Metodo atualizar um Produto da lista atraves remove que e um servico de List
 * @param p
 * @return boolean
 * @throws ClassNotFoundException
 * @throws IOException
 */    
    @Override
    public boolean atualizar(Produto p) throws IOException, ClassNotFoundException {
        
        List<Produto> produtos = listar();
        
        for (int i = 0; i < produtos.size(); i++) {
            if (p.getCodigo()== produtos.get(i).getCodigo()) {
               produtos.set(i, p);
                atualizarArquivo(produtos);
                return true;
            }
        }
        return false;
    }

/**
 * Metodo Listar retorna a lista de funcionarios cadastrado
 * @return funcionario
 * @throws IOException
 * @throws ClassNotFoundException
 */     
    @Override
    public List<Produto> listar() throws IOException, ClassNotFoundException {
        
        if (file.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            return (List<Produto>) in.readObject();
        } else {
            return new ArrayList<>();
        }
    }

/**
 * Metodo Atualizar Arquivo
 * @throws IOException
 */     
    private void atualizarArquivo(List<
            Produto> produto) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

        out.writeObject(produto);
        out.close();
    }
}