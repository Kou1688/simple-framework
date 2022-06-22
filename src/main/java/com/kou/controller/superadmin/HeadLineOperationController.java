package com.kou.controller.superadmin;

import com.kou.entity.bo.HeadLine;
import com.kou.entity.dto.Result;
import com.kou.service.solo.HeadLineService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 管理员管理头条controller
 *
 * @author KouChaoJie
 * @since: 2022/6/22 16:45
 */
public class HeadLineOperationController {

    private HeadLineService headLineService;

    /**
     * 添加头条
     */
    public Result<Boolean> addHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        //KouTODO:2022/6/22 16:50 Kou 请求参数校验与转化
        return headLineService.addHeadLine(null);
    }

    /**
     * 删除头条
     */
    Result<Boolean> removeHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        //KouTODO:2022/6/22 16:50 Kou 请求参数校验与转化
        return headLineService.removeHeadLine(null);
    }

    /**
     * 修改头条
     */
    Result<Boolean> modifyHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        //KouTODO:2022/6/22 16:50 Kou 请求参数校验与转化
        return headLineService.modifyHeadLine(null);
    }

    /**
     * 查询头条信息详情
     */
    Result<HeadLine> queryHeadLineById(HttpServletRequest req, HttpServletResponse resp) {
        //KouTODO:2022/6/22 16:50 Kou 请求参数校验与转化
        return headLineService.queryHeadLineById(null);
    }

    /**
     * 查询头条列表
     */
    Result<List<HeadLine>> queryHeadLine(HttpServletRequest req, HttpServletResponse resp) {
        //KouTODO:2022/6/22 16:50 Kou 请求参数校验与转化
        return headLineService.queryHeadLine(null, 1, 100);
    }
}
