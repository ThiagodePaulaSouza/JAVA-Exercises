package crudpessoas;

import Apresentacao.frmPrincipal;
import DAL.Conexao;

public class CrudPessoas
{

    public static void main(String[] args)
    {
//        frmPrincipal frmP = new frmPrincipal(null, true);
//        frmP.setVisible(true);
        Conexao conexao = new Conexao();
        conexao.conectar();
        System.out.println(conexao.mensagem);

    }

}
