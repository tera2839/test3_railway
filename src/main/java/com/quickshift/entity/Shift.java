package com.quickshift.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "shift")
public class Shift {
	
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "timeplan_id", referencedColumnName = "id")
	private Timeplan timeplan;
	
	@ManyToOne
	@JoinColumn(name = "member_id", referencedColumnName = "id")
	private Member member;
	
	@ManyToOne
	@JoinColumn(name = "store_id", referencedColumnName = "id")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "calendar_id", referencedColumnName = "id")
	private Calendar calendar;
}
