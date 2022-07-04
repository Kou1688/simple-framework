package com.kou.service.combine.impl;

import com.kou.entity.bo.HeadLine;
import com.kou.entity.bo.ShopCategory;
import com.kou.entity.dto.MainPageInfoDTO;
import com.kou.entity.dto.Result;
import com.kou.service.combine.HeadLineShopCategoryService;
import com.kou.service.solo.HeadLineService;
import com.kou.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Service;

import java.util.List;

/**
 * @author KouChaoJie
 * @since: 2022/6/22 15:11
 */
@Service
public class HeadLineShopCategoryServiceImpl implements HeadLineShopCategoryService {
    private HeadLineService headLineService;

    private ShopCategoryService shopCategoryService;

    @Override
    public Result<MainPageInfoDTO> getMainPageInfo() {
        //1.获取头条列表
        HeadLine headLine = new HeadLine();
        headLine.setEnableStatus(1);
        Result<List<HeadLine>> queryHeadLine = headLineService.queryHeadLine(headLine, 1, 4);

        //2.获取店铺类别列表
        ShopCategory shopCategory = new ShopCategory();
        Result<List<ShopCategory>> queryShopCategory = shopCategoryService.queryShopCategory(shopCategory, 1, 100);

        //3.合并两者返回
        return merge(queryHeadLine, queryShopCategory);
    }

    /**
     * 合并首页查询结果
     *
     * @param queryHeadLine
     * @param queryShopCategory
     * @return
     */
    private Result<MainPageInfoDTO> merge(Result<List<HeadLine>> queryHeadLine, Result<List<ShopCategory>> queryShopCategory) {
        return null;
    }
}
