package com.example.demofts.objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
//@Data
@Indexed
//@NoArgsConstructor
@Table(name = "fts_employee")
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private long id;
//	private @Id @GeneratedValue Long id;
//	@Field
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String firstName;
	//@Field
	@Field(index=Index.YES, analyze=Analyze.YES, store=Store.NO)
	private String lastName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

//	public Employee(String firstName, String lastName) {
//		super();
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
}
