package online.zhaopei.myproject.service.gjent.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import online.zhaopei.myproject.domain.gjent.PersonalInfo;
import online.zhaopei.myproject.mapper.gjent.PersonalInfoMapper;
import online.zhaopei.myproject.service.gjent.PersonalInfoService;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2479664822732948689L;

	@Autowired
	private PersonalInfoMapper personalInfoMapper;
	
	@Override
	public PersonalInfo getPersonById(String id) {
		return this.personalInfoMapper.getPersonById(id);
	}

}