package edu.neu.csye6200.model;

/**
 * Immunization Rules
 * @author Kaushik Gnanasekar
 *
 */
public class ImmunizationRules {

	public ImmunizationRules() {};
	
	private int immunizationRuleId;
	private int minAge;
	private int maxAge;
	private String vaccineName;
	
	public ImmunizationRules(int immunizationRuleId, int minAge, int maxAge, String vaccineName) {
		this.immunizationRuleId = immunizationRuleId;
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.vaccineName = vaccineName;
	}

	public int getImmunizationRuleId() {
		return immunizationRuleId;
	}

	public void setImmunizationRuleId(int immunizationRuleId) {
		this.immunizationRuleId = immunizationRuleId;
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	@Override
	public String toString() {
		return "ImmunizationRules [getImmunizationRuleId()=" + getImmunizationRuleId() + ", getMinAge()=" + getMinAge()
				+ ", getMaxAge()=" + getMaxAge() + ", getVaccineName()=" + getVaccineName() + "]";
	}
	
	
	
}
