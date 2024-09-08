package com.kennethrdzg.crudJPA.videoGameREST.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kennethrdzg.crudJPA.videoGameREST.entity.VideoGame;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class VideoGameDaoImpl implements VideoGameDao{
    private EntityManager entityManager;

    @Autowired
    public VideoGameDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
	@Transactional
	public VideoGame save(VideoGame videoGame) {
		entityManager.persist(videoGame);
		return videoGame;
	}
	
	@Override
	public List<VideoGame> findAll(){
		TypedQuery<VideoGame> query = entityManager.createQuery("FROM VideoGame", VideoGame.class);
        return query.getResultList();
	}
}
