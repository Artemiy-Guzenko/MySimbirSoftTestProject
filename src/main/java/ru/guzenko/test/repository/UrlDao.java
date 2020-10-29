package ru.guzenko.test.repository;

import ru.guzenko.test.model.Url;

import java.util.List;

public interface UrlDao {

    public void addWords(Url url);

    public List<Url> listAllUrls();
}
