package pl.edu.agh.kis.soa;

import pl.edu.agh.kis.soa.generated.HelloWorld;
import pl.edu.agh.kis.soa.generated.HelloWorldService;

import javax.xml.ws.BindingProvider;

public class HelloWorldConsumer {

    private HelloWorldService helloWorldService;
    private HelloWorld helloWorld;

    public HelloWorldConsumer() {
        helloWorldService = new HelloWorldService();
        helloWorld = helloWorldService.getHelloWorldPort();
        Authorizer.setCredentials((BindingProvider) helloWorld);
    }

    public String sayHello(String name) {
        return helloWorld.helloAction(name);
    }

}
