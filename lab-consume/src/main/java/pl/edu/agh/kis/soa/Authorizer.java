package pl.edu.agh.kis.soa;

import javax.xml.ws.BindingProvider;

public class Authorizer {

    public static void setCredentials(BindingProvider port) {
        BindingProvider prov = (BindingProvider)port;
        prov.getRequestContext().put(BindingProvider. USERNAME_PROPERTY, "usr");
        prov.getRequestContext().put(BindingProvider. PASSWORD_PROPERTY, "usr");
    }
}
