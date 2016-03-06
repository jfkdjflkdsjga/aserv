/**
 * Copyright 2014 ABSir's Studio
 * 
 * All right reserved
 *
 * Create on 2014-3-18 下午2:31:55
 */
package com.absir.sockser;

import javax.persistence.MappedSuperclass;

import com.absir.aserv.system.bean.base.JbBean;
import com.absir.aserv.system.bean.value.JaEdit;
import com.absir.aserv.system.bean.value.JaLang;
import com.absir.aserv.system.bean.value.JiActive;

/**
 * @author absir
 * 
 */
@MappedSuperclass
public class JbServer extends JbBean implements JiActive, JiServer {

	@JaLang("服务器名称")
	@JaEdit(groups = { JaEdit.GROUP_SUG, JaEdit.GROUP_SUGGEST })
	private String name;

	@JaLang("端口号")
	@JaEdit(groups = JaEdit.GROUP_LIST)
	private int port;

	@JaLang("混合端口")
	@JaEdit(groups = JaEdit.GROUP_LIST)
	private boolean multiPort;

	@JaLang("服务器IP")
	@JaEdit(groups = JaEdit.GROUP_LIST)
	private String ip;

	@JaLang("开始时间")
	@JaEdit(groups = JaEdit.GROUP_LIST)
	private long beginTime;

	@JaLang("关闭时间")
	@JaEdit(groups = JaEdit.GROUP_LIST)
	private long passTime;

	@JaLang("关闭")
	@JaEdit(groups = JaEdit.GROUP_LIST)
	private boolean closed;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the multiPort
	 */
	public boolean isMultiPort() {
		return multiPort;
	}

	/**
	 * @param multiPort
	 *            the multiPort to set
	 */
	public void setMultiPort(boolean multiPort) {
		this.multiPort = multiPort;
	}

	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * @param ip
	 *            the ip to set
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * @return the beginTime
	 */
	public long getBeginTime() {
		return beginTime;
	}

	/**
	 * @param beginTime
	 *            the beginTime to set
	 */
	public void setBeginTime(long beginTime) {
		this.beginTime = beginTime;
	}

	/**
	 * @return the passTime
	 */
	public long getPassTime() {
		return passTime;
	}

	/**
	 * @param passTime
	 *            the passTime to set
	 */
	public void setPassTime(long passTime) {
		this.passTime = passTime;
	}

	/**
	 * @return the closed
	 */
	public boolean isClosed() {
		return closed;
	}

	/**
	 * @param closed
	 *            the closed to set
	 */
	public void setClosed(boolean closed) {
		this.closed = closed;
	}

}