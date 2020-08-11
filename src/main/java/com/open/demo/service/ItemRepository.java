package com.open.demo.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.open.demo.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	// Add item to stock
	@Override
	Item save(Item item);

	/**
	 * List of the inventory items list (item no, name, amount, inventory code)
	 */
	@Override
	List<Item> findAll(Sort sort);
	
	/**
     * Read item details (by item no)
     */
	Item findByNo(Long No);
	
	@Modifying
    @Query("update Item u set u.amount = u.amount - ?1 where u.no = ?2")
    int updateItemWithdraw(Long withdraw, Long no);
	
	@Modifying
    @Query("update Item u set u.amount = u.amount + ?1 where u.no = ?2")
    int updateItemDeposit(Long deposit, Long no);
	
    @Override
    @Modifying
    @Query(value = "delete from Item where no = ?1", nativeQuery = true)
    void deleteById(Long no);
}
