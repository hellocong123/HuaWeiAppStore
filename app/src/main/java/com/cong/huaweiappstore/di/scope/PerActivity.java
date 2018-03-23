package com.cong.huaweiappstore.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * <p>Description:
 *
 * @author xzhang
 */
@Scope//注明是Scope
@Retention(RetentionPolicy.RUNTIME)//运行时级别
public @interface PerActivity {
}
