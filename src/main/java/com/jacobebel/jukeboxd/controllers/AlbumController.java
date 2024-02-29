package com.jacobebel.jukeboxd.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jacobebel.jukeboxd.models.Album;
import com.jacobebel.jukeboxd.models.User;
import com.jacobebel.jukeboxd.services.AlbumService;
import com.jacobebel.jukeboxd.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AlbumController {
	@Autowired
	private AlbumService albumServ;
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/albums")
	public String dashboard(Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User foundUser = userServ.getUserById(userId);
		model.addAttribute("user", foundUser);
		model.addAttribute("allAlbums", albumServ.readAllAlbums());
		return "home.jsp";
	}
	
	@GetMapping("/albums/new")
	public String newAlbum(Model model, @ModelAttribute("newAlbum") Album newBook) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User foundUser = userServ.getUserById(userId);
		model.addAttribute("user", foundUser);
		return "newAlbum.jsp";
	}
	
	@PostMapping("/albums/new")
	public String addAlbum(@Valid @ModelAttribute("newAlbum") Album newAlbum, BindingResult result, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User foundUser = userServ.getUserById(userId);
		if (result.hasErrors()) {
			model.addAttribute("user", foundUser);
			return "newAlbum.jsp";		
		}
		Album savedAlbum = albumServ.createAlbum(newAlbum);
		return "redirect:/albums/"+savedAlbum.getId();
	}
	
	@GetMapping("/albums/{id}/edit")
	public String editAlbum(@PathVariable Long id, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User foundUser = userServ.getUserById(userId);
		model.addAttribute("user", foundUser);
		model.addAttribute("albumToUpdate", albumServ.readOneAlbum(id));
		return "editAlbum.jsp";
	}
	
	@PutMapping("/albums/{id}/edit")
	public String editAlbum(@PathVariable Long id, @Valid @ModelAttribute("albumToUpdate") Album albumToUpdate, BindingResult result, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User foundUser = userServ.getUserById(userId);
		if (result.hasErrors()) {
			model.addAttribute("user", foundUser);
			return "editAlbum.jsp";		
		}
		Album changedAlbum = albumServ.updateAlbum(albumToUpdate);
		return "redirect:/albums/"+changedAlbum.getId();
	}
	
	@DeleteMapping("/albums/{id}/delete")
	public String deleteAlbum(@PathVariable Long id) {
		albumServ.deleteAlbum(id);
		return "redirect:/albums";
	}
	
	@GetMapping("/albums/{id}")
	public String viewAlbum(@PathVariable Long id, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		User foundUser = userServ.getUserById(userId);
		model.addAttribute("user", foundUser);
		model.addAttribute("album", albumServ.readOneAlbum(id));
		return "viewAlbum.jsp";
	}
	
}
