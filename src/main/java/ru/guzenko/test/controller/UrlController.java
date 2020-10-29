package ru.guzenko.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.guzenko.test.model.Url;
import ru.guzenko.test.service.UrlService;

@Controller
public class UrlController {

    private UrlService urlService;

    @Autowired
    public void setUrlService(UrlService urlService) {
        this.urlService = urlService;
    }

    @RequestMapping(value = "/dataBase", method = RequestMethod.GET)
    public String listAllUrls(Model model) {
        model.addAttribute("listAllUrls", urlService.listAllUrls());

        return "dataBase";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String addWords(@RequestParam(value = "url", required = false) String urlPath, Model model) {

        Url url = new Url(urlPath);
        model.addAttribute("resultMap", urlService.addWords(url));
        model.addAttribute("url", url);

        return "result";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String basePage() {
        return "index";
    }
}
