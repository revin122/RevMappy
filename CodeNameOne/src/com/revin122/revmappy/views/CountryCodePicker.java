package com.revin122.revmappy.views;

import java.io.IOException;

import com.codename1.io.Log;
import com.codename1.l10n.L10NManager;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.animations.Transition;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.util.Resources;
import com.revin122.revmappy.CountryCodeForm;
import com.codename1.sms.activation.ActivationForm;

public class CountryCodePicker extends Button {
	
	private Resources flagsResources;
	
	public CountryCodePicker() {
		setUIID("CountryCodePicker");
		addActionListener(e -> showPickerForm());
		String code = L10NManager.getInstance().getLocale();
		if (code != null) {
			String[] countryCodes;
			if(code.length() == 2) 
				countryCodes = ActivationForm.COUNTRY_ISO2;
			else {
				if(code.length() != 3) return;
				countryCodes = ActivationForm.COUNTRY_ISO3;
			}
			code = code.toUpperCase();
			try {
				flagsResources = Resources.open("/flags.res");
			} catch (IOException e) {
				Log.e(e);
			}
			
			Image icon = Image.createImage(100, 70, 0);
			for(int i = 0; i < countryCodes.length; i++) {
				if(code.equals(countryCodes[i])) {
					setText("+" + ActivationForm.COUNTRY_CODES[i]);
					setIcon(flagsResources.getImage(ActivationForm.COUNTRY_FLAGS[i]));
					if(getIcon() == null) setIcon(icon);
					return;
				}
			}
		}
	}
	
	protected void showPickerForm() {
		final Form f = CN.getCurrentForm();
		final Transition t = f.getTransitionOutAnimator();
		f.setTransitionOutAnimator(CommonTransitions.createEmpty());
		Form tf = new CountryCodeForm(this, flagsResources);
		tf.addShowListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.setTransitionOutAnimator(t);
				f.removeShowListener(this);
			}
		});
		tf.show();
	}
}
