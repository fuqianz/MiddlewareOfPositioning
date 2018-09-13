package edu.sse.ustc.innerclass;

import java.util.List;

import edu.sse.ustc.innerclass.myenum.MapFormat;
import edu.sse.ustc.innerclass.myenum.MapType;


public class Map {
	
	private Integer mapId; // map's ID
	private Integer environmentId;// the environment which this map belongs to
	private String name; // map's name
	private MapType maptype; // map's type : normal or cascade
	private Integer fatherMapId; 
	private MapFormat mapFormat; 
	private Integer mapSizeInByte;
	private Integer width; 
	private Integer height;
	private Integer scale; 
	private String remark; 
	private List<LinkSegmentContent> linkSegment; 
	private String mapImageName;
	private String mapURI;

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

	public MapType getMaptype() {
		return maptype;
	}

	public void setMaptype(MapType maptype) {
		this.maptype = maptype;
	}

	public Integer getFatherMapId() {
		return fatherMapId;
	}

	public void setFatherMapId(Integer fatherMapId) {
		this.fatherMapId = fatherMapId;
	}

	public MapFormat getMapFormat() {
		return mapFormat;
	}

	public void setMapFormat(MapFormat mapFormat) {
		this.mapFormat = mapFormat;
	}

	public Integer getMapSizeInByte() {
		return mapSizeInByte;
	}

	public void setMapSizeInByte(Integer mapSizeInByte) {
		this.mapSizeInByte = mapSizeInByte;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getScale() {
		return scale;
	}

	public void setScale(Integer scale) {
		this.scale = scale;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<LinkSegmentContent> getLinkSegment() {
		return linkSegment;
	}

	public void setLinkSegment(List<LinkSegmentContent> linkSegment) {
		this.linkSegment = linkSegment;
	}

	public String getMapImageName() {
		return this.mapImageName;
	}

	public void setMapImageName(String mapImageName) {
		this.mapImageName = mapImageName;
	}

	public void setMapURI(String mapURI)
	{
		this.mapURI = mapURI;
	}
	
	public String getMapURI()
	{
	    return this.mapURI;	
	}
	@Override
	public String toString() {
		return "MapContract [mapId=" + mapId + ", environmentId=" + environmentId + ", name=" + name + ", maptype=" + maptype + ", fatherMapId="
				+ fatherMapId + ", mapFormat=" + mapFormat + ", mapSizeInByte=" + mapSizeInByte + ", width=" + width + ", height=" + height + ", scale="
				+ scale + ", remark=" + remark + ", linkSegment=" + linkSegment + ", mapImageName=" + mapImageName + ", mapURI=" +mapURI+"]";
	}

}
