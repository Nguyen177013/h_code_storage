package com.example.storage.ecchi.model;

import java.util.List;

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
public class TypeModel {
	private Integer id;
	private String name;
	private List<SauceTypeModel> sauceType;
}
