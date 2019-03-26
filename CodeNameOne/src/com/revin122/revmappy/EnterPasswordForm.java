package com.revin122.revmappy;

import com.codename1.components.FloatingActionButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

public class EnterPasswordForm extends Form {
	
	public EnterPasswordForm() {
		super(new BorderLayout());
		Form previous = CN.getCurrentForm();
		getToolbar().setBackCommand("", Toolbar.BackCommandPolicy.AS_ARROW, e -> previous.showBack());
		Container container = new Container(BoxLayout.y());
		container.setScrollableY(true);
		container.add(new SpanLabel("Welcome back, signin to continue", "FlagButton"));
		TextField password = new TextField("", "Enter your password", 80, TextField.PASSWORD);
		setEditOnShow(password);
		container.add(password);
		SpanLabel error = new SpanLabel("Password error", "ErrorLabel");
		error.setVisible(false);
		container.add(error);
		add(CENTER, container);
		Button forgot = new Button("I forgot my password", "ForgotPassword");
		Button account = new Button("I don't have an account", "ForgotPassword");
		add(BOTTOM, BoxLayout.encloseY(forgot, account));
		FloatingActionButton fab = FloatingActionButton.createFAB(FontImage.MATERIAL_ARROW_FORWARD);
		fab.bindFabToContainer(this);
		fab.addActionListener(e -> {
//			new MapForm().show();
		});
	}
	
}
