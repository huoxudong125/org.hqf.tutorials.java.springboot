package org.hqf.tutorials.java.springboot;


import org.hqf.tutorials.java.springboot.pojo.Blog;
import org.hqf.tutorials.java.springboot.repository.BlogRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@ActiveProfiles("hsqldb")
@DataJpaTest
public class BlogRepositoryTest {

    @Resource
    private BlogRepository blogRepository;

    /**
     * 测试新增博客的情况.
     */
    @Test
    public void save() {
        String id = "newblogId";
        String title = "Java 从入门到放弃";
        blogRepository.save(new Blog().setId(id).setTitle(title));

        Optional<Blog> blogOptional = blogRepository.findById(id);
        Assert.assertTrue(blogOptional.isPresent() && title.equals(blogOptional.get().getTitle()));
    }

    /**
     * 测试查询所有 Spring 相关的博客信息.
     */
    @Test
    public void querySpringBlogs() {
        List<Blog> blogs = blogRepository.querySpringBlogs();
        Assert.assertEquals(1, blogs.size());
        Assert.assertEquals("Spring从入门到精通", blogs.get(0).getTitle());
    }

}