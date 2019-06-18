/**
 * 
 */
package com.oauth2.server.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

/**
 * @author YF
 *
 */
public class AbsEntiry {
	@Id
	private String id;
	
	@Version
	private int version;
	
	private String createBy;
	
	private LocalDate creationDate;
	
	private LocalDate modifiedDate;
	
	private String modifiedBy;
	
	private Boolean active = Boolean.TRUE;

	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public boolean isActive() {
		return active == null ? false : active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
