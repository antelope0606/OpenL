package com.open.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.open.demo.domain.Item;

@Component("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }
    
    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }
    
    @Override
    public List<Item> findAll(Sort sort) {
        return itemRepository.findAll(sort);
    }

	@Override
	public Item findByNo(Long no) {
		return itemRepository.findByNo(no);
	}
	
	@Override
	public int withdraw(Long no, Long amount) {
		return itemRepository.updateItemWithdraw(amount, no);
	}
	
	@Override
	public int deposit(Long no, Long amount) {
		return itemRepository.updateItemDeposit(amount, no);
	}
	
	@Override
	public void deleteByNo(Long no) {
		itemRepository.deleteById(no);
	}
    

}
