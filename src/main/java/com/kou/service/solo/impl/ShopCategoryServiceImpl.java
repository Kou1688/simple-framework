package com.kou.service.solo.impl;

import com.kou.entity.bo.ShopCategory;
import com.kou.entity.dto.Result;
import com.kou.service.solo.ShopCategoryService;

import java.util.List;

/**
 * @author KouChaoJie
 * @since: 2022/6/22 15:06
 */
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Override
    public Result<Boolean> addShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<Boolean> removeShopCategory(Long shopCategoryId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyShopCategory(ShopCategory shopCategory) {
        return null;
    }

    @Override
    public Result<ShopCategory> queryShopCategoryById(Long shopCategoryId) {
        return null;
    }

    @Override
    public Result<List<ShopCategory>> queryShopCategory(ShopCategory shopCategoryCondition, int pageIndex, int pageSize) {
        return null;
    }
}
