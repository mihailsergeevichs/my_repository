package my.decided.tasks.level28.lesson15.big01;

import my.decided.tasks.level28.lesson15.big01.model.Model;


/**
 * Created by Overlord on 21.08.2015.
 */
public class Controller {
    private Model model;

    public Controller(Model model) {
        if(model == null){
            throw new IllegalArgumentException();
        }
        this.model = model;
    }
    public void onCitySelect(String cityName){
        model.selectCity(cityName);
    }
}

