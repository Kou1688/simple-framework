package com.kou.service.solo;

import com.kou.entity.bo.ShopCategory;
import com.kou.entity.dto.Result;

import java.util.List;

/**
 * 店铺类别service接口
 *
 * @author KouChaoJie
 * @since: 2022/6/22 14:57
 */
public interface ShopCategoryService {
    /**
     * 添加店铺类别
     *
     * @param shopCategory
     * @return
     */
    Result<Boolean> addShopCategory(ShopCategory shopCategory);

    /**
     * 删除店铺类别
     *
     * @param shopCategoryId
     * @return
     */
    Result<Boolean> removeShopCategory(Long shopCategoryId);

    /**
     * 修改店铺类别
     *
     * @param shopCategory
     * @return
     */
    Result<Boolean> modifyShopCategory(ShopCategory shopCategory);

    /**
     * 查询店铺类别信息详情
     *
     * @param shopCategoryId
     * @return
     */
    Result<ShopCategory> queryShopCategoryById(Long shopCategoryId);

    /**
     * 查询店铺类别列表
     *
     * @param shopCategoryCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize);
}
