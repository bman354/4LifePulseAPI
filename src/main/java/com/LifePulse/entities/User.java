package com.LifePulse.entities;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class User {
	private String firstName;
	private String lastName;
	private String email;
	private Optional<String> phone;
	private UUID uuid;
	private List<Contact> contacts;
}
