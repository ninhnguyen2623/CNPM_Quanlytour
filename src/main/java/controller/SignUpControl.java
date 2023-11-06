package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.SignUp;

public class SignUpControl implements ActionListener{
	private SignUp signup;
	
	public SignUpControl(SignUp signup) {
		this.signup = signup;
	}
	
	public SignUpControl() {
		
	}

	public SignUp getSignup() {
		return signup;
	}
	
	public void setSignup(SignUp signup) {
		this.signup = signup;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(e.getSource() == signup.getIconHiddenPass()) {
			signup.showPass();
		}
		else if(e.getSource() == signup.getIconShowPass()) {
			signup.hidPass();
		}	
		else if(src.equals("Back to Login")) {
			this.signup.chgLogin();
		}	
	}

}
