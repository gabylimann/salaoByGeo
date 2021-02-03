
import br.com.salao.dao.FuncionarioDAO;
import br.com.salao.vo.Funcionario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class FuncionarioBean implements Serializable {

    private Funcionario funcionario;
    private Funcionario funcionarioSelecionado;
    private List<Funcionario> lista;
    private List<Funcionario> listaFiltrada;

    public FuncionarioBean() {
        funcionario = new Funcionario();
        lista = new FuncionarioDAO().listarTudo();
        listaFiltrada = new ArrayList<Funcionario>();
    }

    public Funcionario getFuncionarioSelecionado() {
        return funcionarioSelecionado;
    }

    public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
        this.funcionarioSelecionado = funcionarioSelecionado;
    }

    public List<Funcionario> getLista() {
        return lista;
    }

    public void setLista(List<Funcionario> lista) {
        this.lista = lista;
    }

    public List<Funcionario> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Funcionario> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String salvar() {
        if (funcionario.getId() != 0) {
            new FuncionarioDAO().atualizar(funcionario);
        } else {
            new FuncionarioDAO().salvar(this.funcionario);
        }
        return "index.xhtml";
    }

    public List<Funcionario> listar() {
        return new FuncionarioDAO().listarTudo();
        // como seria a consulta para vir ordenado???
        // String sql= " select * from Cliente order by nome asc;"
        // String´[] param = {};
        // return new FuncionarioDAO().listar(sql,param);
    }

    // public List<Cliente> listarFuncionariosOk() {
        // return FuncionarioBO.listarFuncionariosOk();
    // }

    public void remover() {
        new FuncionarioDAO().remover(funcionarioSelecionado);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido com Sucesso", "O funcionario " + funcionarioSelecionado.getNome() + " foi removido.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        lista = new FuncionarioDAO().listarTudo();
    }

    public String prepararParaAtualizar() {
        funcionario = funcionarioSelecionado;
        return "addCliente.xhtml";
    }
}
