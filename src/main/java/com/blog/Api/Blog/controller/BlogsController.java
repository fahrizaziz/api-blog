package com.blog.Api.Blog.controller;

import com.blog.Api.Blog.model.Blogs;
import com.blog.Api.Blog.model.InputDto;
import com.blog.Api.Blog.repo.BlogRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
public class BlogsController {
    private final BlogRepository blogRepository;


    @PostMapping("/create")
    private ResponseEntity<Blogs> addPosts(@RequestBody Blogs blogs) {
        blogRepository.save(blogs);
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/{id}") public ResponseEntity<Blogs> getBlogPostById(@PathVariable Long id) {
        Optional<Blogs> blogPostOptional = blogRepository.findById(id);
        return blogPostOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/upcontents/{id}") public ResponseEntity<Blogs> updateBlogPost(@PathVariable Long id, @RequestBody Blogs updatedPost) {
        if (!blogRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedPost.setId(id);
        Blogs savedPost = blogRepository.save(updatedPost); return ResponseEntity.ok(savedPost);
    }

    @DeleteMapping("/delcontents/{id}") public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        if (!blogRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        blogRepository.deleteById(id); return ResponseEntity.noContent().build();
    }

    @GetMapping("/filter")
    private ResponseEntity<List<Blogs>> filterPosts(@RequestParam(name = "sortType") String sortType) {
        List<Blogs> blogs = blogRepository.sort(Sort.by(sortType));
        return ResponseEntity.ok(blogs);
    }

    @GetMapping("/pagination")
    private ResponseEntity<Page<Blogs>> pagination(@RequestParam(name = "page_number") int pageNumber, @RequestParam(name = "size") int size) {

        Page<Blogs> blogs = blogRepository.findAllPerPage(PageRequest.of(pageNumber, size, Sort.by("id")));
        return ResponseEntity.ok(blogs);
    }
}
