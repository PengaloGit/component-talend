package com.company.talend.components.processor;

import java.io.Serializable;

import org.talend.sdk.component.api.configuration.Option;
import org.talend.sdk.component.api.configuration.condition.ActiveIf;
import org.talend.sdk.component.api.configuration.ui.DefaultValue;
import org.talend.sdk.component.api.configuration.ui.layout.GridLayout;
import org.talend.sdk.component.api.meta.Documentation;

@GridLayout({
    // the generated layout put one configuration entry per line,
    // customize it as much as needed
        @GridLayout.Row({ "host","port" }),
        @GridLayout.Row({ "user","password" }),
        @GridLayout.Row({ "database" })
})
@Documentation("TODO fill the documentation for this configuration")
public class ComponentProcessorConfiguration implements Serializable {

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String host;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String port;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String user;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String password;

    @Option
    @Documentation("TODO fill the documentation for this parameter")
    private String database;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getPort() {
        return port;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getDatabase() {
        return database;
    }
}