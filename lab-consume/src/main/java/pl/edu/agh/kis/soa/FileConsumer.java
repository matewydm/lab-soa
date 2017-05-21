package pl.edu.agh.kis.soa;


import pl.edu.agh.kis.soa.generated.*;

import javax.xml.ws.BindingProvider;

public class FileConsumer {

    private FileSender fileSender;
    private FileSenderService fileSenderService;

    public FileConsumer() {
        fileSenderService = new FileSenderService();
        fileSender = fileSenderService.getFileSenderPort();
        Authorizer.setCredentials((BindingProvider) fileSender);
    }

    public String sendFile(String path) {
        return fileSender.send(path);
    }

}
