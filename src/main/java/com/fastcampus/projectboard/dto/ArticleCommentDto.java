package com.fastcampus.projectboard.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.fastcampus.projectboard.domain.ArticleComment}
 */
public record ArticleCommentDto(
        LocalDateTime createdAt,
        String createdBy,
        String content
) {
    public ArticleCommentDto of(LocalDateTime createdAt, String createdBy, String content) {
        return new ArticleCommentDto(createdAt, createdBy, content);
    }
}