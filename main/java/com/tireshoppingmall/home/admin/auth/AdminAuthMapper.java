package com.tireshoppingmall.home.admin.auth;

import java.util.List;

import com.tireshoppingmall.home.admin.tire.TireDTO;

public interface AdminAuthMapper {

	int authDelete(AuthDTO aDTO);

	int authUpdate(AuthDTO aDTO);

	int getAuthCount(AuthDTO pasing);

	List<AuthDTO> getAuth(AuthDTO pasing);


}
