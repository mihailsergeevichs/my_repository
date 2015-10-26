package my.decided.tasks.level28.lesson15.big01;

import my.decided.tasks.level28.lesson15.big01.model.HHStrategy;
import my.decided.tasks.level28.lesson15.big01.model.Model;
import my.decided.tasks.level28.lesson15.big01.model.Provider;
import my.decided.tasks.level28.lesson15.big01.view.HtmlView;


/**
 * Created by Overlord on 21.08.2015.
 */
public class Aggregator {
    public static void main(String[] args) {
        HtmlView view = new HtmlView();
        Provider[] providers = {new Provider(new HHStrategy())};
        Controller controller = new Controller(new Model(view, providers));
        view.setController(controller);
        view.userCitySelectEmulationMethod();
    }
}
