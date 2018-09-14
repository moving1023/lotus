package org.liyl.lotus.exception;

/**
 * 枚举,响应吗描述
 * 创建日期：2017/3/23
 *
 * @author CAIJINDA.
 */
public enum ResultEnum {
    CODE_ERROR_UNKNOWN("9999", "服务器错误"),
    CODE_SUCCESS("0000", "成功");
    private String code;

    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
