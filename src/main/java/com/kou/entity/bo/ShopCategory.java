package com.kou.entity.bo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Kou
 */
@Data
public class ShopCategory {
    private Long shopCategoryId;
    private String shopCategoryName;
    private String shopCategoryDesc;
    private String shopCategoryImg;
    private Integer priority;
    private LocalDateTime createTime;
    private LocalDateTime lastEditTime;
    private ShopCategory parent;
}
