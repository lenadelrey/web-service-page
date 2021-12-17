package com.java.web.service.pages.controller;

import com.java.web.service.pages.model.DraftPageModel;
import com.java.web.service.pages.service.DraftPageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/drafts")
public class DraftPageController {

    private final DraftPageService draftPageService;

    public DraftPageController(DraftPageService draftPageService) {
        this.draftPageService = draftPageService;
    }

    @GetMapping(value = "/addToDrafts")
    public String addToDrafts(Model model) {
        model.addAttribute("pageModel", new DraftPageModel());
        return "createDraft";
    }

    @PostMapping(value = "/addToDrafts")
    public String create(@ModelAttribute(value = "pageModel") DraftPageModel pageModel, Model model) {
        model.addAttribute("pageModel", pageModel);
        draftPageService.create(new DraftPageModel(pageModel.getTitle(), pageModel.getDescription(),
                pageModel.getSlug(), pageModel.getMenuLabel(), pageModel.getH1(), pageModel.getContent(),
                pageModel.getPriority()));
        return "redirect:/drafts/read/" + pageModel.getSlug();
    }

    @GetMapping(value = "/read/{slug}")
    public String read(@PathVariable(value = "slug") String slug, Model model) {
        model.addAttribute("draft", draftPageService.read(slug));
        return "draftPage";
    }

    @GetMapping
    public String readAll(Model model) {
        model.addAttribute("drafts", draftPageService.readAll());
        return "drafts";
    }

    @GetMapping(value = "/updateDraft/{slug}")
    public String update(@PathVariable(value = "slug") String slug, Model model) {
        model.addAttribute("pageModel", draftPageService.read(slug));
        return "editDraft";
    }

    @PostMapping(value = "/updateDraft/{slug}")
    public String update(@ModelAttribute(value = "pageModel") DraftPageModel pageModel, @PathVariable(value = "slug") String slug, Model model) {
        model.addAttribute("pageModel", pageModel);
        draftPageService.publish(new DraftPageModel(pageModel.getTitle(), pageModel.getDescription(),
                slug, "http://localhost:8080/home/read/" + slug,
                pageModel.getH1(), pageModel.getContent(),
                pageModel.getPriority()));
        return "redirect:/home/read/" + slug;
    }

    @RequestMapping(method = {RequestMethod.DELETE, RequestMethod.POST}, value = "/deleteDraft/{slug}")
    public String delete(@PathVariable("slug") String slug) {
        draftPageService.delete(slug);
        return "redirect:/drafts";
    }

}
