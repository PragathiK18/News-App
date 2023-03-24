package roles;

import news.Category;

public class manager extends user {

	String cName;
    String cEmail  ;
	String cAdress;
	String cNumber;
	String status;
	public manager(String id, String username, String password, String mailId, String number, String cName,
			String cEmail, String cAdress, String cNumber,String status) {
		super(id, username, password, mailId, number);
		this.cName = cName;
		this.cEmail = cEmail;
		this.cAdress = cAdress;
		this.cNumber = cNumber;
		this.status= status;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	@Override
	public String toString() {
		return "manager [cName=" + cName + ", cEmail=" + cEmail + ", cAdress=" + cAdress + ", cNumber=" + cNumber
				+ ", status=" + status + "]";
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcAdress() {
		return cAdress;
	}
	public void setcAdress(String cAdress) {
		this.cAdress = cAdress;
	}
	public String getcNumber() {
		return cNumber;
	}
	public void setcNumber(String cNumber) {
		this.cNumber = cNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}




}
