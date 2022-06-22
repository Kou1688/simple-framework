package com.kou.entity.dto;

import lombok.Data;

/**
 * 返回结果类
 *
 * @author KouChaoJie
 * @since: 2022/6/22 14:52
 */
@Data
public class Result<T> {
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回结果
     */
    private T data;
}
