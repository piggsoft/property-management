package com.piggsoft.constants;

/**
 * <br>Created by fire pigg on 2015/12/30.
 *
 * @author piggsoft@163.com
 */
public class ResponseContatns {

    public static final Item SUCCESS = new Item("0000", "成功");


    public static class Item {
        private String code;
        private String msg;

        public Item(String code, String msg) {
            this.code = code;
            this.msg = msg;
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
    }

}
