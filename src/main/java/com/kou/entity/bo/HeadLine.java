package com.kou.entity.bo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author KouChaoJie
 * @since: 2022/6/22 14:08
 */
@Data
public class HeadLine {
    private Long lineId;
    private String lineName;
    private String lineLink;
    private String lineImg;
    private Integer priority;
    private Integer enableStatus;
    private LocalDateTime createTime;
    private LocalDateTime lastEditTime;
}
