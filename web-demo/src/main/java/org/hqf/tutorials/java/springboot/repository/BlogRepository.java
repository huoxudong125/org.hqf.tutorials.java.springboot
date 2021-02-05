package org.hqf.tutorials.java.springboot.repository;

import org.hqf.tutorials.java.springboot.pojo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * BlogRepository.
 *
 * @author blinkfox on 2019-02-27.
 */
@Repository
public interface BlogRepository extends JpaRepository<Blog, String> {

    @Query("SELECT b FROM Blog AS b WHERE b.title like 'Spring%'")
    List<Blog> querySpringBlogs();

}
