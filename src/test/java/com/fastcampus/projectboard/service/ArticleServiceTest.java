package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.type.SearchType;
import com.fastcampus.projectboard.dto.ArticleDto;
import com.fastcampus.projectboard.dto.ArticleUpdateDto;
import com.fastcampus.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("비즈니스 로직 - 게시판, 게시글")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut;

    @Mock
    private ArticleRepository articleRepository;

    /**
     * - 검색
     * - 각 게시글 페이지로 이동
     * - 페이지네이션
     * - 홈 버튼 -> 게시판 페이지로 리다이렉션
     * - 정렬 기능
     */
    @DisplayName("게시판 목록조회 테스트")
    @Test
    public void ArticleListSearchTest() {
        // given

        // when
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword");

        // then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글 검색 테스트")
    @Test
    public void ArticleSearchTest() {
        // given

        // when
        ArticleDto article = sut.searchArticle(1);

        // then
        assertThat(article).isNotNull();
    }

    @DisplayName("게시글 생성 테스트")
    @Test
    public void ArticleCreateTest() {
        // given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        sut.saveArticle(ArticleDto.of(LocalDateTime.now(),
                "uknow",
                "title",
                "content",
                "hashtag"));

        // then
        then(articleRepository).should().save(any(Article.class));

    }

    @DisplayName("게시글 수정 테스트")
    @Test
    public void ArticleUpdateTest() {
        // given
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        sut.updateArticle(1, ArticleUpdateDto.of(
                "title",
                "content",
                "hashtag"));

        // then
        then(articleRepository).should().save(any(Article.class));

    }

    @DisplayName("게시글 삭제 테스트")
    @Test
    public void ArticleDeleteTest() {
        // given
        willDoNothing().given(articleRepository).delete(any(Article.class));

        // when
        sut.deleteArticle(1);

        // then
        then(articleRepository).should().save(any(Article.class));

    }


}