/**
 * Copyright 2015 ABSir's Studio
 * 
 * All right reserved
 *
 * Create on 2015年11月19日 上午10:16:12
 */
package com.absir.aserv.system.bean.value;

import com.absir.aserv.system.bean.proxy.JiBase;

/**
 * @author absir
 *
 */
public interface JiOpenValue<T> extends JiBase {
	
	/**
	 * @return
	 */
	public boolean isOpen();
	
	/**
	 * @return
	 */
	public T getValue();

}