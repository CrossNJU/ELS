/**
 * 期初建账PO
 * @author Polaris Chen
 * @date 2015/10/23
 */
package org.cross.elscommon.po;

import java.io.Serializable;
import java.util.ArrayList;

public class InitialPO implements Serializable {

	/**
	 * 编号
	 */
	private String number;

	/**
	 * 年份
	 */
	private int time;

	/**
	 * 名称
	 */
	private String name;

	public InitialPO(String number, int time, String name) {
		super();
		this.number = number;
		this.time = time;
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
