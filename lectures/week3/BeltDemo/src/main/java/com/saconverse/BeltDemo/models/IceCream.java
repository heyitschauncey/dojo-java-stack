package com.saconverse.BeltDemo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ice_creams")
public class IceCream {
	// ========== Primary Key ===================

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    // ========== Member Variables ==============

    @NotEmpty(message = "Flavor required")
    @Size(min = 2, max = 64, message = "Flavor must be between 2 and 64 characters")
    private String flavor;
    
    @NotEmpty(message = "Topping required")
    @Size(min = 2, max = 64, message = "Topping must be between 2 and 64 characters")
    private String topping;
    
    @NotEmpty(message = "Cone Type required")
    @Size(min = 2, max = 64, message = "Cone Type must be between 2 and 64 characters")
    private String coneType;
    
    @Min(value = 1, message = "Must have at least 1 scoop.")
    @Max(value = 5, message = "Cannot have more than 5 scoops")
    private int numberOfScoops;

    // ========== Data Creation Trackers ========

    @Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

    // ========== Relationships =================

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User creator;

    // ========== Constructors ===================

	public IceCream() {}

    // ========== Data Creation Event ===========

    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
    // ========== Getters and Setters ===========

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public String getConeType() {
		return coneType;
	}

	public void setConeType(String coneType) {
		this.coneType = coneType;
	}

	public int getNumberOfScoops() {
		return numberOfScoops;
	}

	public void setNumberOfScoops(int numberOfScoops) {
		this.numberOfScoops = numberOfScoops;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}
}
