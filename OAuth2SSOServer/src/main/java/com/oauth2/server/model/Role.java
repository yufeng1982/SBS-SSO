/**
 * 
 */
package com.oauth2.server.model;

/**
 * @author YF
 *
 */
public class Role extends AbsEntiry {
	private String code;
	private String desc;
	private String resources;
	private String functionNodeIds;
	
	public Role() {
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getResources() {
		return resources;
	}

	public void setResources(String resources) {
		this.resources = resources;
	}

	public String getFunctionNodeIds() {
		return functionNodeIds;
	}

	public void setFunctionNodeIds(String functionNodeIds) {
		this.functionNodeIds = functionNodeIds;
	}
	
}
