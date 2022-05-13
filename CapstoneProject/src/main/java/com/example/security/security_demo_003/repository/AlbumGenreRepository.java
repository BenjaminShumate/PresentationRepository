package com.example.security.security_demo_003.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.security.security_demo_003.model.AlbumGenre;
@Repository
public interface AlbumGenreRepository extends CrudRepository<AlbumGenre, Integer>{

}
