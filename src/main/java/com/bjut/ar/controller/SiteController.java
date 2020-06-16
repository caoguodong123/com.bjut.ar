package com.bjut.ar.controller;

import com.bjut.ar.bean.Site;
import com.bjut.ar.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/site")
public class SiteController {
    @Autowired
    private SiteService ss;

    @ResponseBody
    @RequestMapping("/getSiteById")
    public Collection<Site> getSiteById(@RequestParam(value = "id", required = false, defaultValue = "1") Integer id, Model model) {
        List<Site> list = new ArrayList<Site>();
        list.add(ss.getSiteById(id));
        Collection<Site> sites = list;
        return sites;
    }

    @ResponseBody
    @RequestMapping("/getAllSite")
    public Collection<Site> getAllSite() {

        return ss.getAllSite();
    }

    @ResponseBody
    @RequestMapping("/test")
    public String Test() {
        return "safa";
    }

}
