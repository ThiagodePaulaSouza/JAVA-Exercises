package crudpessoas;

import Apresentacao.frmPrincipal;
import DAL.PessoaDAO;
import Modelo.Controle;
import Modelo.Pessoa;

public class CrudPessoas {

    public static void main(String[] args) 
    {
//        frmPrincipal frmP = new frmPrincipal(null, true);
//        frmP.setVisible(true);
        
        Pessoa pessoa = new Pessoa();
        Controle controle = new Controle();
        pessoa = controle.pesquisarPessoaPorId("3");
        if (controle.getMensagem().equals(""))
        {
            System.out.println(pessoa.getId() + " " + pessoa.getNome() + "\n" +
                    pessoa.getRg() + " " + pessoa.getCpf());
        }
        else
            System.out.println(controle.getMensagem());
    }
    
}
