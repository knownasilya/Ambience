/**
 * 
 */
package g5.ambience.view;

import g5.ambience.user.ManagedUserBean;
import g5.ambience.user.model.User;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;





/**
 * @author ilya
 *
 */
public class UserView {
	
	protected static final String SUCCESS = "Success";
	
	private String username;
	private String password;

	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void userLogin(ActionEvent actionEvent){
		 try{
			 ManagedUserBean mub = new ManagedUserBean();
			 User user = mub.getUserByUsername(this.getUsername());
			 String fn = user.getFirstName();
			 FacesMessage fm = new FacesMessage(fn);
			 FacesContext.getCurrentInstance().addMessage("Test", fm);
			 
		 } finally {
			 
		 }
	}
	
}
