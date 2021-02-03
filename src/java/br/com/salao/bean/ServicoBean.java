
import br.com.salao.dao.ServicoDAO;
import br.com.salao.vo.Cliente;
import br.com.salao.vo.Servico;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ServicoBean implements Serializable {

    private Servico servico;
    private Servico servicoSelecionado;
    private List<Servico> lista;
    private List<Servico> listaFiltrada;

    public ServicoBean() {
        servico = new Servico();
        lista = new ServicoDAO().listarTudo();
        listaFiltrada = new ArrayList<Servico>();
    }

    public Servico getServicoSelecionado() {
        return servicoSelecionado;
    }

    public void setServicoSelecionado(Servico servicoSelecionado) {
        this.servicoSelecionado = servicoSelecionado;
    }

    public List<Servico> getLista() {
        return lista;
    }

    public void setLista(List<Servico> lista) {
        this.lista = lista;
    }

    public List<Servico> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Servico> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public String salvar() {
        if (servico.getId() != 0) {
            new ServicoDAO().atualizar(this.servico);
        } else {
            new ServicoDAO().salvar(this.servico);
        }
        return "index.xhtml";
    }

    public List<Servico> listar() {
        return new ServicoDAO().listarTudo();
        // como seria a consulta para vir ordenado???
        // String sql= " select * from Cliente order by nome asc;"
        // String´[] param = {};
        // return new ClienteDAO().listar(sql,param);
    }
    // public List<Servico> listarServicosOk() {
       // return ServicoBO.listarServicoOk();
    // }

    public void remover() {
        new ServicoDAO().remover(servicoSelecionado);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Removido com Sucesso", "O cliente " + servicoSelecionado.getNome() + " foi removido.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        lista = new ServicoDAO().listarTudo();
    }

    public String prepararParaAtualizar() {
        this.servico = servicoSelecionado;
        return "addServico.xhtml";
    }

}
