package my.decided.tasks.level28.lesson15.big01.model;

import my.decided.tasks.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Overlord on 21.08.2015.
 */
public class HHStrategy implements Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";


    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int pagenumber = 0;
        boolean flag = true;
        Document document = null;
        while (flag){
            try {
                document = getDocument(searchString, pagenumber);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Elements vacancyElements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            if(vacancyElements.size() == 0){
                flag = false;
            }
            for (Element vacancyElement : vacancyElements) {
                Vacancy vacancy = new Vacancy();
                vacancy.setTitle(vacancyElement.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                vacancy.setCompanyName(vacancyElement.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
                vacancy.setCity(vacancyElement.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                vacancy.setSiteName(document.title());
                vacancy.setUrl(vacancyElement.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
                vacancy.setSalary(vacancyElement.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
                vacancies.add(vacancy);
            }
            pagenumber++;
        }
        return vacancies;
    }
    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page)).
                userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.124 Safari/537.36").
                referrer("https://www.google.com.ua/").get();
    }
}