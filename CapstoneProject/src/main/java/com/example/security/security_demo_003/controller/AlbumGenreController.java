package com.example.security.security_demo_003.controller;

import java.text.ParseException;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.security.security_demo_003.model.User;
import com.example.security.security_demo_003.service.UserService;
import com.example.security.security_demo_003.model.AlbumGenre;
import com.example.security.security_demo_003.service.AlbumGenreService;

@Controller
public class AlbumGenreController {

	@Autowired
	UserService uService;
	
	@Autowired
	AlbumGenreService service;
	
	@GetMapping(value="/")
	public String showIndex(ModelMap model, Principal principal) throws ParseException {
		if(principal != null) {
			String n = principal.getName();
			User user = uService.findUserByUserName(n);//.findByUsername(n);
			
				
			int[] cart = uService.getCart(user);
			if(cart!=null) {
			List<AlbumGenre> list = new ArrayList<>();
			for(int i=0; i<cart.length; i++) list.add(service.find(cart[i]));
			Iterator<AlbumGenre> it = list.iterator();
			model.put("cart", it);}
			
		}
		return "index";
	}
	
	@PostMapping(value="/create")
	public String createAlbum(ModelMap model, @RequestParam String name, @RequestParam String artist, @RequestParam String price, 
			@RequestParam Date release_date, @RequestParam String genre_name) throws ParseException {
		service.create(new AlbumGenre(name, artist, price, release_date, genre_name));
		model.put("message", "Album has been added");
		return "redirect:/readadmin";
	}
	
	@GetMapping(value="/readadmin")
	public String readTableAdmin(ModelMap model, Principal principal) throws ParseException {
		String n = principal.getName();
		User user = uService.findUserByUserName(n);//.findByUsername(n);
		int[] cart = uService.getCart(user);
		List<AlbumGenre> list = new ArrayList<>();
		for(int i=0; i<cart.length; i++) list.add(service.find(cart[i]));
		Iterator<AlbumGenre> it = list.iterator();
		model.put("cart", it);
		model.put("albums", service.read());
		return "adminlist";
	}
	
	@GetMapping(value="/readuser")
	public String readTableUser(ModelMap model, Principal principal) throws ParseException {
		String n = principal.getName();
		User user = uService.findUserByUserName(n);//.findByUsername(n);
		int[] cart = uService.getCart(user);
		List<AlbumGenre> list = new ArrayList<>();
		for(int i=0; i<cart.length; i++) list.add(service.find(cart[i]));
		Iterator<AlbumGenre> it = list.iterator();
		model.put("cart", it);
		model.put("albums", service.read());
		return "products";
	}
	
	@PostMapping(value="/update")
	public String updateAlbum(ModelMap model, @RequestParam int id, @RequestParam String name, @RequestParam String artist, @RequestParam String price, 
			@RequestParam Date release_date, @RequestParam String genre_name) throws ParseException {
		service.update(id, name, artist, price, release_date, genre_name);
		model.put("message", "Album has been updated");
		return "redirect:/readadmin";
	}
	
	@PostMapping(value="/delete")
	public String deleteAlbum(ModelMap model, @RequestParam int id) throws ParseException {
		service.delete(id);
		model.put("message", "The album has been deleted");
		return "redirect:/readadmin";
	}
	
	@PostMapping(value="/search")
	public String searchAlbums(ModelMap model, Principal principal, @RequestParam String column, @RequestParam String value) throws ParseException {
		String n = principal.getName();
		User user = uService.findUserByUserName(n);//.findByUsername(n);
		int[] cart = uService.getCart(user);
		List<AlbumGenre> list = new ArrayList<>();
		for(int i=0; i<cart.length; i++) list.add(service.find(cart[i]));
		Iterator<AlbumGenre> it = list.iterator();
		model.put("cart", it);
		List<AlbumGenre> dis = service.search(column, value);
		for(AlbumGenre x : dis) {
			System.out.println(x.toString());
		}
		model.put("albums", service.search(column, value));
		return "products";
	}
	
	@GetMapping("/edit")
    public String showEditPage(ModelMap model, @RequestParam int id){ 
      AlbumGenre album= service.find(id);
    	model.addAttribute("album",album);
    	return "edit";
    }
	
	@GetMapping("/details")
    public String showDetailsPage(ModelMap model, Principal principal, @RequestParam int id){ 
		String n = principal.getName();
		User user = uService.findUserByUserName(n);//.findByUsername(n);
		int[] cart = uService.getCart(user);
		List<AlbumGenre> list = new ArrayList<>();
		for(int i=0; i<cart.length; i++) list.add(service.find(cart[i]));
		Iterator<AlbumGenre> it = list.iterator();
		model.put("cart", it);
      AlbumGenre album= service.find(id);
    	model.put("album",album);
    	return "details";
    }
	
}
