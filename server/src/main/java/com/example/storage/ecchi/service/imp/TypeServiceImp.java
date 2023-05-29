package com.example.storage.ecchi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.storage.ecchi.entity.Type;
import com.example.storage.ecchi.model.TypeModel;
import com.example.storage.ecchi.repository.TypeRepository;
import com.example.storage.ecchi.service.TypeService;
import com.example.storage.ecchi.transformation.TypeTransformer;

@Service
public class TypeServiceImp implements TypeService {
	@Autowired
	TypeRepository repository;

	@Autowired
	TypeTransformer transformer;
	@Override
	public List<TypeModel> listTypes() {
		List<Type> listType = (repository.getTypes());
		// TODO Auto-generated method stub
		return transformer.typeEntityToModel(listType);
	}

}
