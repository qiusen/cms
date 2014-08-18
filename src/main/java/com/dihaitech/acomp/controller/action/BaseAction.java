package com.dihaitech.acomp.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.log4j.MDC;
import org.apache.struts2.ServletActionContext;

import com.dihaitech.acomp.common.Constants;
import com.dihaitech.acomp.model.Manager;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 所有ACTION的基类
 * 
 * @author qiusen
 * 
 *         2010-4-15
 */
public abstract class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 5376593007483604700L;

	/**
	 * 得到HttpRequest
	 * 
	 * @return 获得的HttpRequest
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 得到HttpSession
	 * 
	 * @return 获得的HttpSession
	 */
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}

	/**
	 * 得到HttpResponse
	 * 
	 * @return 获得的HttpResponse
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * 得到上下文路径，例如：/mylearningii
	 * 
	 * @return 上下文路径
	 */
	public String getContext() {
		return this.getRequest().getContextPath();
	}

	/**
	 * 得到应用的绝对地址，例如：D:\workspace\product\WebRoot\
	 * 
	 * @return 应用的绝对地址
	 */
	public String getRealPath() {
		return ServletActionContext.getServletContext().getRealPath("/");
	}

	/**
	 * 获得用户的真实IP
	 * 
	 * @return 用户的真实IP
	 */
	public String getRealIP() {
		String ip = getRequest().getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = getRequest().getRemoteAddr();
		}

		return ip;
	}

	/**
	 * 获得请求的referer
	 * 
	 * @return referer
	 */
	public String getReferer() {
		String referer = getRequest().getHeader("referer");
		if (referer != null && !referer.equalsIgnoreCase("")) {
			referer = referer.substring(0, referer.lastIndexOf('/') + 1);
		} else {
			referer = "";
		}

		return referer;
	}

	/**
	 * 获得当前用户的分页数
	 * 
	 * @return 当前用户的分页数
	 */
	public int getManagerPageSize() {
		int pageSize = 0;
		if (this.getSession().getAttribute("manager") != null) {
			pageSize = ((Manager) this.getSession().getAttribute("manager"))
					.getPageSize().intValue();
		}
		return pageSize;
	}

	/**
	 * 获得当前用户的分页数
	 * 
	 * @return 当前用户的分页数
	 */
	public void setManagerPageSize(int pageSize) {
		if (this.getSession().getAttribute("manager") != null) {
			((Manager) this.getSession().getAttribute("manager"))
					.setPageSize(pageSize);
		}
	}

	public Manager getSessionManager() {
		// 存session
		return (Manager) this.getSession().getAttribute("manager");
	}

	/**
	 * 记录日志
	 * 
	 * @param desc
	 * @param id
	 * @param nameZh
	 */
	protected void proLogs(Log logger, String desc, Integer id, String nameZh) {

		MDC.put(Constants.LOGS_COLUMN_NAME_OPERATOR, this.getSessionManager().getNickname()); // 用户名
		MDC.put(Constants.LOGS_COLUMN_NAME_EMAIL, this.getSessionManager()
				.getEmail()); // 昵称
		MDC.put(Constants.LOGS_COLUMN_NAME_OPER_IP, this.getRealIP()); // IP
		MDC.put(Constants.LOGS_COLUMN_NAME_DATA_ID, null != id ? id : "");
		MDC.put(Constants.LOGS_COLUMN_NAME_DATA_NAME, null != nameZh ? nameZh
				: "");
		logger.info(this.getSessionManager().getNickname() + desc
				+ (null != nameZh ? nameZh : ""));
	}
	
}
