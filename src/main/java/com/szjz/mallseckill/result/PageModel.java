package com.szjz.mallseckill.result;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * author:szjz
 * date:2019/6/13
 * <p>
 * 分页模型
 */

@Data
public class PageModel<T> {

    /**
     * 总个数
     */
    private Long totalCount;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 每页容量
     */
    private Integer pageSize;

    /**
     * 当前页
     */
    private Integer pageNum;

    /**
     * 每页内容
     */
    private List<T> rows;

    /**
     * 第一页
     */
    private Boolean isFirst;

    /**
     * 最后一页
     */
    private Boolean isLast;

    public PageModel() {
    }

    public static PageModel buildPage(Page page) {
        PageModel pageModel = new PageModel();
        pageModel.setTotalCount(page.getTotalElements());
        pageModel.setTotalPage(page.getTotalPages());
        pageModel.setPageSize(page.getSize());
        pageModel.setRows(page.getContent());
        pageModel.setIsFirst(page.isFirst());
        pageModel.setIsLast(page.isLast());
        pageModel.setPageNum(page.getNumber());
        return pageModel;
    }
}
