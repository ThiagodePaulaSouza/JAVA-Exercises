package DAL;

import Modelo.Endereco;
import Modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO
{

    private String mensagem;
    Conexao conexao = new Conexao();

    public void cadastrarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            if (conexao.getMensagem().equals(""))
            {
                String comSql = "insert into Pessoas (nome, rg, cpf)"
                        + "values(?,?,?) "
                        + "declare @idPessoa int = @@identity "                  //@@identity é o ultimo id que cadastrou
                        + "select @idPessoa as idPessoa";
                PreparedStatement stmt = con.prepareStatement(comSql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, pessoa.getNome());
                stmt.setString(2, pessoa.getRg());
                stmt.setString(3, pessoa.getCpf());
                stmt.execute();
                ResultSet rs = stmt.getGeneratedKeys();
                rs.next();
                int id = rs.getInt(1);
                for (Endereco endereco : pessoa.getListaEnderecos())
                {
                    comSql = "insert into enderecos"
                            + "(fk_pessoas_id, logradouro, numero, bairro, cidade)"
                            + "values(?,?,?,?,?)";
                    stmt = con.prepareStatement(comSql);
                    stmt.setInt(1, id);
                    stmt.setString(2, endereco.getLogradouro());
                    stmt.setString(3, endereco.getNumero());
                    stmt.setString(4, endereco.getBairro());
                    stmt.setString(5, endereco.getCidade());
                    stmt.execute();
                }
                conexao.desconectar();
                this.mensagem = "Pessoa cadastrada com sucesso!!";
            }
            else
            {
                this.mensagem = conexao.getMensagem();
            }

        }
        catch (Exception e)
        {
            this.mensagem = "erro de gravação no BD";                           // para o cliente
            //this.mensagem = e.getMessage();                                   //para desenvolvimento
        }
    }

    public void editarPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            if (conexao.getMensagem().equals(""))
            {
                String comSql = "update pessoas "
                        + "set nome = ?,"
                        + "rg = ?,"
                        + "cpf = ? "
                        + "where id = ?";
                PreparedStatement stmt = con.prepareStatement(comSql);
                stmt.setString(1, pessoa.getNome());
                stmt.setString(2, pessoa.getRg());
                stmt.setString(3, pessoa.getCpf());
                stmt.setInt(4, pessoa.getId());
                stmt.execute();
                conexao.desconectar();
                this.mensagem = "Pessoa editada com sucesso!!";
            }
            else
            {
                this.mensagem = conexao.getMensagem();
            }

        }
        catch (Exception e)
        {
            this.mensagem = "erro de gravação no BD";                           // para o cliente
//            this.mensagem = e.getMessage();                                   //para desenvolvimento
        }
    }

    public void excluirPessoa(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            if (conexao.getMensagem().equals(""))
            {
                pessoa = this.pesquisarPessoaPorId(pessoa);
                if (pessoa.getNome() == null || pessoa.getNome().equals(""))
                {
                    this.mensagem = "Não existe esta pessoa para excluir";
                }
                else
                {
                    String comSql = "delete from Pessoas where id = ?";
                    PreparedStatement stmt = con.prepareStatement(comSql);
                    stmt.setInt(1, pessoa.getId());
                    stmt.execute();
                    conexao.desconectar();
                    this.mensagem = "Pessoa excluida com sucesso!!";
                }
            }

        }
        catch (Exception e)
        {
            this.mensagem = "erro de gravação no BD";                           // para o cliente
            //this.mensagem = e.getMessage();                                   //para desenvolvimento
        }
    }

    public Pessoa pesquisarPessoaPorId(Pessoa pessoa)
    {
        this.mensagem = "";
        try
        {
            Connection con = conexao.conectar();
            if (conexao.getMensagem().equals(""))
            {
                String comSql = "select * from pessoas where id = ?";
                PreparedStatement stmt = con.prepareStatement(comSql);
                stmt.setInt(1, pessoa.getId());
                ResultSet resultSet = stmt.executeQuery();                      //quando se tem resposta
                if (resultSet.next())                                           //se conseguir dar next significa que conseguiu um id
                {
                    pessoa.setNome(resultSet.getString("nome"));
                    pessoa.setRg(resultSet.getString("rg"));
                    pessoa.setCpf(resultSet.getString("cpf"));
                }
                else
                {
                    this.mensagem = "não existe este ID";
                }
                conexao.desconectar();
            }
            else
            {
                this.mensagem = conexao.getMensagem();
            }

        }
        catch (Exception e)
        {
            this.mensagem = "erro de leitura no BD";                            // para o cliente
            //this.mensagem = e.getMessage();                                   //para desenvolvimento
        }
        return pessoa;
    }

    public List<Pessoa> pesquisarPessoaPorNome(Pessoa pessoa)
    {
        this.mensagem = "";
        List<Pessoa> listaPessoas = new ArrayList<>();
        try
        {
            Connection con = conexao.conectar();
            if (conexao.getMensagem().equals(""))
            {
                String comSql = "select * from pessoas where nome like ?";
                PreparedStatement stmt = con.prepareStatement(comSql);
                stmt.setString(1, pessoa.getNome() + "%");
                ResultSet resultSet = stmt.executeQuery();                      //quando se tem resposta
                while (resultSet.next())                                        //se conseguir dar next significa que conseguiu um id
                {
                    Pessoa pessoaLista = new Pessoa();
                    pessoaLista.setId(resultSet.getInt("id"));
                    pessoaLista.setNome(resultSet.getString("nome"));
                    pessoaLista.setRg(resultSet.getString("rg"));
                    pessoaLista.setCpf(resultSet.getString("cpf"));
                    listaPessoas.add(pessoaLista);
                }
                conexao.desconectar();
            }
            else
            {
                this.mensagem = conexao.getMensagem();
            }

        }
        catch (Exception e)
        {
            this.mensagem = "erro de leitura no BD";                            // para o cliente
            //this.mensagem = e.getMessage();                                   //para desenvolvimento
        }
        return listaPessoas;
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
