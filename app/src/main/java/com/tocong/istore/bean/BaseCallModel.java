package com.tocong.istore.bean;

import java.util.HashMap;

/**
 * Created by Jialebao on 2017/4/7.
 */

public class BaseCallModel {
    private int status;
    private String msg;
    private HashMap<String, Object> returnData;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public HashMap<String, Object> getReturnData() {
        return returnData;
    }

    public void setReturnData(HashMap<String, Object> returnData) {
        this.returnData = returnData;
    }
}
