package com.zj.bloggradle.domain.es;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * Blog 文档
 *
 * @author 周杰
 * @date 2018/12/17
 */
@Document(indexName = "blog", type = "blog")
public class EsBlog implements Serializable {

    @Id
    private String id;
    // 文章
    private String title;
    // 摘要
    private String summary;
    // 内容
    private String content;

    // 无参构造函数——JPA规范要求，防止直接使用
    protected EsBlog() {

    }

    public EsBlog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("EsBlog[id='%s',summary='%s',title='%s',contend='%s']", id, title, summary, content);
    }
}
