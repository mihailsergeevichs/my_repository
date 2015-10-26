package my.decided.tasks.level28.lesson15.big01.model;

import my.decided.tasks.level28.lesson15.big01.view.View;
import my.decided.tasks.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Overlord on 21.08.2015.
 */
public class Model {
    View view;
    Provider[] providers;

    public Model(View view, Provider[] providers) {
        if(view == null || providers == null || providers.length == 0){
            throw new IllegalArgumentException();
        }
        this.providers = providers;
        this.view = view;
    }

    public void selectCity(String city) {
        List<Vacancy> vacancies = new ArrayList<>();

        for (Provider provider : providers) {
            vacancies.addAll(provider.getJavaVacancies(city));
        }
        view.update(vacancies);
    }
}
