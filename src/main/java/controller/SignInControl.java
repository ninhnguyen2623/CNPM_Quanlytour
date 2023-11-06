package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.SignIn;

public class SignInControl implements ActionListener{
	private SignIn signin;
	
	public SignInControl(SignIn signin) {
		this.signin = signin;
	}
	
	public SignInControl() {
		
	}
	
	public SignIn getSignin() {
		return signin;
	}

	public void setSignin(SignIn signin) {
		this.signin = signin;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(e.getSource() == signin.getIconHiddenPass()) {
			signin.showPass();
		}
		else if(e.getSource() == signin.getIconShowPass()) {
			signin.hidPass();
		}	
		else if(src.equals("Register Now")) {
			this.signin.chgResgister();
		}			
	}
}
