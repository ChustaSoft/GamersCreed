package gamerscreed.profiler.structures;

import java.io.Serializable;

import gamerscreed.profiler.enums.RoleAction;

public class DataSender<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private T dataObject;	
	private boolean success;
	private String operationMessage;
	private RoleAction role;
	
	public DataSender() {}
	
	public DataSender(T anObject){
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
	
	public T getDataObject() {
		return dataObject;
	}
	
	public void setDataObject(T dataObject) {
		this.dataObject = dataObject;
	}

	public RoleAction getRole() {
		return role;
	}

	public void setRole(RoleAction role) {
		this.role = role;
	}	

}
