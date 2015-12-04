package org.cross.elscommon.po;

import org.cross.elscommon.util.PositionType;

public class DriverPO extends PersonnelPO {
	/**
	 * 司机编号
	 */
	private String number;

	/**
	 * 行驶证开始时间
	 */
	private String licenceStart;

	/**
	 * 行驶证到期时间
	 */
	private String licenceEnd;

	public DriverPO(String number, String name, PositionType position,
			String orgNum, double payment, int sex, String id, String phone,
			String birth, String number2, String licenceStart, String licenceEnd) {
		super(number, name, position, orgNum, payment, sex, id, phone, birth);
		number = number2;
		this.licenceStart = licenceStart;
		this.licenceEnd = licenceEnd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLicenceStart() {
		return licenceStart;
	}

	public void setLicenceStart(String licenceStart) {
		this.licenceStart = licenceStart;
	}

	public String getLicenceEnd() {
		return licenceEnd;
	}

	public void setLicenceEnd(String licenceEnd) {
		this.licenceEnd = licenceEnd;
	}

}
