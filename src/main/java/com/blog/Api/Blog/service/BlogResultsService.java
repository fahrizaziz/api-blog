package com.blog.Api.Blog.service;

import com.blog.Api.Blog.model.Blogs;
import com.blog.Api.Blog.repo.BlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class BlogResultsService {
    private final BlogRepository blogRepository;

    public BlogResultsService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Page<Blogs> getBlogsPagination(int page, int perPage) {
        return blogRepository.findAll(PageRequest.of(page, perPage));
    }
}
