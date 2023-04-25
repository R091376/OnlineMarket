package com.khasim.market.dto;

import com.khasim.market.entity.Address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private Long id;
	
	@NotNull(message = "email must not be null")
    private String email;
	
	@NotBlank(message = "username must not be blank")
    private String username;
	
	@NotBlank(message = "first name must not be blank")
    private String firstName;
	
    private String lastName;
    
    @Pattern(regexp="(^$|[0-9]{10})", message="Enter valid mobile number or empty")
    private String phoneNumber;
    
    private Address address;
}
