package com.shawnaconverse.fullcrud.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dogs") // convention for table names: lowercase plural class name
public class Dog {
	// ========== Primary Key ===================

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    // ========== Member Variables ==============

    @NotNull
    @Size(min = 2, max = 64, message = "Please enter a valid dog name.")
    private String name;

    @NotNull
    @Min(value = 0, message = "Age must be 0 or greater")
    private Integer age;
    
    @NotNull
    @Size(min = 2, max = 64)
    private String hairColor;

    // ========== Data Creation Trackers ========

    @Column(updatable = false) // annotations only apply to the direct line of java code below it
	private Date createdAt;
	private Date updatedAt;


	// ========== Constructors ===================
	
	// ALWAYS MUST HAVE AN EMPTY CONSTRUCTOR 
	// THIS IS REQUIRED BY JPA AND SPRING BOOT
	public Dog() {}


    public Dog(@NotNull @Size(min = 2, max = 64) String name, @NotNull @Min(0) Integer age,
			@NotNull @Size(min = 2, max = 64) String hairColor) {
		super();
		this.name = name;
		this.age = age;
		this.hairColor = hairColor;
	}
	

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


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getHairColor() {
		return hairColor;
	}


	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
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

}
