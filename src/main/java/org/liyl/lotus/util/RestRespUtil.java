package org.liyl.lotus.util;

import org.apache.commons.lang3.StringUtils;
import org.liyl.lotus.exception.ResultEnum;
import org.liyl.lotus.exception.WebException;

/**
 * Restful返回结果Util
 * 创建日期：2017-01-21 13:39
 *
 * @author Sean.Hwang
 */
public class RestRespUtil {

    public static <T> RestResp<T> success(T data) {
        RestResp<T> result = new RestResp<>();
        result.setRespCode(ResultEnum.CODE_SUCCESS.getCode());
        result.setRespMsg(ResultEnum.CODE_SUCCESS.getMsg());
        result.setData(data);
        return result;
    }

    public static <T> RestResp<T> success(T data, String msg) {
        RestResp<T> result = new RestResp<>();
        result.setRespCode(ResultEnum.CODE_SUCCESS.getCode());
        result.setRespMsg(msg);
        result.setData(data);
        return result;
    }

    public static RestResp success() {
        return success(null);
    }

    public static RestResp error(String code, String msg) {
        RestResp result = new RestResp();
        result.setRespCode(code);
        result.setRespMsg(msg);
        return result;
    }

	/**
     * @Author：liyl
     * 业务异常对象封装为 RestResp 对象
     * @param en
     * @return
     */
    public static RestResp error(ResultEnum en) {
        RestResp result = new RestResp();
        result.setRespCode(en.getCode());
        result.setRespMsg(en.getMsg());
        return result;
    }

    /**
     * @Author：liyl
     * 统一封装对象获取数据，对于服务生产者若已发生异常，应往外继续抛出WebException
     * */
    public static <T> T getData(RestResp<T> restResp) {
        if (!restResp.getRespCode().equals(ResultEnum.CODE_SUCCESS.getCode())) {
            final String msg = StringUtils.isBlank(restResp.getRespMsg()) ? "服务器异常" : restResp.getRespMsg();
            throw new WebException(restResp.getRespCode(), msg);
        }
        return restResp.getData();
    }
}
