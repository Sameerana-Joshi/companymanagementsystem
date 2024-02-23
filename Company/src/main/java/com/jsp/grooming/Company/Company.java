package com.jsp.grooming.Company;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
@Cacheable
@Cache(usage =CacheConcurrencyStrategy.READ_ONLY)
@Entity
public class Company {
	@Id
	private int coompanyId;
	private String companyName;
	private String headQuarterLocation;
	private int totalBranches;
	private String companyType;
	private int totalEmployees;
	private String companyCeo;
	public int getCoompanyId() {
		return coompanyId;
	}
	public void setCoompanyId(int coompanyId) {
		this.coompanyId = coompanyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getHeadQuarterLocation() {
		return headQuarterLocation;
	}
	public void setHeadQuarterLocation(String headQuarterLocation) {
		this.headQuarterLocation = headQuarterLocation;
	}
	public int getTotalBranches() {
		return totalBranches;
	}
	public void setTotalBranches(int totalBranches) {
		this.totalBranches = totalBranches;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public int getTotalEmployees() {
		return totalEmployees;
	}
	public void setTotalEmployees(int totalEmployees) {
		this.totalEmployees = totalEmployees;
	}
	public String getCompanyCeo() {
		return companyCeo;
	}
	public void setCompanyCeo(String companyCeo) {
		this.companyCeo = companyCeo;
	}
	@Override
	public String toString() {
		return "Company [coompanyId=" + coompanyId + ", companyName=" + companyName + ", headQuarterLocation="
				+ headQuarterLocation + ", totalBranches=" + totalBranches + ", companyType=" + companyType
				+ ", totalEmployees=" + totalEmployees + ", companyCeo=" + companyCeo + "]";
	}
	

}
