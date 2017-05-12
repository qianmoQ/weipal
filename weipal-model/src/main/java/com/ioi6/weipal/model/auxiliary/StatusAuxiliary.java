package com.ioi6.weipal.model.auxiliary;

/**
 * status model
 * Created by shicheng on 2016/12/14.
 */
public enum StatusAuxiliary {

    SUCCESS("0000"),
    SUCCESS_MSG("success"),

    FAILURE("1111"),
    FAILURE_MSG("failure"),

    EMPTY("0001"), // 空状态吗
    EMPTY_MSG("data is empty"), // 空提示信息
    ;

    private String value;

    StatusAuxiliary(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

}
