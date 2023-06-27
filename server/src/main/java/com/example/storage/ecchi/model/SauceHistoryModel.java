package com.example.storage.ecchi.model;

import java.util.Date;

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
public class SauceHistoryModel {
	private Integer id;
	private Date dateUpload;
	private Integer sauceId;
	private String sauceName;
}
