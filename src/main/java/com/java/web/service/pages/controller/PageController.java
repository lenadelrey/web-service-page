package com.java.web.service.pages.controller;

import com.java.web.service.pages.model.PageModel;
import com.java.web.service.pages.service.PageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/home")
public class PageController {

    private final PageService service;

    public PageController(PageService service) {
        this.service = service;
    }

    @GetMapping(value = "/createPage")
    public String create(Model model) {
        model.addAttribute("pageModel", new PageModel());
        return "createPage";
    }

    @PostMapping(value = "/createPage")
    public String create(@ModelAttribute(value = "pageModel") PageModel pageModel, Model model) {
        model.addAttribute("pageModel", pageModel);
        service.create(new PageModel(pageModel.getTitle(), pageModel.getDescription(),
                pageModel.getSlug(), pageModel.getMenuLabel(),
                pageModel.getH1(), pageModel.getContent(),
                LocalDateTime.now(), pageModel.getPriority()));
        return "redirect:/home/read/" + pageModel.getSlug();
    }

    @GetMapping(value = "/read/{slug}")
    public String read(@PathVariable(value = "slug") String slug, Model model) {
        model.addAttribute("page", service.read(slug));
        return "read";
    }

    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("pages", service.readAll());
        return "home";
    }

    @GetMapping(value = "/ascending")
    public String readAscending(Model model) {
        model.addAttribute("pages", service.getByPriorityAscending());
        return "home";
    }

    @GetMapping(value = "/descending")
    public String readDescending(Model model) {
        model.addAttribute("pages", service.getByPriority());
        return "home";
    }

    @GetMapping(value = "/updatePage/{slug}")
    public String update(@PathVariable(value = "slug") String slug, Model model) {
        model.addAttribute("pageModel", service.read(slug));
        return "updatePage";
    }

    @PostMapping(value = "/updatePage/{slug}")
    public String update(@ModelAttribute(value = "pageModel") PageModel pageModel, @PathVariable(value = "slug") String slug, Model model) {
        model.addAttribute("pageModel", pageModel);
        service.update(new PageModel(pageModel.getTitle(), pageModel.getDescription(),
                slug, "http://localhost:8080/home/read/" + slug,
                pageModel.getH1(), pageModel.getContent(), service.read(slug).getPublishedAt(),
                pageModel.getPriority()), slug);
        return "redirect:/home/read/" + slug;
    }

    @RequestMapping(method = {RequestMethod.DELETE, RequestMethod.POST}, value = "/deletePage/{slug}")
    public String delete(@PathVariable("slug") String slug) {
        service.delete(slug);
        return "redirect:/home";
    }

}
