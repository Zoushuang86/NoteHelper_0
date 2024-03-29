package com.ustc.leo.net.download;

import android.os.AsyncTask;

import com.ustc.leo.net.RestCreator;
import com.ustc.leo.net.callback.IError;
import com.ustc.leo.net.callback.IFailure;
import com.ustc.leo.net.callback.IRequest;
import com.ustc.leo.net.callback.ISuccess;

import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dell on 2018/1/21.
 */

public class DownloadHandler {

    private final String URL;
    private static final WeakHashMap<String,Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final String DOWNLOAD_DIR; //下载文件目录
    private final String EXTENSION;  //下载文件后缀
    private final String NAME;  //下载文件名
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;

    public DownloadHandler(String url,
                           IRequest request,
                           String downloadDir,
                           String extension,
                           String name,
                           ISuccess success,
                           IFailure failure,
                           IError error) {
        this.URL = url;
        this.REQUEST = request;
        this.DOWNLOAD_DIR = downloadDir;
        this.EXTENSION = extension;
        this.NAME = name;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
    }

    public final void handleDownload(){
        if(REQUEST!=null){
            REQUEST.onRequstStart();
        }

        RestCreator.getRestService().download(URL,PARAMS)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()){
                            final ResponseBody responseBody = response.body();
                            final SaveFileTask task = new SaveFileTask(REQUEST,SUCCESS);
                            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,DOWNLOAD_DIR,EXTENSION,response,NAME);

                            //这里一定要注意判断，否则文件下载不全
                            if(task.isCancelled()){
                                if(REQUEST!=null){
                                    REQUEST.onRequstEnd();
                                }
                            }
                        }else {
                            if(ERROR!=null){
                                ERROR.onError(response.code(),response.message());
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        if(FAILURE!=null){
                            FAILURE.onFailure();
                        }
                    }
                });
    }
}
