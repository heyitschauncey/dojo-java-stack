package com.saconverse.FullCrud.models;

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
import javax.validation.constraints.Size;

@Entity
@Table(name = "sidekicks")
public class SideKick {
	// ========== Primary Key ===================

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    // ========== Member Variables ==============

    @Size(min = 2, message = "Name must be at least 2 characters.")
    private String name;
    
    @Size(min = 2, message = "Super Power must be at least 2 characters.")
    private String superPower;
    
    @Size(min = 2, message = "Weakness must be at least 2 characters.")
    private String weakness;

    // ========== Data Creation Trackers ========

    @Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

    // ========== Relationships =================

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "superhero_id")
	private SuperHero superHero;

    // ========== Constructors ===================

	public SideKick() {}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSuperPower() {
		return superPower;
	}

	public void setSuperPower(String superPower) {
		this.superPower = superPower;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
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

	public SuperHero getSuperHero() {
		return superHero;
	}

	public void setSuperHero(SuperHero superHero) {
		this.superHero = superHero;
	}
	
}
