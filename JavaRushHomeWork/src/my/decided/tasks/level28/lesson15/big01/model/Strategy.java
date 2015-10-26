package my.decided.tasks.level28.lesson15.big01.model;

import my.decided.tasks.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Overlord on 21.08.2015.
 */

    public interface Strategy {
    List<Vacancy> getVacancies(String searchString);
}
