package com.loeaf.board.model;

import lombok.Data;

@Data
public class PaginatorInfo {
    private Integer startPageNum;
    private Integer lastPageNum;
    private Integer previousPaging;
    private Integer nextPaging;
}
