package com.zj.bloggradle.repository.es;

import com.zj.bloggradle.domain.es.EsBlog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * EsBlog Repository接口
 *
 * @author 周杰
 * @date 2018/12/17
 */
public interface EsBlogRepository extends ElasticsearchRepository<EsBlog, String> {
    
    /**
     * 分页查询博客（去重）
     * @param title 标题
     * @param summary 摘要
     * @param content 内容
     * @return
     *
     * @author 周杰
     * @date 2018/12/17
     */
    Page<EsBlog> findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
