package com.stocks.api;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.emuzic.muzic.api.CUtility;
import com.emuzic.muzic.entitybeans.Album;
import com.emuzic.muzic.entitybeans.Music;
import com.emuzic.muzic.entitybeans.Users;

@RestController
public class StockController {
	
	@GetMapping("/api/stocks")
	public String getStock() {
		return null;
		
	}
	@GetMapping("/api/stocks/{amount}")
	public List<Stock> getAount() {
		return null;
		
	}
	
		
	@GetMapping("music/search/{name}")
	@ResponseBody
	public List<Music> findMusic(@PathVariable("name") String name) {
		if(CUtility.isNull(name)){
			return null;
		}
		List<Music> music = music_repo.findAllByName(name);
		return music;
		
	}

}
