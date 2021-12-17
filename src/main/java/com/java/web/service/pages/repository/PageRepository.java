package com.java.web.service.pages.repository;

import com.java.web.service.pages.model.PageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PageRepository extends JpaRepository<PageModel, String> {

    @Query("select page from PageModel page order by page.priority asc")
    List<PageModel> getByPriorityAscending();

    @Query("select page from PageModel page order by page.priority desc")
    List<PageModel> getByPriority();

}
