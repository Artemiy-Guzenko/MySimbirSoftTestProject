package ru.guzenko.test.service;

import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.guzenko.test.model.Url;
import ru.guzenko.test.repository.UrlDao;

import javax.transaction.Transactional;
import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UrlServiceImpl implements UrlService {

    private UrlDao urlDao;

    private static File file;

    private static final Logger logger = LoggerFactory.getLogger(UrlServiceImpl.class);

    public void setUrlRepository(UrlDao urlDao) {
        this.urlDao = urlDao;
    }

    @Override
    @Transactional
    public Map<String, Integer> addWords(Url url) {
        file = new File("C:\\IDEA projects\\Test.html");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Map<String, Integer> uniqueWords = new HashMap<>();

        try {
            download(url.getPath());
            String resultLine = readLine(file);
            uniqueWords = getUniqueWordsEntriesAsMap(resultLine);
            //запись в бд

            for (Map.Entry entry : uniqueWords.entrySet()) {
                System.out.println("sd");
                Url urlToBePersist = new Url(url.getPath(), (String) entry.getKey(), (Integer) entry.getValue());
                System.out.printf("sd");
                urlDao.addWords(urlToBePersist);
            }

        } catch (IOException e) {
            e.printStackTrace();
            logger.error("IOException", e);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Unknown error", e);
        }
        return uniqueWords;
    }

    @Override
    public List<Url> listAllUrls() {
        return urlDao.listAllUrls();
    }


    private static void download(String url1) throws IOException {

        //метод скачивает сраницу по заданному URL на диск

        FileWriter writer = new FileWriter(file);
        URL url = new URL(url1);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openConnection().getInputStream(), "UTF-8"));
        while (true) {
            String line = reader.readLine();
            if (line == null)
                break;
            writer.write(line);
        }
        reader.close();
        writer.close();
    }

    private static String readLine(File file) throws IOException {

        //метод выделяет из html файла отображающийся на странице текст и возвращает в виде строки

        String htmlLine;
        String resultLine;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            htmlLine = sb.toString();
        }

        resultLine = html2text(htmlLine).toLowerCase().replaceAll("[^A-Za-zА-Яа-я]", " ").replaceAll("\\s+", " ");
        return resultLine;
    }

    private static String html2text(String html) {
        return Jsoup.parse(html).text();
    }

    private static Map<String, Integer> getUniqueWordsEntriesAsMap(String line) {

        //метод создаем мапу на основе уникальности слов в строке

        Map<String, Integer> hashMap = new HashMap();
        for (String string : line.split(" ")) {
            if (hashMap.get(string) == null)
                hashMap.put(string, 1);
            else
                hashMap.put(string, hashMap.get(string) + 1);
        }

        for (Map.Entry<String, Integer> pair : hashMap.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
        return hashMap;
    }

}
