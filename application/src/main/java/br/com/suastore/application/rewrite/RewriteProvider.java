package br.com.suastore.application.rewrite;


import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

import javax.servlet.ServletContext;

@RewriteConfiguration
public class RewriteProvider extends HttpConfigurationProvider {

    public static final  String DASHBOARD = "/";
    public static final String CADASTRO_CLIENTE = "/cadastroCliente";
    public static final String ERROR = "/error500";
    public static final String ERROR_404 = "/error404";
    public static final String ACESSO_NEGADO = "/acessoNegado";

    @Override
    public Configuration getConfiguration(final ServletContext servletContext) {
        return ConfigurationBuilder
                .begin()
                .addRule(Join.path(DASHBOARD).to("/page/public/dashboard.xhtml"))
		        //CLIENTE
                .addRule(Join.path(CADASTRO_CLIENTE).to("/page/private/cliente/cadastro-cliente.xhtml"))

                //ACESSO NEGADO
                .addRule(Join.path(ACESSO_NEGADO).to("/page/public/acesso-negado.xhtml"))

                //ERRORS
                .addRule(Join.path(ERROR).to("/error.xhtml"))
                .addRule(Join.path(ERROR_404).to("/error-404.xhtml"));

    }

    @Override
    public int priority() {
        return 10;
    }
}
