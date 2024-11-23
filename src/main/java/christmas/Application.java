package christmas;

import christmas.config.DependencyInjector;
import christmas.controller.Controller;

public class Application {
    public static void main(String[] args) {
        DependencyInjector dependencyInjector = new DependencyInjector();
        Controller controller = dependencyInjector.createController();

        controller.run();
    }
}
