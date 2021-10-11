package com.saconverse.kennel.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dogs")
public class Dog {
	// ========== Primary Key ===================

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    // ========== Member Variables ==============

    @Size(min = 2, message = "Not Enough! Do Better!")
    private String name;
    
    @NotNull(message = "Must enter in an age")
    @Min(0)
    private Integer age;
    
    @Size(min = 2, message = "Must enter hair color")
    private String hairColor;
    
    // ========== Relationships =================
    
    @OneToMany(mappedBy = "dog", fetch = FetchType.LAZY)
    private List<Collar> collars;
    // dog.getCollars();
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "dogs_toys",
        joinColumns = @JoinColumn(name = "dog_id"),
        inverseJoinColumns = @JoinColumn(name = "toy_id")
    )
    private List<Toy> toys;

    // ========== Data Creation Trackers ========

    @Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;

    // ========== Constructors ===================

	public Dog() {}

    public Dog(@Size(min = 2) String name, @Min(0) Integer age, @Size(min = 2) String hairColor) {
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

	public List<Collar> getCollars() {
		return collars;
	}

	public void setCollars(List<Collar> collars) {
		this.collars = collars;
	}

	public List<Toy> getToys() {
		return toys;
	}

	public void setToys(List<Toy> toys) {
		this.toys = toys;
	}
}
