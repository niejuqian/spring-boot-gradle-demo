package com.demo.common.util;

/**
 * 
 * 项目名称：cunpiao-member-common
 * 
 * 类名称：ServiceAssert
 * 
 * 类描述： 业务验证
 * 
 * 创建人： 6220(wujun)
 * 
 * 创建时间：2017年7月18日 上午10:35:20
 * 
 * Copyright (c) 上海燕致网络科技有限公司-版权所有
 */
public abstract class ServiceAssert {
	/*private static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();

	private static final SpringValidatorAdapter VALIDATOR_ADAPTER = new SpringValidatorAdapter(VALIDATOR);
	private static BindingResult getConfiguration(Object param) {
		BindingResult errors = new BeanPropertyBindingResult(param, "configuration");
		return errors;
	}
	public static void valid(Object param) {
		BindingResult errors = getConfiguration(param);
		ValidationUtils.invokeValidator(VALIDATOR_ADAPTER, param, errors);
		if (!errors.hasErrors()) {
			return ; // 没有错误，直接返回
		}
		for (FieldError fieldError : errors.getFieldErrors()) {
			throw new AppException(fieldError.getDefaultMessage());
		}
	}
	public static void notNull(ResponseHeader response, Object... objects) throws AppException {
		Assert.notNull(response, StandardResponseHeader.ERROR.getDescription());
		if (ObjectUtils.isEmpty(objects)) {
			throw new AppException(response);
		}
		for (Object object : objects) {
			if (ObjectUtils.isEmpty(object)) {
				throw new AppException(response);
			}
			// 如果不为空额外验证JSR-303's
			Validated validated = AnnotationUtils.findAnnotation(object.getClass(), Validated.class);
			if (ObjectUtils.isEmpty(validated)) {
				continue; // 如果没有验证注解，
			}
			valid(object);
		}
	}

	public static void allNull(ResponseHeader response, Object... objects) throws AppException {
		Assert.notNull(response, StandardResponseHeader.ERROR.getDescription());
		if (ObjectUtils.isEmpty(objects)) {
			throw new AppException(response);
		}
		boolean flag = true;
		for (Object object : objects) {
			if (!ObjectUtils.isEmpty(object)) {
				flag = false;
				break;
			}
		}
		if (flag) {
			throw new AppException(response);
		}
	}

	public static void notNullThrowException(ResponseHeader response, Object... objects) throws AppException {
		Assert.notNull(response, StandardResponseHeader.ERROR.getDescription());
		if (!ObjectUtils.isEmpty(objects)) {
			for (Object object : objects) {
				if (!ObjectUtils.isEmpty(object)) {
					throw new AppException(response);
				}
			}
		}

	}

	public static void isTrue(boolean expression, ResponseHeader response) throws AppException {
		Assert.notNull(response, StandardResponseHeader.ERROR.getDescription());
		if (!expression) {
			throw new AppException(response);
		}
	}

	public static void isTrueThrowException(boolean expression, ResponseHeader response) throws AppException {
		Assert.notNull(response, StandardResponseHeader.ERROR.getDescription());
		if (expression) {
			throw new AppException(response);
		}
	}

	public static void notNull(Integer code, String desc, Object... objects) throws AppException {
		ResponseHeader header = ResponseHeader.newInstance(code,desc);
		notNull(header,objects);
	}

	public static void isTrue(boolean expression, Integer code, String desc) throws AppException {
		if (!expression) {
			ResponseHeader response = ResponseHeader.newInstance(code, desc);
			throw new AppException(response);
		}
	}*/

}
