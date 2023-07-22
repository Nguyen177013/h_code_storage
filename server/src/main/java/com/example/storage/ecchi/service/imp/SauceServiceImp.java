package com.example.storage.ecchi.service.imp;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.Singleton;
import com.cloudinary.utils.ObjectUtils;
import com.example.storage.ecchi.entity.Sauce;
import com.example.storage.ecchi.entity.SauceHistory;
import com.example.storage.ecchi.entity.SauceType;
import com.example.storage.ecchi.model.SauceModel;
import com.example.storage.ecchi.repository.SauceHistoryRepository;
import com.example.storage.ecchi.repository.SauceRepository;
import com.example.storage.ecchi.repository.SauceTypeRepository;
import com.example.storage.ecchi.service.SauceService;
import com.example.storage.ecchi.transformation.SauceTransformer;

@Service
public class SauceServiceImp implements SauceService {

	@Autowired
	SauceRepository sauceRepository;

	@Autowired
	SauceTransformer transformer;

	@Autowired
	SauceTypeRepository sauceTypeRepository;

	@Autowired
	SauceHistoryRepository sauceHistoryRepository;

	@Override
	public List<SauceModel> getSauce(Integer no) {
		Sort sort = Sort.by("id");
		return sauceRepository.getAllSauce(PageRequest.of(no, 2, sort)).map(ele -> transformer.apply(ele)).getContent();
	}

	@Override
	public void addSauce(SauceModel sauceModel) {
	}

	@Override
	public void editSauce(int id, SauceModel sauceModel) {
	}

	@Override
	public void deleteSauce(int id) {
		sauceRepository.deleteById(id);
	}

	@Override
	public SauceModel getSauceById(int id) {
		return null;
	}

	@Override
	public boolean uploadImage(MultipartFile[] files) {
		String cloudUrl = System.getenv("CLOUD_URL");
		Cloudinary cloudinary = new Cloudinary(cloudUrl);
		cloudinary.config.secure = true;
		for (MultipartFile file : files) {
			try {
				Map<?, ?> uploadFile = cloudinary.uploader().upload(file.getBytes(),
						ObjectUtils.asMap("folder", "/HImage/"));
				String fileName = uploadFile.get("original_filename").toString();
				String secretUrl = uploadFile.get("secure_url").toString();
				String public_id = uploadFile.get("public_id").toString();
				SauceType sauceType = new SauceType(); 
				sauceType.setType(sauceTypeRepository.getImageType());
				Sauce sauce = new Sauce();
				sauce.setName(fileName);
				sauce.setSauceUrl(secretUrl);
				sauce.setSauceImage(public_id);
				SauceHistory sauceHistory = new SauceHistory();
				sauceHistory.setDateUpload(new Date());
				sauce.setSauceType(List.of(sauceType));
				sauce.setSauceHistory(List.of(sauceHistory));
				sauceRepository.save(sauce);
				sauceHistory.setSauce(sauce);
				sauceType.setSauce(sauce);
				sauceTypeRepository.save(sauceType);
				sauceHistoryRepository.save(sauceHistory);
			} catch (IOException e) {
				return false;
			}
		}
		return true;
	}

}
