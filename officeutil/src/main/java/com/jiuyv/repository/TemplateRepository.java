package com.jiuyv.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jiuyv.entity.Template;


public interface TemplateRepository extends JpaRepository<Template,String> {
	public Page<Template> findByNameAndType(Pageable pageable,String name, Integer type);
}
