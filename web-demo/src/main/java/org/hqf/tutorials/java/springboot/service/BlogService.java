package org.hqf.tutorials.java.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.hqf.tutorials.java.springboot.pojo.Blog;
import org.hqf.tutorials.java.springboot.repository.BlogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BlogService {

    @Resource
    private BlogRepository blogRepository;

    /**
     * 查询所有 Spring 相关的博客信息.
     *
     * @return 博客信息
     */
    public List<Blog> getSpringBlogs() {
        log.info("进入了获取 Spring 相关博客的 Service 方法.");
        return blogRepository.querySpringBlogs();
    }

    /**
     * 根据博客ID来修改该博客的名称.
     *
     * @param id 博客ID
     * @param title 博客标题
     */
    public void modifyTitileById(String id, String title) {
        Optional<Blog> blogOptional = blogRepository.findById(id);
        if (!blogOptional.isPresent()) {
            log.warn("需要修改名称的博客不存在，id为【{}】请检查！", id);
            return;
        }

        blogRepository.save(blogOptional.get().setTitle(title));
    }

}