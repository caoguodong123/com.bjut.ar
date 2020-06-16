package com.bjut.ar.dao;

import com.bjut.ar.bean.Site;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

public interface SiteDao {
    public Site getSiteById(@Param("id") Integer id);

    public Collection<Site> getAllSite_user();

    public List<Site> getAllSite();

    public boolean updateSite(Site site);

    public boolean deleteSiteById(Integer id);

    public boolean insertSite(Site site);
}
