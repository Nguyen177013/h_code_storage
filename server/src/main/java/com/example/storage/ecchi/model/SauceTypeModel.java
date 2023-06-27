package com.example.storage.ecchi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SauceTypeModel {
	private Integer id;
	private Integer sauceId;
	private Integer typeId;
}
