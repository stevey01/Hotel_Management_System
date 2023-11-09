package com.example.staff.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

	@Id
	
	private Long id;
	
	@NotBlank(message="Name cannot be blank")
	@Column(name="Name")
	private String name;
	
	@Column(name="Address")
	@NotBlank(message="Address cannot be blank")
	private String address;
	@Column(name="Salary")
	 @Min(value=10000, message = "Salary must be atleast 10000.00")
    @Max(value=40000, message = "Salary should not be greater than 40000.00")
	private long Salary;
	@Column(name="Occupation")
	@NotBlank(message="Occupation cannot be blank")
	private String Occupation;
	@Column(name="Email")
	@NotBlank(message="check_in_date cannot be blank")
	@Email(message = "Please enter a valid email Id", regexp="^[a-zA-Z0-9._-]+@[a-zA-Z0-9-]+\\.[a-zA-Z.]{2,5}")
	private String email;
	
	
	
}