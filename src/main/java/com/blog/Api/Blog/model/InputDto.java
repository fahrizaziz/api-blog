package com.blog.Api.Blog.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InputDto {
    private Integer page;
    private Integer perPage;

    public Pageable getPageable() {
        return  PageRequest.of(page, perPage);
    }
}
