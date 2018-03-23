package com.cong.huaweiappstore.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * <p>Description:
 *
 * @author xzhang
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)//注意注解范围是Runtime级别
public @interface ContextLife {
    String value() ;
}
