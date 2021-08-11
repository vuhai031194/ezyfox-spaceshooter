package com.tvd12.plugin.service;

import com.tvd12.common.service.CommonService;
import com.tvd12.plugin.config.PluginConfig;
import com.tvd12.ezyfox.bean.annotation.EzyAutoBind;
import com.tvd12.ezyfox.bean.annotation.EzySingleton;

@EzySingleton
public class WelcomeService {

	@EzyAutoBind
	private PluginConfig config;
	
	@EzyAutoBind
	private CommonService commonService;
	
	public String welcome(String username) {
		return config.getWelcomePrefix() + " " + username + "!";
	}
	
}
