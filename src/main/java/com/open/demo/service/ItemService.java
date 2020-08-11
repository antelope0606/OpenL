package com.open.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.open.demo.domain.Item;

public interface ItemService {
	Item save(Item item);

	List<Item> findAll(Sort sort);

	Item findByNo(Long no);
	
	int withdraw(Long no, Long amount);
	
	int deposit(Long no, Long amount);
	
	void deleteByNo(Long no);
}
