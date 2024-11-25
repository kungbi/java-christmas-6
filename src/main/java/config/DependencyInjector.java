package config;

import controller.Controller;

public class DependencyInjector {
    public Controller createController() {

        return new Controller();
    }
}
