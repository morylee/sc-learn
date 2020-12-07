package com.mm.support;

import java.lang.annotation.*;

/**
 * @author mory.lee
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Inner {

	/**
	 * 是否AOP统一处理
	 */
	boolean value() default true;

}
