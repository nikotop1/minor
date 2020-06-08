package com.jiuyv.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jiuyv.dto.TemplateDTO;
import com.jiuyv.entity.Template;
import com.jiuyv.repository.TemplateRepository;
import com.jiuyv.util.KeyUtil;
@Service
public class TemplateService {
	@Resource
	TemplateRepository templateRepository;

	//新建
	public Template add(Template template) {
		template.setId(KeyUtil.getId());
		template.setCreateTime(new Date());
		return templateRepository.save(template);
	}
	
	//修改

	public Template update(Template template) {
		return templateRepository.save(template);
	}
	
	
	//删除

	public void delete(String id) {
		 templateRepository.deleteById(id);
	}
	
	//查询

	public Template selectById(String id) {
		 return templateRepository.findById(id).get();
	}

	

}
