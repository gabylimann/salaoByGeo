
package br.com.salao.bean;

import br.com.salao.dao.FuncionarioDAO;
import br.com.salao.vo.Funcionario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FuncionarioBean {
    private Funcionario funcionario;

    public FuncionarioBean() {
        this.funcionario = new Funcionario();
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    public String salvar(){
        new FuncionarioDAO().salvar(this.funcionario);
        return "sidemenu.xhtml";
    }
}
