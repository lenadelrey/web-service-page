package com.java.web.service.pages.repository;

import com.java.web.service.pages.model.DraftPageModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DraftPageRepository extends JpaRepository<DraftPageModel, String> {
}
