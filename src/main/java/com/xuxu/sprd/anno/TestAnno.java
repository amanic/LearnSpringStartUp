package com.xuxu.sprd.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by joakira on 2018/1/9.
 */
@Retention(RetentionPolicy.RUNTIME )
public @interface TestAnno {

    String name="abc";
}
