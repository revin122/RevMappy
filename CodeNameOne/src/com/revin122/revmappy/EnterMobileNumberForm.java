package com.revin122.revmappy;

import com.codename1.components.FloatingActionButton;
import com.codename1.ui.CN;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.revin122.revmappy.views.CountryCodePicker;

public class EnterMobileNumberForm extends Form {
	
	public EnterMobileNumberForm() {
		super(BoxLayout.y());
		Form previous = CN.getCurrentForm();
		getToolbar().setBackCommand("", Toolbar.BackCommandPolicy.AS_ARROW, e -> previous.showBack());
		add(new Label("Enter mobile number", "FlagButton"));
		CountryCodePicker picker = new CountryCodePicker();
		TextField phoneNumber = new TextField("", "050-123-4567", 40, TextField.PHONENUMBER);
		add(BorderLayout.centerCenterEastWest(phoneNumber, null, picker));
		Style ps = phoneNumber.getUnselectedStyle();
		Style cs = picker.getUnselectedStyle();
		int pl = cs.getPaddingLeft(isRTL());
		int pr = cs.getPaddingRight(isRTL());
		picker.getAllStyles().setPaddingUnit(Style.UNIT_TYPE_PIXELS);
		picker.getAllStyles().setPadding(ps.getPaddingTop(), ps.getPaddingBottom(), pl, pr);
		setEditOnShow(phoneNumber);
		FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ARROW_FORWARD);
		fab.bindFabToContainer(this);
		fab.addActionListener(e -> {
			String number = phoneNumber.getText();
			if(number.startsWith("0")) {
				number = number.substring(1);
			}
//			new EnterSMSVerificationDigitsForm(picker.getText() + " - " + number).show();
		});
	}
	
}
