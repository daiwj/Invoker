package com.daiwj.invoker.annotation;

import com.daiwj.invoker.runtime.Call;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author: daiwj on 2/18/21 10:46
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CallProvider {

    Class<? extends Call.CallFactory> value();

}
