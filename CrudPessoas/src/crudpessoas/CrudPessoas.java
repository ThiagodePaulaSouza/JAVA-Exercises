package crudpessoas;
import DAL.PessoaDAO;
import Modelo.Pessoa;
import Modelo.*;
import java.util.ArrayList;
import java.util.List;

public class CrudPessoas {

    public static void main(String[] args) 
    {
        Validacao validacao = new Validacao();
        List<String> dadosPessoa = new ArrayList<>();
        dadosPessoa.add("0");//ID
        dadosPessoa.add("josé de assis");//Nome
        dadosPessoa.add("12334556789");
        dadosPessoa.add("12345678912");
        validacao.validarDadosPessoa(dadosPessoa);
        System.out.println("mensagem = " + validacao.getMensagem());
        
//        PessoaDAO pessoaDao = new PessoaDAO();
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome("marcelin do porco");
//        pessoa.setRg("2222222222");
//        pessoa.setCpf("1111111111");
//        pessoaDao.cadastrarPessoa(pessoa);
//        System.out.println(pessoaDao.getMensagem());
    }
    
}
