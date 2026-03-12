package com.example.myapplication.api;



import com.example.myapplication.model.MainTagBean;
import com.example.myapplication.model.PhoneBean;
import com.example.myapplication.mvp.BaseModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * 作者:Created by sinbara on 2019/2/13.
 * 邮箱:hrb940258169@163.com
 */

public interface ApiServer {

    @GET("/v3/api/page/index/{tag}")
    Observable<BaseModel<MainTagBean>> getMainTag(@Path("tag") String tag);

    @GET("/phone/")
    Observable<PhoneBean> getPhone(@Query("phone") String phone);
}
