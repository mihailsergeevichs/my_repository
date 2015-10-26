package my.decided.tasks.level28.lesson15.big01.view;

import my.decided.tasks.level28.lesson15.big01.Controller;
import my.decided.tasks.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

/**
 * Created by Overlord on 21.08.2015.
 */
public class HtmlView implements View {

    Controller controller;
    private final String filePath = this.getClass().getPackage().toString().replace('.', '/').replaceFirst("package ", "./src/") +
            "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try{
            String s = getUpdatedFileContent(vacancies);
            updateFile(filePath);
        }
        catch (Throwable e){
            e.printStackTrace();
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;

    }
    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> vacancies) {
        String result;
        try {
            Document doc = null;
            try {
                doc = getDocument();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Element element = doc.select("[class*=\"template\"]").first();
            Element copy = element.clone();
            copy.removeAttr("style");
            copy.removeClass("template");

            doc.select("tr[class=\"vacancy\"]").remove();
            for (Vacancy vacancy : vacancies) {
                Element schema = copy.clone();
                schema.select("[class=\"city\"]").
                        first().text(vacancy.getCity());
                schema.select("[class=\"companyName\"]").first().text(vacancy.getCompanyName());
                schema.select("[class=\"salary\"]").first().text(vacancy.getSalary());
                Element link = schema.getElementsByTag("a").first();
                link.text(vacancy.getTitle());
                link.attr("href", vacancy.getUrl());
                element.before(schema.outerHtml());
            }
            result = doc.html();
        }
        catch (Exception e){
            e.printStackTrace();
            return "Some exception occurred";
        }
        return result;
    }

    protected Document getDocument() throws IOException{
        Document doc = Jsoup.parse(new File(filePath), "UTF-8");
        return doc;
    }


    private void updateFile(String s) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(filePath));
        writer.print(s);
        if (writer != null) {
            writer.close();
        }
    }
}
