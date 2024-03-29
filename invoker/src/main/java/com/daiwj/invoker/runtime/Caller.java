package com.daiwj.invoker.runtime;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.daiwj.invoker.Invoker;

/**
 * author: daiwj on 2020/12/3 20:03
 */
public interface Caller<Data> {

    Invoker getClient();

    MethodVisitor<Data> getMethodVisitor();

    IDynamicCaller<Data> asDynamic();

    Caller<Data> mock(String content);

    Mocker getMocker();

    <F extends IFailure> void call(Callback<Data, F> callback);

    <F extends IFailure> void call(Context context, Callback<Data, F> callback);

    <F extends IFailure> void call(Fragment fragment, Callback<Data, F> callback);

    SuccessResult<Data> callSync() throws CallException;

    void cancel();

    boolean isCanceled();

    void finish();

    String getTag();

}
