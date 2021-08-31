package crudpessoas;
import DAL.PessoaDAO;
import Modelo.Pessoa;

public class CrudPessoas {

    public static void main(String[] args) 
    {
        PessoaDAO pessoaDao = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("marcelo da silva");
        pessoa.setRg("2222222222");
        pessoa.setCpf("1111111111");
        pessoaDao.cadastrarPessoa(pessoa);
        System.out.println(pessoaDao.getMensagem());
    }
    
}
