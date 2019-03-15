package com.revin122.revmappy;

import com.codename1.ui.Button;
import com.codename1.ui.CN;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.util.SuccessCallback;

public class CommonCode {
	
	public static void initBlackForm(Form f, String title, SuccessCallback<String> searchResults) {
		Form backForm = CN.getCurrentForm();
		f.getContentPane().setScrollVisible(false);
		Button back = new Button("", "TitleCommand");
		back.addActionListener(e -> backForm.showBack());
		back.getAllStyles().setFgColor(0xffffff);
		
		FontImage.setMaterialIcon(back, FontImage.MATERIAL_ARROW_BACK);
		f.setBackCommand(new Command("") {
			public void actionPerformed(ActionEvent event) {
				backForm.showBack();
			}
		});
		
		Container searchBack = null;
		if(searchResults != null) {
			Button searchBtn = new Button("", "TitleCommand");
			searchBtn.getAllStyles().setFgColor(0xffffff);
			FontImage.setMaterialIcon(searchBtn, FontImage.MATERIAL_SEARCH);
			searchBtn.addActionListener(e -> {});
			searchBack = BorderLayout.north(BorderLayout.centerCenterEastWest(null, searchBtn, back));
		} else {
			searchBack = BorderLayout.north(BorderLayout.centerCenterEastWest(null, null, back));
		}
		Label titleLabel = new Label(title, "WhiteOnBlackTitle");
		titleLabel.getAllStyles().setMarginTop(back.getPreferredH());
		titleLabel.getAllStyles().setMarginUnit(com.codename1.ui.plaf.Style.UNIT_TYPE_PIXELS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS);
		f.getToolbar().setTitleComponent(LayeredLayout.encloseIn(searchBack, titleLabel));
		f.getAnimationManager().onTitleScrollAnimation(titleLabel.createStyleAnimation("WhiteOnBlackTitleLeftMargin", 200));
		f.setTransitionInAnimator(CommonTransitions.createCover(CommonTransitions.SLIDE_VERTICAL, false, 300));
		f.setTransitionOutAnimator(CommonTransitions.createUncover(CommonTransitions.SLIDE_VERTICAL, true, 300));
	}
	
}
