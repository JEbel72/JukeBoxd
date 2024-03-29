package com.jacobebel.jukeboxd.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jacobebel.jukeboxd.models.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {
	List<Album> findAll();
	
}
