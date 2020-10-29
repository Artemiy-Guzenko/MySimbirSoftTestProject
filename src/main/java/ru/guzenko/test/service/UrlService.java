package ru.guzenko.test.service;

import ru.guzenko.test.model.Url;

import java.util.List;
import java.util.Map;

public interface UrlService {

    public Map<String, Integer> addWords(Url url);

    public List<Url> listAllUrls();
}
