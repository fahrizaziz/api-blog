package com.blog.Api.Blog.repo;

import com.blog.Api.Blog.model.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blogs, Long> {

    @Query("select b from Blogs b")
    List<Blogs> sort(Sort sort);

    @Query(value = "select b.* from contents b",
            countQuery = "select count(b.*) from contents b",
            nativeQuery = true)
    Page<Blogs> findAllPerPage(Pageable pageable);
}
