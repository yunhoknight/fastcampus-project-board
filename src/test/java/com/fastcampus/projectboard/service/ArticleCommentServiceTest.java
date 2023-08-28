package com.fastcampus.projectboard.service;

import com.fastcampus.projectboard.domain.Article;
import com.fastcampus.projectboard.domain.ArticleComment;
import com.fastcampus.projectboard.domain.type.SearchType;
import com.fastcampus.projectboard.dto.ArticleCommentDto;
import com.fastcampus.projectboard.dto.ArticleDto;
import com.fastcampus.projectboard.repository.ArticleCommentRepository;
import com.fastcampus.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
public class ArticleCommentServiceTest {

    @InjectMocks
    private ArticleCommentService sut;

    @Mock
    private ArticleCommentRepository articleCommentRepository;

    @Mock
    private ArticleRepository articleRepository;



    @DisplayName("댓글 목록조회 테스트")
    @Test
    public void ArticleCommentListSearchTest() {
        // given
        Long articleId = 1L;
        given(articleRepository.findById(1L)).willReturn(Optional.of(Article.of("title", "content", "#java")));

        // when
        List<ArticleCommentDto> articleComments = sut.searchArticleComments(1L);

        // then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }
}
