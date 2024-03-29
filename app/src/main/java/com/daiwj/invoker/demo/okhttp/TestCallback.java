package com.daiwj.invoker.demo.okhttp;

import com.daiwj.invoker.demo.okhttp.extra.TestHttpCodeInterceptor;
import com.daiwj.invoker.runtime.Callback;
import com.daiwj.invoker.runtime.FailureResult;
import com.daiwj.invoker.runtime.SuccessResult;

/**
 * author: daiwj on 2020/12/5 15:23
 */
public class TestCallback<Data> implements Callback<Data, TestFailure> {

    private TestHttpCodeInterceptor mInterceptor = new TestHttpCodeInterceptor();

    @Override
    public void onSuccess(SuccessResult<Data> result) {
        onSuccessful(result.getData());
    }

    @Override
    public final void onFailure(FailureResult<TestFailure> result) {
        final TestFailure failure = result.getFailure();
        if (failure.isError()) {
            onError((TestError) failure);
        } else {
            if ("302".equals(result.getFailure().getCode())) {
                mInterceptor.intercept(this, result);
            } else {
                onFailure(failure);
            }
        }
    }

    public void onSuccessful(Data data) {

    }

    public void onUnsuccessful() {

    }

    /**
     * 业务失败
     */
    public void onFailure(TestFailure failure) {

    }

    /**
     * 发生错误
     */
    public void onError(TestError error) {

    }
}
