package com.java.web.service.pages.service;

import com.java.web.service.pages.model.DraftPageModel;
import com.java.web.service.pages.model.PageModel;
import com.java.web.service.pages.repository.DraftPageRepository;
import com.java.web.service.pages.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

public class DbDraftPageService implements DraftPageService {

    @Autowired
    private DraftPageRepository draftPageRepository;

    @Autowired
    private PageRepository pageRepository;

    @Override
    public void create(DraftPageModel pageModel) {
        draftPageRepository.save(pageModel);
    }

    @Override
    public DraftPageModel read(String slug) {
        return draftPageRepository.getById(slug);
    }

    @Override
    public List<DraftPageModel> readAll() {
        return draftPageRepository.findAll();
    }

    @Override
    public boolean update(DraftPageModel pageModel, String slug) {
        if (draftPageRepository.existsById(slug)) {
            pageModel.setSlug(slug);
            draftPageRepository.save(pageModel);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String slug) {
        if (draftPageRepository.existsById(slug)) {
            draftPageRepository.deleteById(slug);
            return true;
        }
        return false;
    }

    @Override
    public void publish(DraftPageModel pageModel) {
        if (draftPageRepository.existsById(pageModel.getSlug())) {
            pageRepository.save(new PageModel(pageModel.getTitle(), pageModel.getDescription(),
                    pageModel.getSlug(), pageModel.getMenuLabel(), pageModel.getH1(),
                    pageModel.getContent(), LocalDateTime.now(), pageModel.getPriority()));
            draftPageRepository.delete(pageModel);
        }
    }
}
