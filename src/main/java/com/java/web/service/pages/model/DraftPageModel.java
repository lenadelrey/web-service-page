package com.java.web.service.pages.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drafts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DraftPageModel {

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Id
    @Column(name = "slug")
    private String slug;

    @Column(name = "menu_label")
    private String menuLabel;

    @Column(name = "h1")
    private String h1;

    @Column(name = "content")
    private String content;

    @Column(name = "priority")
    private int priority;

    public DraftPageModel(String title, String description, String slug, String menuLabel, String h1, String content, int priority) {
        this.title = title;
        this.description = description;
        this.slug = slug;
        this.menuLabel = menuLabel;
        this.h1 = h1;
        this.content = content;
        this.priority = priority;
    }

    public DraftPageModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getMenuLabel() {
        return menuLabel;
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel;
    }

    public String getH1() {
        return h1;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
