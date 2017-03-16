package org.academiadecodigo.bootcamp.hackathon.services;

import java.util.HashMap;

/**
 * Created by codecadet on 3/16/17.
 */
public class ServiceRegistry {

    private static ServiceRegistry distributor;
    private HashMap<Class, Service> services;

    private ServiceRegistry() {
        services = new HashMap<>();
    }

    public static final ServiceRegistry getInstance() {

        if (distributor == null) {
            distributor = new ServiceRegistry();
        }

        return distributor;
    }

    public void registerService(Service service) {
        services.put(service.getServiceClass(), service);
    }

    public void unregisterService(Service service) {
        services.remove(service.getServiceClass(), service);
    }

    public Service getService(Class object) {
        return services.get(object);
    }

    public void resetDistributor() {
        services = new HashMap<>();
    }

}
