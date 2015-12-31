package com.piggsoft.response;

import java.util.List;

/**
 * <br>Created by fire pigg on 2015/12/30.
 *
 * @author piggsoft@163.com
 */
public class Response {
    private String code;
    private String msg;
    private String total;
    private List<Object> items;
    private Object item;


    public Response(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Response() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}
