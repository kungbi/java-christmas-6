package cristmas.config;

import cristmas.controller.Controller;

public class DependencyInjector {
    public Controller createController() {

        return new Controller();
    }
}
