package com.tocong.istore.utils.httputils;

import com.tocong.istore.bean.BaseCallModel;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Jialebao on 2017/4/7.
 */

public class ResultCallback extends BaseCallModel implements Callback<BaseCallModel> {
    @Override
    public void onResponse(Call<BaseCallModel> call, Response<BaseCallModel> response) {

    }

    @Override
    public void onFailure(Call<BaseCallModel> call, Throwable t) {

    }

    public interface Callback {
        /*
        * 网络问题 回调方法
        * */
        void onFailure(Call<BaseCallModel> call, Throwable t);

        void loginTimeoUT();

        void onSuccess(String tag, HashMap<String, Object> returnData);
    }

    public class APIException extends Exception {
        int code;
        String msg;

        public APIException(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }

        @Override
        public String getMessage() {
            return this.msg;
        }
    }
}
