package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private final static String URL_FORMAT =
            "http://hh.ua/search/vacancy?text=java+%s&page=%d";
            //http://hh.ua/search/vacancy?text=java+Kiev&page=%d&salary=%d1

    public String myTest = String.format(URL_FORMAT,"Kiev", 3);
    public String cashedTest = "http://javarush.ru/testdata/big28data.html";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancyList = new ArrayList<>();
        Document document = null;
        int page = 0;
        //String url = String.format(URL_FORMAT,searchString,page);

        while (true) {
            try {
                document = getDocument(searchString, page);
            } catch (Exception e) {
                System.out.println(e);
            }
            Elements vacancyserpAll = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            if (vacancyserpAll.size() != 0) {
                for (Element element : vacancyserpAll) {
                    String vaTitle = element.select("a").first().text();
                    String vaCity = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").first().text();
                    String vaCompanyName = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").first().text();
                    String vaUrl = element.select("a").attr("href");
                    String vaSiteName = "http://hh.ua";

                    String vaSalary = "";
                    try {
                        vaSalary = element.getElementsByAttributeValue("class", "b-vacancy-list-salary").first().text();
                    } catch (Exception e) {

                    }
                    Vacancy newVacancy = new Vacancy();
                    newVacancy.setTitle(vaTitle);
                    newVacancy.setSalary(vaSalary);
                    newVacancy.setCity(vaCity);
                    newVacancy.setCompanyName(vaCompanyName);
                    newVacancy.setSiteName(vaSiteName);
                    newVacancy.setUrl(vaUrl);

                    vacancyList.add(newVacancy);
                }
                page++;
            } else {
                break;
            }
        }

        return vacancyList;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        Document document = null;
        String url = String.format(URL_FORMAT,searchString,page);
        document = Jsoup.connect(url)
                .referrer("https://hh.ua/")
                .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.97 Safari/537.36")
                .get();
        return document;
    }

}
