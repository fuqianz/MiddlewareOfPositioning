package edu.sse.ustc.innerclass;

/**
 * environment
 * 
 */
public class Environment {

	private Integer environmentId;
	private String environmentName;
	private String environmentURI;

	public String getEnvironmentURI() {
		return environmentURI;
	}

	public void setEnvironmentURI(String environmentURI) {
		this.environmentURI = environmentURI;
	}

	public Integer getEnvironmentId() {
		return environmentId;
	}

	public void setEnvironmentId(Integer environmentId) {
		this.environmentId = environmentId;
	}

	public String getEnvironmentName() {
		return environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}

	@Override
	public String toString() {
		return "Environment [environmentId=" + environmentId + ", environmentName=" + environmentName
				+ ", environmentURI=" + environmentURI + "]";
	}
}
