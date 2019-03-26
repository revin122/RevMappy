package com.revin122.revmappy;

import com.codename1.components.SpanButton;
import com.codename1.ui.Button;
import com.codename1.ui.CN;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Effects;
import com.codename1.ui.util.Resources;
import com.revin122.revmappy.views.CountryCodePicker;

public class LoginForm extends Form {
	
	public LoginForm() {
		super(new BorderLayout());
		
		Label squareLogo = new Label("", Resources.getGlobalResources().getImage("logo.png"), "SquareLogo") {
			protected Dimension calcPreferredSize() {
				Dimension size = super.calcPreferredSize();
				size.setHeight(size.getWidth());
				return size;
			}
		};
		
		Label placeholder = new Label();
		Container logo = LayeredLayout.encloseIn(placeholder,
				BorderLayout.centerAbsolute(squareLogo));
		
		CN.startThread(() -> {
			final Image shadow = Effects.squareShadow(squareLogo.getPreferredW(), squareLogo.getPreferredH(), CN.convertToPixels(14), 0.35f);
			CN.callSerially(() -> {
				logo.replace(placeholder, BorderLayout.centerAbsolute(new Label(shadow, "Container")), null);
				revalidate();
			});
		}, "Shadow Maker").start();
		
		logo.setUIID("LogoBackground");
		add(CENTER, logo);
		Label getMoving = new Label("Vroom with RevMappy", "VroomRevMappy");
		CountryCodePicker ccButton = new CountryCodePicker() {
			protected void showPickerForm() {
				new EnterMobileNumberForm().show();
			}
		};
		
		SpanButton phoneNumber = new SpanButton("Enter your number", "PhoneNumberHint");
		phoneNumber.getTextComponent().setColumns(80);
		phoneNumber.getTextComponent().setRows(2);
		phoneNumber.getTextComponent().setGrowByContent(false);
		phoneNumber.setUIID("Container");
		phoneNumber.addActionListener(e -> new EnterMobileNumberForm().show());
		Container phonePicking = BorderLayout.centerCenterEastWest(phoneNumber, null, ccButton);
		phonePicking.setUIID("Separator");
		Button social = new Button("Or connect with social", "ConnectWithSocialButton");
		social.addActionListener(e -> new FacebookOrGoogleLoginForm().show());
		add(BOTTOM, BoxLayout.encloseY(getMoving, phonePicking, social));
	}
	
	@Override
	protected boolean shouldPaintStatusBar() {
		return false;
	}
	
	@Override
	protected void initGlobalToolbar() {
		
	}
}
