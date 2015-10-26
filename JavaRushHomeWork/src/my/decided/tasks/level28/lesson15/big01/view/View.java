package my.decided.tasks.level28.lesson15.big01.view;

import my.decided.tasks.level28.lesson15.big01.Controller;
import my.decided.tasks.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

/**
 * Created by Overlord on 21.08.2015.
 */
public interface View {
    void update(List<Vacancy> vacancies);
    void setController(Controller controller);
}
