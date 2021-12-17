package com.java.web.service.pages.service;

import com.java.web.service.pages.model.PageModel;
import com.java.web.service.pages.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DbPageService implements PageService {

    @Autowired
    private PageRepository repository;

    @Override
    public void create(PageModel pageModel) {
        repository.save(pageModel);
    }

    @Override
    public PageModel read(String slug) {
        return repository.getById(slug);
    }

    @Override
    public List<PageModel> readAll() {
        return repository.findAll();
    }

    @Override
    public List<PageModel> getByPriorityAscending() {
        return repository.getByPriorityAscending();
    }

    @Override
    public List<PageModel> getByPriority() {
        return repository.getByPriority();
    }

    @Override
    public boolean update(PageModel pageModel, String slug) {
        if (repository.existsById(slug)) {
            pageModel.setSlug(slug);
            repository.save(pageModel);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String slug) {
        if (repository.existsById(slug)) {
            repository.deleteById(slug);
            return true;
        }
        return false;
    }
}
