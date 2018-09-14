package org.liyl.lotus.exception;

/**
 * Web异常类
 * 创建日期：2017-03-14
 *
 * @author Sean.Hwang
 */
public class WebException extends RuntimeException {

    private String code;

    public WebException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public WebException(String code, String msg) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
