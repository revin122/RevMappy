package com.revin122.revmappy;

import com.codename1.ui.Button;
import com.codename1.ui.CN;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

public class FacebookOrGoogleLoginForm extends Form {
	
	public FacebookOrGoogleLoginForm() {
		super(BoxLayout.y());
		Form previous = CN.getCurrentForm();
		getToolbar().setBackCommand("", Toolbar.BackCommandPolicy.AS_ARROW, e -> previous.showBack());
		add(new Label("Choose an account", "FlagButton"));
		Resources r = Resources.getGlobalResources();
		Button facebook = new Button("Facebook", r.getImage("fb.png"), "FlagButton");
		add(facebook);
		Button google = new Button("Google", r.getImage("google.png"), "FlagButton");
		add(google);
	}
}
