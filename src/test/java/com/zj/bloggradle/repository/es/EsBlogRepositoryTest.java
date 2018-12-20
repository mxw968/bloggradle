package com.zj.bloggradle.repository.es;

import com.zj.bloggradle.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * EsBlog Repository接口测试
 *
 * @author 周杰
 * @date 2018/12/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {
    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData() {
        // 清除所有数据
        esBlogRepository.deleteAll();
        esBlogRepository.save(new EsBlog("登鹳雀楼", "王之涣", "白日依山尽"));
        esBlogRepository.save(new EsBlog("相思", "王维的相思", "白日依山尽"));
        esBlogRepository.save(new EsBlog("登鹳雀楼", "王之涣", "白日依山尽"));


    }

    @Test
    public void findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = new PageRequest(0, 20);
        String title = "思";
        String summary = "相思";
        String content = "白日";

        Page<EsBlog> esBlogs = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content,pageable);

        assertThat(esBlogs.getTotalElements()).isEqualTo(3);

        System.out.println("====start====");
        for (EsBlog esBlog : esBlogs.getContent()) {
            System.out.println(esBlog.toString());
        }
        System.out.println("====end====");
    }
}
