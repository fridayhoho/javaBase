package com.test.annotations;

import java.lang.annotation.*;

/**
 * ClassName: MyNotNull
 * Function:  TODO
 * Date:      2019-06-08 08:25
 * author     daguang
 * version    V1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MyNotNull {
}
