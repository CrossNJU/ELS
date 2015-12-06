package org.cross.elsclient.vo;

import org.cross.elscommon.util.PositionType;

public class DriverVO extends PersonnelVO{
	
	/**
	 * 行驶证颁发时间
	 */
	@SuppressWarnings("unused")
	private String licenceStart;
	/**
	 * 行驶证到期时间
	 */
	@SuppressWarnings("unused")
	private String licenceEnd;
	
	public DriverVO(String number, String name, String sex, String id,
			String phone, PositionType position, String birthday,
			String orgNameID, double payment, double extraMoney,
			String licenceStart, String licenceEnd) {
		super(number, name, sex, id, phone, position, birthday, orgNameID,
				payment, extraMoney);
		this.licenceStart = licenceStart;
		this.licenceEnd = licenceEnd;
	}

}
