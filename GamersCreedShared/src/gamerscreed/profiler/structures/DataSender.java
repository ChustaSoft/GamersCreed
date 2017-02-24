package gamerscreed.profiler.structures;

import java.util.List;

import gamerscreed.profiler.enums.RoleAction;

public class DataSender {

	private boolean success;
	private String operationMessage;
	private Object dataObject;
	private List<Exception> exceptionsList;
	private RoleAction role;
	
	public DataSender() {}
	
	public DataSender(Object anObject){
		dataObject = anObject;
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public String getOperationMessage() {
		return operationMessage;
	}
	
	public void setOperationMessage(String operationMessage) {
		this.operationMessage = operationMessage;
	}
	
	public Object getDataObject() {
		return dataObject;
	}
	
	public void setDataObject(Object dataObject) {
		this.dataObject = dataObject;
	}
	
	public List<Exception> getExceptionsList() {
		return exceptionsList;
	}
	
	public void setExceptionsList(List<Exception> exceptionsList) {
		this.exceptionsList = exceptionsList;
	}

	public RoleAction getRole() {
		return role;
	}

	public void setRole(RoleAction role) {
		this.role = role;
	}
	

}
