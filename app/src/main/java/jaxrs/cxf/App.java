/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package jaxrs.cxf;

import org.apache.cxf.binding.BindingFactoryManager;
import org.apache.cxf.jaxrs.JAXRSBindingFactory;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class App {
    public static void main(String[] args) {
        var serverFactory = new JAXRSServerFactoryBean();
        serverFactory.setResourceClasses(BasicApi.class);
        serverFactory.setResourceProvider(BasicApi.class, new SingletonResourceProvider(new BasicApi()));
        serverFactory.setAddress("http://localhost:8080/");

        var bindingFactory = new JAXRSBindingFactory();
        bindingFactory.setBus(serverFactory.getBus());

        var manager = serverFactory.getBus().getExtension(BindingFactoryManager.class);
        manager.registerBindingFactory(JAXRSBindingFactory.JAXRS_BINDING_ID, bindingFactory);

        serverFactory.create();
    }
}