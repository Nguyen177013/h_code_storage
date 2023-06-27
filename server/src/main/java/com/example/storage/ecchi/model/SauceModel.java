package com.example.storage.ecchi.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SauceModel {
	private Integer id;
	private String name;
	private Integer authorId;
	private String authorName;
	private String sauceUrl;
	private String sauceImage;
	private List<SauceTypeModel> sauceType;
	private List<SauceHistoryModel> sauceHistory;
}
