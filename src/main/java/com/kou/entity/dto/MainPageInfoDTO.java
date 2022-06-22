package com.kou.entity.dto;

import com.kou.entity.bo.HeadLine;
import com.kou.entity.bo.ShopCategory;
import lombok.Data;

import java.util.List;

/**
 * 首页信息数据传输对象
 *
 * @author KouChaoJie
 * @since: 2022/6/22 15:08
 */
@Data
public class MainPageInfoDTO {
    /**
     * 首页头条信息
     */
    private List<HeadLine> headLineList;

    /**
     * 首页店铺类别信息
     */
    private List<ShopCategory> shopCategoryList;
}
