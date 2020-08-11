package com.open.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.open.demo.domain.Item;
import com.open.demo.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/item")
@Api(value = "Item Controller", tags = { "Item interface" })
public class ItemController {

	@Autowired
    private ItemService itemService;
	
	@ApiOperation(value = "save an item")
    @RequestMapping(value = "/save/{no}/{name}/{amount}/{inventoryCode}",method = RequestMethod.GET)
//	@ApiResponses(value = { @ApiResponse(code = 1000, message = "success"), @ApiResponse(code = 1001, message = "fail"),
//            @ApiResponse(code = 1002, response = Item.class,message = "lack parameter") })
    @Transactional
    public Item saveItem(@ApiParam(value = "item no", required = true) @PathVariable Long no,
    		@ApiParam(value = "item name", required = true) @PathVariable String name,
    		@ApiParam(value = "item amount", required = true) @PathVariable Long amount,
    		@ApiParam(value = "inventory code", required = true) @PathVariable String inventoryCode) {
        Item item = new Item();
        item.setNo(no);
        item.setName(name);
        item.setAmount(amount);
        item.setInventoryCode(inventoryCode);
        return itemService.save(item);
    }
    
	@ApiOperation(value = "find all items")
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Item> findAll() {
        return itemService.findAll(Sort.by(Sort.Direction.ASC, "no"));
    }
	
	@ApiOperation(value = "Read item details (by item no)")
    @RequestMapping(value = "/findByNo/{no}", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public Item findByNo(@ApiParam(value = "no", required = true) @PathVariable(name = "no")  Long no) {
        return itemService.findByNo(no);
    }
	
	@ApiOperation(value = "Withdrawal quantity of a specific item from stock")
    @RequestMapping(value = "/withdraw/{no}/{amount}", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public Item withdraw(@ApiParam(value = "no", required = true) @PathVariable(name = "no")  Long no,
    		@ApiParam(value = "item amount", required = true) @PathVariable Long amount) {
		itemService.withdraw(no, amount);
        return itemService.findByNo(no);
    }
	
	@ApiOperation(value = "Deposit quantity of a specific item to stock")
    @RequestMapping(value = "/deposit/{no}/{amount}", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public Item deposit(@ApiParam(value = "no", required = true) @PathVariable(name = "no")  Long no,
    		@ApiParam(value = "item amount", required = true) @PathVariable Long amount) {
		itemService.deposit(no, amount);
        return itemService.findByNo(no);
    }
	
	@ApiOperation(value = "Delete an item from stock  ")
    @RequestMapping(value = "/delete/{no}", method = RequestMethod.GET)
    @Transactional(readOnly = true)
    public void delete(@ApiParam(value = "no", required = true) @PathVariable(name = "no")  Long no) {
		itemService.deleteByNo(no);
    }
}
