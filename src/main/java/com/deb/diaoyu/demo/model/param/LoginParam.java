package com.deb.diaoyu.demo.model.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginParam {
    @NotBlank(message = "账号不能为空")
    String username;
    @NotBlank(message = "密码不能为空")
    String password;
    @NotBlank(message = "验证码不能为空")
    String verify;
}
