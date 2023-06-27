package com.example.storage.ecchi.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="sauce")
public class Sauce {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	private String sauceUrl;
	
	private String sauceImage;
	
	@ManyToOne
	@JoinColumn(name = "author_id")
	private Author author;
	
	@OneToMany(mappedBy = "sauce", fetch = FetchType.LAZY)
	List<SauceHistory> sauceHistory;
	
	@OneToMany(mappedBy = "sauce", fetch = FetchType.LAZY)
	List<SauceType> sauceType;
}
