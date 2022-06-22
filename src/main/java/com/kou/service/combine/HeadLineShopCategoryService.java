package com.kou.service.combine;

import com.kou.entity.dto.MainPageInfoDTO;
import com.kou.entity.dto.Result;

/**
 * @author KouChaoJie
 * @since: 2022/6/22 15:07
 */
public interface HeadLineShopCategoryService {
    /**
     * 获取首页信息
     *
     * @return
     */
    Result<MainPageInfoDTO> getMainPageInfo();
}
