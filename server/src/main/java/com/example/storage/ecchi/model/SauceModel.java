package com.example.storage.ecchi.model;

import com.example.storage.ecchi.entity.Author;
import com.example.storage.ecchi.entity.Type;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SauceModel {
	private String name;
	private Type type;
	private Author author;
}
