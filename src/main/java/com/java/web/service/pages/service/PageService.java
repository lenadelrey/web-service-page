package com.java.web.service.pages.service;

import com.java.web.service.pages.model.PageModel;

import java.util.List;

public interface PageService {

    void create(PageModel pageModel);

    PageModel read(String slug);

    List<PageModel> readAll();

    boolean update(PageModel pageModel, String slug);

    boolean delete(String slug);

    List<PageModel> getByPriorityAscending();

    List<PageModel> getByPriority();

}
