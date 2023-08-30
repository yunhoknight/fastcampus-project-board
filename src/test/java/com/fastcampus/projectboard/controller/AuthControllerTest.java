package com.fastcampus.projectboard.controller;

import com.fastcampus.projectboard.config.SecurityConfig;
import com.fastcampus.projectboard.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@DisplayName("View 컨트롤러 테스트 - 인증")
@Import(SecurityConfig.class)
@WebMvcTest
public class AuthControllerTest {
    private final MockMvc mvc;

    @MockBean
    private ArticleService articleService;

    public AuthControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view] GET - 로그인 페이지")
    @Test
    public void LoginViewTest() throws Exception {
        // when & then
        mvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML));
    }
}
