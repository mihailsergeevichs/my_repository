package my.decided.tasks.level28.lesson15.big01.model;

import my.decided.tasks.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Overlord on 21.08.2015.
 */
public class Provider
{
    private Strategy strategy;

    public Provider(Strategy strategy)
    {
        //if(strategy==null) throw new IllegalArgumentException();
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy)
    {
        //if(strategy==null) throw new IllegalArgumentException();
        this.strategy = strategy;
    }

    public List<Vacancy> getJavaVacancies(String searchString)
    {
        if(strategy==null) return new ArrayList<>();
        //if(strategy==null) return null;
        return strategy.getVacancies(searchString);
    }
}