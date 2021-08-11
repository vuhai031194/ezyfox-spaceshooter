package com.tvd12.app.request;


import com.tvd12.ezyfox.binding.annotation.EzyObjectBinding;

import lombok.Data;

@Data
@EzyObjectBinding
public class HelloRequest {

	private String nickName;
	
}
