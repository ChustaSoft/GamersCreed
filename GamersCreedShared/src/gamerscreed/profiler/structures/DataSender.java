package gamerscreed.profiler.structures;

import java.util.List;

public class DataSender {

	private boolean success;
	private String operationMessage;
	private Object dataObject;
	private List<Exception> exceptionsList;
	private SecurityInfo securityInfo;
	
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	/**
	 * @return the operationMessage
	 */
	public String getOperationMessage() {
		return operationMessage;
	}
	
	/**
	 * @param operationMessage the operationMessage to set
	 */
	public void setOperationMessage(String operationMessage) {
		this.operationMessage = operationMessage;
	}
	
	/**
	 * @return the dataObjects
	 */
	public Object getDataObject() {
		return dataObject;
	}
	
	/**
	 * @param dataObjects the dataObjects to set
	 */
	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}
	
	/**
	 * @return the exceptionsList
	 */
	public List<Exception> getExceptionsList() {
		return exceptionsList;
	}
	
	/**
	 * @param exceptionsList the exceptionsList to set
	 */
	public void setExceptionsList(List<Exception> exceptionsList) {
		this.exceptionsList = exceptionsList;
	}
	
	public SecurityInfo getSecurityInfo() {
		return securityInfo;
	}
	
	public void setSecurityInfo(SecurityInfo securityInfo) {
		this.securityInfo = securityInfo;
	}
	
}
