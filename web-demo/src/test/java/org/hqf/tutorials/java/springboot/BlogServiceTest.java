package org.hqf.tutorials.java.springboot;

import org.hqf.tutorials.java.springboot.pojo.Blog;
import org.hqf.tutorials.java.springboot.repository.BlogRepository;
import org.hqf.tutorials.java.springboot.service.BlogService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BlogServiceTest {

    @Mock
    private BlogRepository blogRepository;

    @InjectMocks
    private BlogService blogService;

    /**
     * 测试service层中获取Spring相关博客的方法.
     */
    @Test
    public void getSpringBlogs() {
        // 构造需要返回的博客信息集合数据.
        Blog blog = new Blog()
                .setId("1")
                .setTitle("Spring Action");
        List<Blog> blogList = new ArrayList<>();
        blogList.add(blog);

        Mockito.when(blogRepository.querySpringBlogs())
                .thenReturn(blogList);
        List<Blog> blogs = blogService.getSpringBlogs();

        // 断言验证查询到的数据.
        Assert.assertEquals(1, blogs.size());
        Assert.assertEquals("Spring Action", blog.getTitle());
    }

    /**
     * 测试根据博客ID来修改该博客的名称成功时的情况.
     */
    @Test
    public void modifyTitleById() {
        // Mock 相关数据和类方法的行为.
        String id = "1";
        Mockito.when(blogRepository.findById(id))
                .thenReturn(Optional.of(new Blog()));
        Mockito.when(blogRepository.save(Mockito.any()))
                .thenReturn(new Blog());

        blogService.modifyTitileById(id, "算法导论");

        // 验证 blogRepository.save(s) 方法被调用过一次.
        Mockito.verify(blogRepository).save(Mockito.any());
    }

    /**
     * 测试根据博客ID来修改该博客的名称失败时的情况.
     */
    @Test
    public void modifyTitleByIdWithFailure() {
        // Mock 未根据 ID 找到对应的博客信息的情况.
        String id = "1";
        Mockito.when(blogRepository.findById(id))
                .thenReturn(Optional.ofNullable(null));

        blogService.modifyTitileById(id, "算法导论");

        // 验证 blogRepository.save(s) 方法并没有被调用过.
        Mockito.verify(blogRepository, Mockito.never()).save(Mockito.any());
    }

}
