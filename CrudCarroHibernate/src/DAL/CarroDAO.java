package DAL;
/**
 *
 * @author Thiago
 */

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import Modelo.Carro;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class CarroDAO
{

//    Conexao conexao = new Conexao();
    private String mensagem;
    Session session = HibernateUtil.getSessionFactory().openSession();
    public void cadastrarCarro(Carro carro)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.save(carro);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Carro Cadastrado com Sucesso!";
        }
        catch (Exception e)
        {
//            this.mensagem = e.getMessage();
            this.mensagem = "Erro de gravação no BD";
        }
    }

    public void editarCarro(Carro carro)
    {

        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.saveOrUpdate(carro);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Carro editado com Sucesso!";
        }
        catch (Exception e)
        {
//            this.mensagem = e.getMessage();
            System.out.println(e);
            this.mensagem = "Erro de gravação no BD";
        }
    }

    public void excluirCarro(Carro carro)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.delete(carro);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Carro excluido com sucesso!";
        }
        catch (Exception e)
        {
            System.out.println(e);
//            this.mensagem = e.getMessage();
            this.mensagem = "Erro de gravação no BD";
        }
    }

    public Carro pesquisarCarroPorId(Carro carro)
    {
        this.mensagem = "";
        try
        {
            Query q = session.createQuery("from Carro c where c.id = :id");
            q.setParameter("id", carro.getId());
            carro = (Carro) q.list().get(0); 
        }
        catch (Exception e)
        {
            this.mensagem = "erro de leitura no BD";                            // para o cliente
            //this.mensagem = e.getMessage();                                   //para desenvolvimento
        }
        return carro;
    }

    public List<Carro> pesquisarCarroPorFabricante(Carro carro)
    {
        this.mensagem = "";
        List<Carro> listaCarros = new ArrayList<>();
        try
        {
            Query q = session.createQuery("from Carro c where c.fabricante like :fabricante");
            q.setParameter("fabricante", carro.getFabricante()+ "%");
            listaCarros = (List<Carro>) q.list();
        }
        catch (Exception e)
        {
//            this.mensagem = e.getMessage();
            this.mensagem = "Erro de leitura no BD";
        }
        return listaCarros;
    }

    public List<Carro> pesquisarCarroPorModelo(Carro carro)
    {
        this.mensagem = "";
        List<Carro> listaCarros = new ArrayList<>();
        try
        {
            Query q = session.createQuery("from Carro c where c.modelo like :modelo");
            q.setParameter("modelo", carro.getModelo()+ "%");
            listaCarros = (List<Carro>) q.list();            
        }
        catch (Exception e)
        {
//            this.mensagem = e.getMessage();
            this.mensagem = "Erro de leitura no BD";
        }
        return listaCarros;
    }

    public String getMensagem()
    {
        return mensagem;
    }

    public void setMensagem(String mensagem)
    {
        this.mensagem = mensagem;
    }

}
