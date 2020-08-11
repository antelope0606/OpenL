package com.open.demo.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "item")
public class Item implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;//主键

    @Column(nullable = false)
    private String name;//name
    
    @Column(nullable = false)
    private Long amount;//amount
    
    @Column(nullable = false)
    private String inventoryCode;//inventory ode

    public Item() {
    }
    
    public Item(Long no, String name, Long amount, String inventoryCode) {
        this.no = no;
        this.name = name;
        this.amount = amount;
        this.inventoryCode = inventoryCode;
    }

    public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getInventoryCode() {
		return inventoryCode;
	}

	public void setInventoryCode(String inventoryCode) {
		this.inventoryCode = inventoryCode;
	}

	@Override
    public String toString() {
        return "Item{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", amount='" + amount + '\'' +
                ", inventory code=" + inventoryCode +
                '}';
    }
}