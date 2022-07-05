package com.kou.controller.superadmin;

import com.kou.entity.bo.ShopCategory;
import com.kou.entity.dto.Result;
import com.kou.service.solo.ShopCategoryService;
import org.simpleframework.core.annotation.Controller;
import org.simpleframework.inject.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 管理员管理店铺controller
 *
 * @author KouChaoJie
 * @since: 2022/6/22 16:52
 */
@Controller
public class ShopCategoryOperationController {

    @Autowired
    private ShopCategoryService shopCategoryService;

    /**
     * 添加店铺类别
     */
    public Result<Boolean> addShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    /**
     * 删除店铺类别
     */
    public Result<Boolean> removeShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    /**
     * 修改店铺类别
     */
    public Result<Boolean> modifyShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    /**
     * 查询店铺类别信息详情
     */
    public Result<ShopCategory> queryShopCategoryById(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }

    /**
     * 查询店铺类别列表
     */
    public Result<List<ShopCategory>> queryShopCategory(HttpServletRequest req, HttpServletResponse resp) {
        return null;
    }
}
