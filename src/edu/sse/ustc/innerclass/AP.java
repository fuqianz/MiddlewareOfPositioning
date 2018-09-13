package edu.sse.ustc.innerclass;

import edu.sse.ustc.innerclass.myenum.APType;
import edu.sse.ustc.innerclass.myenum.DevStatus;

/**
 * ApContract
 */

public class AP {
	private Integer apId;
	private Integer mapId;
	private Integer environmentId;
	private String mac;
	private String name;
	private DevStatus status;
	private Integer x_pos;
	private Integer y_pos;
	private Integer z_pos;
	private String productModel;
	private String ip4Addr;
	private String ip6Addr;
	private String remark;
	private APType apType;
	private RfidAPContract extInfo;
	public String apURI;

	public Integer getApId() {
		return apId;
	}

	public void setApId(Integer apId) {
		this.apId = apId;
	}

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public Integer getEnvironmentId() {
		return environmentId;
	}

	public void setEnvironmentId(Integer environmentId) {
		this.environmentId = environmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public DevStatus getStatus() {
		return status;
	}

	public void setStatus(DevStatus status) {
		this.status = status;
	}

	public Integer getX_pos() {
		return x_pos;
	}

	public void setX_pos(Integer x_pos) {
		this.x_pos = x_pos;
	}

	public Integer getY_pos() {
		return y_pos;
	}

	public void setY_pos(Integer y_pos) {
		this.y_pos = y_pos;
	}

	public Integer getZ_pos() {
		return z_pos;
	}

	public void setZ_pos(Integer z_pos) {
		this.z_pos = z_pos;
	}

	public String getProductModel() {
		return productModel;
	}

	public void setProductModel(String productModel) {
		this.productModel = productModel;
	}

	public String getIp4Addr() {
		return ip4Addr;
	}

	public void setIp4Addr(String ip4Addr) {
		this.ip4Addr = ip4Addr;
	}

	public String getIp6Addr() {
		return ip6Addr;
	}

	public void setIp6Addr(String ip6Addr) {
		this.ip6Addr = ip6Addr;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public APType getApType() {
		return apType;
	}

	public void setApType(APType apType) {
		this.apType = apType;
	}

	public RfidAPContract getExtInfo() {
		return extInfo;
	}

	public void setExtInfo(RfidAPContract extInfo) {
		this.extInfo = extInfo;
	}

	public String getApURI() {
		return apURI;
	}

	public void setApURI(String apURI) {
		this.apURI = apURI;
	}

	@Override
	public String toString() {
		return "AP [apId=" + apId + ", mapId=" + mapId + ", environmentId="
				+ environmentId + ", mac=" + mac + ", name=" + name
				+ ", status=" + status + ", x_pos=" + x_pos + ", y_pos="
				+ y_pos + ", z_pos=" + z_pos + ", productModel=" + productModel
				+ ", ip4Addr=" + ip4Addr + ", ip6Addr=" + ip6Addr + ", remark="
				+ remark + ", apType=" + apType + ", extInfo=" + extInfo
				+ ", apURI=" + apURI + "]";
	}

}
