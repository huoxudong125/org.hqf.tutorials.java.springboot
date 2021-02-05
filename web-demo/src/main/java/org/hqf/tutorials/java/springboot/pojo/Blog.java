package org.hqf.tutorials.java.springboot.pojo;



import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 博客实体.
 *
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "t_test_blog", schema = "test")
public class Blog {

    /**
     * ID.
     */
    @Id
    @Column(name = "c_id")
    private String id;

    /**
     * 作者.
     */
    @Column(name = "c_author")
    private String author;

    /**
     * 标题.
     */
    @Column(name = "c_title")
    private String title;

    /**
     * 内容.
     */
    @Column(name = "c_content")
    private String content;

    /**
     * 发布时间.
     */
    @Column(name = "dt_publish_time")
    private Date publishTime;

    /**
     * 链接地址.
     */
    @Column(name = "c_url")
    private String url;

    /**
     * 状态.
     */
    @Column(name = "n_status")
    private Integer status;

    /**
     * 创建用户.
     */
    @Column(name = "c_create_user")
    private String createUser;

    /**
     * 创建时间.
     */
    @Column(name = "dt_create_time")
    private Date createTime;

    /**
     * 最后更新时间.
     */
    @Column(name = "dt_update_time")
    private Date updateTime;

}
