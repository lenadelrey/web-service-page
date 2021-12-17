package com.java.web.service.pages.service;

import com.java.web.service.pages.model.DraftPageModel;

import java.util.List;

public interface DraftPageService {

    void create(DraftPageModel pageModel);

    DraftPageModel read(String slug);

    List<DraftPageModel> readAll();

    boolean update(DraftPageModel pageModel, String slug);

    boolean delete(String slug);

    void publish(DraftPageModel pageModel);

}
