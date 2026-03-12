package com.example.myapplication.mvp;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * 作者:Created by sinbara on 2019/2/13.
 * 邮箱:hrb940258169@163.com
 */

public abstract class BaseObserver<T> implements Observer<T> {

    public final String TAG=getClass().getSimpleName();

    /**
     * 网络连接失败  无网
     */
    public static final int NETWORK_ERROR = 100000;
    /**
     * 服务器异常
     */
    public static final int SERVER_ERROR = 1009;
    /**
     * 解析数据失败
     */
    public static final int PARSE_ERROR = 1008;
    /**
     * 网络问题
     */
    public static final int BAD_NETWORK = 1007;
    /**
     * 连接错误
     */
    public static final int CONNECT_ERROR = 1006;
    /**
     * 连接超时
     */
    public static final int CONNECT_TIMEOUT = 1005;

    /**
     * 未登录
     */
    public static final int CONNECT_NOT_LOGIN = 1001;
    /**
     * 其他错误
     */
    public static final int OTHER_ERROR = 1000;

    protected BaseView view;

    public BaseObserver(BaseView view) {
        this.view = view;
    }


    protected void onStart() {
        if (view != null) {
            view.requestStart();
        }
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T o) {
        try {
            if (view != null) {
                view.requestFinish();
            }
            //测试代码
            onSuccess(o);
            /*BaseModel model = (BaseModel) o;
            if (model.getStatus()==1){
                onSuccess(o);
            }else {
               if (!model.isLogin()){
                    onException(CONNECT_NOT_LOGIN);
               }else {
                    onException(SERVER_ERROR);
               }
            }*/
        } catch (Exception e) {
            e.printStackTrace();
            onError(-1,e.toString());
        }
    }

    @Override
    public void onError(Throwable e) {
        if (view != null) {
            view.requestFinish();
        }
        if (e instanceof HttpException) {
            //   HTTP错误
            onException(BAD_NETWORK);
        } else if (e instanceof ConnectException
                || e instanceof UnknownHostException) {
            //   连接错误
            onException(CONNECT_ERROR);
        } else if (e instanceof InterruptedIOException) {
            //  连接超时
            onException(CONNECT_TIMEOUT);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException) {
            //  解析错误
            onException(PARSE_ERROR);
        }else {
            onException(OTHER_ERROR);
        }
    }

    private void onException(int unknownError) {
        switch (unknownError) {
            case CONNECT_ERROR:
                onError(unknownError,"连接错误");
                break;
            case CONNECT_TIMEOUT:
                onError(unknownError,"连接超时");
                break;
            case BAD_NETWORK:
                onError(unknownError,"网络超时");
                break;
            case PARSE_ERROR:
                onError(unknownError,"数据解析失败");
                break;
            case CONNECT_NOT_LOGIN:
                onError(unknownError,"未登录");
                break;
            case OTHER_ERROR:
                onError(unknownError,"未知错误");
                break;
            //网络不可用
            case NETWORK_ERROR:
                onError(unknownError,"网络不可用，请检查网络连接！");
                break;
            default:
                break;
        }
    }

    @Override
    public void onComplete() {
    }

    public abstract void onSuccess(T o);

    public void onError(int errorCode,String msg){
        Log.e(TAG,"errorCode=="+errorCode);
    }

}
