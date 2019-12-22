package org.xupan.cms.model;
/**
 * 自定义异常
 * @author Administrator
 *
 */
public class CmsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CmsException() {
		super();
	}

	public CmsException(String message, Throwable cause) {
		super(message, cause);
	}

	public CmsException(String message) {
		super(message);
	}

	public CmsException(Throwable cause) {
		super(cause);
	}

	
}
