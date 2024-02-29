package com.jacobebel.jukeboxd.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacobebel.jukeboxd.models.Album;
import com.jacobebel.jukeboxd.repositories.AlbumRepository;

@Service
public class AlbumService {
	@Autowired 
	private AlbumRepository albumRepo;
	
	public Album createAlbum(Album newAlbum) {
		return albumRepo.save(newAlbum);
	}
	
	public List<Album> readAllAlbums() {
		return albumRepo.findAll();
	}
	
	public Album readOneAlbum(Long id) {
		Optional<Album> possibleAlbum = albumRepo.findById(id);
		if(possibleAlbum.isPresent()) {
			return possibleAlbum.get();
		} else {
			return null;
		}
	}
	
	public Album updateAlbum(Album albumToUpdate) {
		return albumRepo.save(albumToUpdate);
	}
	
	public void deleteAlbum(Long id) {
		albumRepo.deleteById(id);
	}
	
}
