package com.piggsoft.response;

import com.piggsoft.constants.ResponseContatns;

/**
 * <br>Created by fire pigg on 2015/12/30.
 *
 * @author piggsoft@163.com
 */
public class SuccessRsp extends Rsp {

    public SuccessRsp() {
        super(ResponseContatns.SUCCESS.getCode(), ResponseContatns.SUCCESS.getMsg());
    }
}
