package com.jspiders.mediaplayer.dao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.TransactionException;

import com.jspiders.mediaplayer.dto.MusicplayerDTO;

public class SongOperationDAO {
	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;
	private static EntityTransaction entityTransaction;
	static MusicplayerDTO music = new MusicplayerDTO();
	static Scanner sc = new Scanner(System.in);

	private static void openConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("mediaplayer");

		entityManager = entityManagerFactory.createEntityManager();

		entityTransaction = entityManager.getTransaction();
	}

	private static void closeConnecion() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			try {
				entityTransaction.rollback();
			} catch (TransactionException e) {
				System.out.println("Transction already commited");
			}
		}
	}

	public void addSong() {
		System.out.println("Enter Song Id ");
		int id = sc.nextInt();
		System.out.println("Enter Song Name ");
		String songName = sc.next();
		System.out.println("Enter Song Singer Name ");
		String singerName = sc.next();
		System.out.println("Enter the Movie Name ");
		String movieName = sc.next();
		System.out.println("Enter the Composer Name ");
		String composerName = sc.next();
		System.out.println("Enter the Lyrist Name ");
		String lyristName = sc.next();
		System.out.println("Enter Duration of the Song ");
		int duration = sc.nextInt();
		System.out.println("Song Added Successfully...");
		
		openConnection();
		entityTransaction.begin();
		music.setId(id);
		music.setSongName(songName);
		music.setSingerName(singerName);
		music.setMovieName(movieName);
		music.setComposer(composerName);
		music.setLyrist(lyristName);
		music.setDuration(duration);
		entityManager.persist(music);
		entityTransaction.commit();
		closeConnecion();
	}
	
	public void displayAllSongs() {
		System.out.println("*** List of All Songs ***");
		System.out.println(music.getId()+"   "+music.getSongName());
	}
	
	public void removeSong() {
		
	}
	
	public void updateSong() {
		
	}
	
	public void chooseToPlay() {
		
	}
	
	public void playRandomSong() {
		
	}
	
	public void playAllSongs() {
		
	}
}
