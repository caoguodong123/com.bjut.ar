package com.bjut.ar.service.impl;

import com.bjut.ar.bean.Site;
import com.bjut.ar.dao.SiteDao;
import com.bjut.ar.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    private SiteDao sd;

    @Override
    public Site getSiteById(Integer id) {
        return sd.getSiteById(id);
    }

    @Override
    public List<Site> getAllSite() {
        return sd.getAllSite();
    }

    @Override
    public boolean editSite(Site site) {
        System.out.println(site);
        return sd.updateSite(site);
    }

    @Override
    public boolean deleteSiteById(Integer id) {
        return sd.deleteSiteById(id);
    }

    @Override
    public boolean addSite(Site site) {
        return sd.insertSite(site);
    }
}
