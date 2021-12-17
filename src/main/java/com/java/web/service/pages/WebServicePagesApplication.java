package com.java.web.service.pages;

import com.java.web.service.pages.service.DbDraftPageService;
import com.java.web.service.pages.service.DbPageService;
import com.java.web.service.pages.service.DraftPageService;
import com.java.web.service.pages.service.PageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebServicePagesApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebServicePagesApplication.class, args);
    }

    @Bean
    public PageService service() {
        return new DbPageService();
    }

    @Bean
    public DraftPageService draftPageService() {
        return new DbDraftPageService();
    }

}
