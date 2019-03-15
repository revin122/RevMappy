package com.revin122.revmappy;

import com.codename1.sms.activation.ActivationForm;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

public class CountryCodeForm extends Form {
	
	public CountryCodeForm(Button sourceBtn, Resources flags) {
		super(BoxLayout.y());
		
		CommonCode.initBlackForm(this, "Select Country", val -> search(val));
		Image blankImage = Image.createImage(100, 70, 0);
		
		char lastChar = (char)-1;
		
		for(int i = 0; i < ActivationForm.COUNTRY_CODES.length; i ++) {
			Button button = new Button(ActivationForm.COUNTRY_NAMES[i], "FlagButton");
			char current = button.getText().charAt(0);
			if(current != lastChar) {
				lastChar = current;
				Label label = new Label("" + lastChar, "FlagsLetter");
				add(label);
			}
			
			button.setIcon(flags.getImage(ActivationForm.COUNTRY_FLAGS[i]));
			if(button.getIcon() == null) button.setIcon(blankImage);
			String countryCode = ActivationForm.COUNTRY_CODES[i];
			button.addActionListener(ee -> {
				sourceBtn.setIcon(button.getIcon());
				sourceBtn.setText("+" + countryCode);
				sourceBtn.getComponentForm().showBack();
			});
			add(button);
		}
	}
	
	protected void initGlobalToolbar() {
		super.initGlobalToolbar();
		getToolbar().setUIID("BlackToolbar");
	}
	
	void search(String s) {
		
	}
}
