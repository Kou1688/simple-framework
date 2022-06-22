package com.kou.service.solo.impl;

import com.kou.entity.bo.HeadLine;
import com.kou.entity.dto.Result;
import com.kou.service.solo.HeadLineService;

import java.util.List;

/**
 * @author KouChaoJie
 * @since: 2022/6/22 15:05
 */
public class HeadLineServiceImpl implements HeadLineService {
    @Override
    public Result<Boolean> addHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<Boolean> removeHeadLine(Long headLineId) {
        return null;
    }

    @Override
    public Result<Boolean> modifyHeadLine(HeadLine headLine) {
        return null;
    }

    @Override
    public Result<HeadLine> queryHeadLineById(Long headLineId) {
        return null;
    }

    @Override
    public Result<List<HeadLine>> queryHeadLine(HeadLine headLineCondition, int pageIndex, int pageSize) {
        return null;
    }
}
