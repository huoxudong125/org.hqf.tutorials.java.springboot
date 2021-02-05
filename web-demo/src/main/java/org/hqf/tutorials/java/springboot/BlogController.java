package org.hqf.tutorials.java.springboot;

import java.util.List;
import javax.annotation.Resource;

import lombok.extern.slf4j.Slf4j;

import org.hqf.tutorials.java.springboot.pojo.Blog;
import org.hqf.tutorials.java.springboot.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * BlogController.
 *
 */
@Slf4j
@RequestMapping("/blogs")
@RestController
public class BlogController {

    @Resource
    private BlogService blogService;

    /**
     * 获取所有 Spring 相关的博客信息.
     *
     * @return Spring相关的博客信息
     */
    @GetMapping
    public ResponseEntity<List<Blog>> getSpringBlogs() {
        return ResponseEntity.ok(blogService.getSpringBlogs());
    }

    /**
     * 根据博客ID修改博客名称.
     *
     * @param id 博客ID
     * @param title 博客标题
     * @return 空
     */
    @PatchMapping("/{id}")
    public ResponseEntity<Void> modifyTitileById(@PathVariable("id") String id,
                                                 @RequestParam("title") String title) {
        try {
            blogService.modifyTitileById(id, title);
            log.info("修改博客名称成功.");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            log.error("修改博客名称出错，id为【{}】.", id);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
