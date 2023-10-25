package com.example.weblogin.domain.notice;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NoticeDto {
    private Long id;
    private String author;
    private String title;
    private String content;
    private Long imageId;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public Notice toEntity() {
        Notice build = Notice.builder()
                .id(id)
                .author(author)
                .title(title)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public NoticeDto(Long id, String author, String title, String content, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }
}
