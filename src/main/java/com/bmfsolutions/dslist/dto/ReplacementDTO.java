package com.bmfsolutions.dslist.dto;

public class ReplacementDTO {

    private Integer sourceIdx;
    private Integer targetIdx;

    public ReplacementDTO(Integer sourceIdx, Integer targetIdx) {
        this.sourceIdx = sourceIdx;
        this.targetIdx = targetIdx;
    }

    public Integer getSourceIdx() {
        return sourceIdx;
    }

    public void setSourceIdx(Integer sourceIdx) {
        this.sourceIdx = sourceIdx;
    }

    public Integer getTargetIdx() {
        return targetIdx;
    }

    public void setTargetIdx(Integer targetIdx) {
        this.targetIdx = targetIdx;
    }
}
