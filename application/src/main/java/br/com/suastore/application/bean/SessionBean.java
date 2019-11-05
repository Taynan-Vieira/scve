package br.com.suastore.application.bean;

import br.com.suastore.application.rewrite.RewriteProvider;
import org.ocpsoft.rewrite.faces.navigate.Navigate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("session")
public class SessionBean implements Serializable {

    private static final long serialVersionUID = 1354308799917731143L;

    public Navigate navigateToDashboard() {
        return Navigate.to(RewriteProvider.DASHBOARD);
    }

    public Navigate navigateToCadastroCLiente() {
        return Navigate.to(RewriteProvider.CADASTRO_CLIENTE);
    }

    public Navigate navigateToError() {
        return Navigate.to(RewriteProvider.ERROR);
    }

    public Navigate navigateTo404Error() {
        return Navigate.to(RewriteProvider.ERROR_404);
    }
}
