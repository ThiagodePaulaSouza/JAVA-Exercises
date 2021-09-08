package crudpessoas;

import Apresentacao.frmPrincipal;
import DAL.PessoaDAO;
import Modelo.Pessoa;

public class CrudPessoas {

    public static void main(String[] args) 
    {
//        frmPrincipal frmP = new frmPrincipal(null, true);
//        frmP.setVisible(true);
        
        Pessoa pessoa = new Pessoa();
        pessoa.setId(3);
        PessoaDAO pessoaDAO = new PessoaDAO();
        pessoa = pessoaDAO.pesquisarPessoaPorId(pessoa);
        if (pessoaDAO.getMensagem().equals(""))
        {
            System.out.println(pessoa.getId() + " " + pessoa.getNome() + "\n" +
                    pessoa.getRg() + " " + pessoa.getCpf());
        }
        else
            System.out.println(pessoaDAO.getMensagem());
    }
    
}
