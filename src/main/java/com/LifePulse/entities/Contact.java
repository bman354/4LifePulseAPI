package com.LifePulse.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Contact {
	private String name;
	private String nickname;
	private int number;
}
