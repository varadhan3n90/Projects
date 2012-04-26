package email;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Email implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String body;
	private GregorianCalendar timestamp;
	
	Email(String to,String subject,String body){
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getCc() {
		return cc;
	}
	public void setCc(String cc) {
		this.cc = cc;
	}
	public String getBcc() {
		return bcc;
	}
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public GregorianCalendar getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(GregorianCalendar timestamp) {
		this.timestamp = timestamp;
	}
	

}
