package com.revin122.revmappy;

import com.codename1.ui.CN;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class EnterSMSVerificationDigitsForm extends Form {

	public EnterSMSVerificationDigitsForm(String phone) {
		super(new BorderLayout());
		
		Form previous = CN.getCurrentForm();
		getToolbar().setBackCommand("", Toolbar.BackCommandPolicy.AS_ARROW, e -> previous.showBack());
		Container box = new Container(BoxLayout.y());
	}
	
}
