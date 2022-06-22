package com.kou.controller.frontend;

import com.kou.entity.dto.MainPageInfoDTO;
import com.kou.entity.dto.Result;
import com.kou.service.combine.HeadLineShopCategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页controller
 *
 * @author KouChaoJie
 * @since: 2022/6/22 16:42
 */
public class MainPageController {
    private HeadLineShopCategoryService headLineShopCategoryService;

    public Result<MainPageInfoDTO> getMainPageInfo(HttpServletRequest req, HttpServletResponse resp) {
        return headLineShopCategoryService.getMainPageInfo();
    }
}
