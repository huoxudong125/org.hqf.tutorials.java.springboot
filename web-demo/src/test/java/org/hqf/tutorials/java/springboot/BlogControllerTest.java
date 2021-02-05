package org.hqf.tutorials.java.springboot;

import java.util.ArrayList;
import javax.annotation.Resource;

import org.hqf.tutorials.java.springboot.service.BlogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * BlogControllerTest.
 *
 * @author blinkfox on 2019-03-02.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(BlogController.class)
public class BlogControllerTest {

    @Resource
    private MockMvc mockMvc;

    @MockBean
    private BlogService blogService;

    /**
     * 测试获取所有 Spring 相关的博客信息.
     *
     * @throws Exception 异常
     */
    @Test
    public void getSpringBlogs() throws Exception {
        Mockito.when(blogService.getSpringBlogs())
                .thenReturn(new ArrayList<>());

        this.mockMvc.perform(get("/blogs"))
                .andExpect(status().isOk());
    }

    /**
     * 测试修改博客标题成功时的情况.
     *
     * @throws Exception 异常
     */
    @Test
    public void modifyTitileById() throws Exception {
        Mockito.doNothing()
                .when(blogService).modifyTitileById(Mockito.anyString(), Mockito.anyString());
        this.mockMvc.perform(patch("/blogs/1?title=Spring实战"))
                .andExpect(status().isOk());
    }

    /**
     * 测试修改博客标题失败时的情况.
     *
     * @throws Exception 异常
     */
    @Test
    public void modifyTitileByIdWithException() throws Exception {
        Mockito.doThrow(RuntimeException.class)
                .when(blogService).modifyTitileById(Mockito.anyString(), Mockito.anyString());
        this.mockMvc.perform(patch("/blogs/1?title=Spring实战"))
                .andExpect(status().is5xxServerError());
    }

}
