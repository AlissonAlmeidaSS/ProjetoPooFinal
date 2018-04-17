package ifpb.com.controle;

import ifpb.com.modelo.Funcionario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe FuncionarioDaoArquivoImpl(Data Access Object)
 * Essa classe possui metodos herdados do da Classe ProdutoDao que a mesma cria CRUD
 * CRUD (Create, Read, Update e Delete) 
 * @version 1
 * @author Alisson Almeida
 */
public class FuncionarioDaoArquivoImpl implements FuncionarioDao{

    private File file;
/**
 * Contrutor da Classe aonde ele cria Arquivo bin de funcionario e a mesma gera uma exceção se não conseguir criar o arquivo
 * @throws IOException[]
 */

    public FuncionarioDaoArquivoImpl() throws IOException {
        file = new File("Arquivos/funcionario.bin");

        if (!file.exists()) {
            file.createNewFile();
        }
    }
    
/**
 * Metodo salvar um funcionario a lista atraves ADD que e um servico de List 
 * O mesmo antes de adicionar ele irar fazer uma busca pelo ID do funcionario
 * pra saber se o mesmo nao esta ja gravado no arquivo
 * @param f
 * @return objeto funcionario
 * @throws ClassNotFoundException 
 * @throws IOException
 */     
    @Override
    public boolean salvar(Funcionario f) throws IOException, ClassNotFoundException {
        
        if (buscar(f.getId()) == null) {
            List<Funcionario> funcionario = listar();

            if (funcionario.add(f)) {
                atualizarArquivo(funcionario);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
/**
 * Metodo buscar um Funcionario a lista atraves id passado pelo usuario 
 * @return objeto funcionario
 * @param id
 * @throws ClassNotFoundException
 * @throws IOException
 * 
 */
    @Override
    public Funcionario buscar(int id) throws IOException, ClassNotFoundException {

        List<Funcionario> funcionarios = listar();

        for (Funcionario f : funcionarios) {
            if (f.getId()== id) {
                return f;
            }
        }
        return null;

    }

/**
 * Metodo deletar um Funcinario da lista atraves remove que e um servico de List
 * @param f
 * @return boolean
 * @throws ClassNotFoundException
 * @throws IOException
 */    
    @Override
    public boolean deletar(Funcionario f) throws IOException, ClassNotFoundException {
       
        List<Funcionario> funcionarios = listar();
        if (funcionarios.remove(f)) {
            atualizarArquivo(funcionarios);
            return true;
        }else{
            return false;
        }
    }

/**
 * Metodo atualizar um Funcinario da lista atraves remove que e um servico de List
 * @param f
 * @return boolean
 * @throws ClassNotFoundException
 * @throws IOException
 */     
    @Override
    public boolean atualizar(Funcionario f) throws IOException, ClassNotFoundException {
        
        List<Funcionario> funcionarios = listar();
        
        for (int i = 0; i < funcionarios.size(); i++) {
            if (f.getId()== funcionarios.get(i).getId()) {
               funcionarios.set(i, f);
                atualizarArquivo(funcionarios);
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
    public List<Funcionario> listar() throws IOException, ClassNotFoundException {
        
        if (file.length() > 0) {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            return (List<Funcionario>) in.readObject();
        } else {
            return new ArrayList<>();
        }
    }

/**
 * Metodo Atualizar Arquivo
 * @throws IOException
 */    
    private void atualizarArquivo(List<Funcionario> funcionarios) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));

        out.writeObject(funcionarios);
        out.close();
    }
    
    
    
}
