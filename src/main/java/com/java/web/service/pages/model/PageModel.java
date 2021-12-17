package com.java.web.service.pages.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "pages")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PageModel {

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

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @Column(name = "priority")
    private int priority;

    public PageModel(String title, String description, String slug, String menuLabel, String h1, String content, LocalDateTime publishedAt, int priority) {
        this.title = title;
        this.description = description;
        this.slug = slug;
        this.menuLabel = menuLabel;
        this.h1 = h1;
        this.content = content;
        this.publishedAt = publishedAt;
        this.priority = priority;
    }

    public PageModel() {

    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSlug() {
        return slug;
    }

    public String getMenuLabel() {
        return menuLabel;
    }

    public String getH1() {
        return h1;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublishedAt() {
        return publishedAt;
    }

    public int getPriority() {
        return priority;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setMenuLabel(String menuLabel) {
        this.menuLabel = menuLabel;
    }

    public void setH1(String h1) {
        this.h1 = h1;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublishedAt(LocalDateTime publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", slug='" + slug + '\'' +
                ", menuLabel='" + menuLabel + '\'' +
                ", h1='" + h1 + '\'' +
                ", content='" + content + '\'' +
                ", publishedAt=" + publishedAt +
                ", priority=" + priority +
                '}';
    }

}
