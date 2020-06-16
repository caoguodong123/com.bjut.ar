package com.bjut.ar.service;

import com.bjut.ar.bean.Site;

import java.util.Collection;
import java.util.List;

public interface SiteService {
    public Site getSiteById(Integer id);

    public List<Site> getAllSite();

    public boolean editSite(Site site);

    public boolean deleteSiteById(Integer id);

    public boolean addSite(Site site);
}
