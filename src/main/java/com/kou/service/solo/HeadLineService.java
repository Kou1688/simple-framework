package com.kou.service.solo;

import com.kou.entity.bo.HeadLine;
import com.kou.entity.dto.Result;

import java.util.List;

/**
 * 头条service接口
 *
 * @author KouChaoJie
 * @since: 2022/6/22 14:55
 */
public interface HeadLineService {
    /**
     * 添加头条
     *
     * @param headLine
     * @return
     */
    Result<Boolean> addHeadLine(HeadLine headLine);

    /**
     * 删除头条
     *
     * @param headLineId
     * @return
     */
    Result<Boolean> removeHeadLine(Long headLineId);

    /**
     * 修改头条
     *
     * @param headLine
     * @return
     */
    Result<Boolean> modifyHeadLine(HeadLine headLine);

    /**
     * 查询头条信息详情
     *
     * @param headLineId
     * @return
     */
    Result<HeadLine> queryHeadLineById(Long headLineId);

    /**
     * 查询头条列表
     *
     * @param headLineCondition
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize);
}
