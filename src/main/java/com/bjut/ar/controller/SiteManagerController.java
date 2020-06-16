package com.bjut.ar.controller;

import com.bjut.ar.bean.Site;
import com.bjut.ar.bean.User;
import com.bjut.ar.service.SiteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/site_manager")
public class SiteManagerController {
    @Autowired
    private SiteService ss;

    @RequestMapping("/toSiteManager")
    public String showAllSite(@RequestParam(value = "pn", defaultValue = "1", required = false) Integer pn,
                              Model model) {
        PageHelper.startPage(pn, 4);
        List<Site> sites = ss.getAllSite();

        PageInfo<Site> info = new PageInfo<>(sites, 5);
        model.addAttribute("info", info);
        return "site_manager";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Integer id, Integer pn,
                         @RequestParam(value = "flag", required = false, defaultValue = "1") Integer flag,
                         @RequestParam(value = "condition", required = false, defaultValue = "") String condition,
                         Model model) {
        Site site = ss.getSiteById(id);
        model.addAttribute("site_edit", site);
        model.addAttribute("pn", pn);
        model.addAttribute("flag", flag);
        model.addAttribute("condition", condition);
        return "site_edit";
    }

    @RequestMapping("/edit")
    public String edit(Site site, Integer pn, Integer flag,
                       @RequestParam(value = "condition", required = false, defaultValue = "") String condition) {
        System.out.println("****************");
        System.out.println(site);
        System.out.println("***final****");
        ss.editSite(site);
        System.out.println(flag);
        System.out.println(condition);
        if (flag == 1)
            return "forward:/site_manager/toSiteManager";
        else
            return "forward:/user_manager/getUserByName";
    }

    @RequestMapping("/delete")
    public String delete(Integer id, Integer pn,
                         @RequestParam(value = "flag", required = false, defaultValue = "1") Integer flag,
                         @RequestParam(value = "condition", required = false, defaultValue = "") String condition) {
        ss.deleteSiteById(id);
        if (flag == 1)
            return "forward:/site_manager/toSiteManager";
        else
            return "forward:/site_manager/getUserByName";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "site_add";
    }

    @RequestMapping("/add")
    public String add(Site site) {
        System.out.println("safasdfasdfsdfasfsadfsad");
        ss.addSite(site);
        List<Site> sites = ss.getAllSite();
        Integer pn;
        if (sites.size() % 4 == 0) {
            pn = sites.size() / 4;
        } else {
            pn = sites.size() / 4 + 1;
        }
        return "forward:/site_manager/toSiteManager?pn=" + pn;
    }
}
