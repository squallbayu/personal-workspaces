package org.squallbayu.app.shoppinglist.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.squallbayu.app.shoppinglist.model.Item;
import org.squallbayu.app.shoppinglist.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping("additem")
	public ModelAndView getForm(@ModelAttribute Item item) {
		return new ModelAndView("additem");
	}
	
	@RequestMapping(value="craate", method=RequestMethod.POST)
	public ModelAndView registerUser(@ModelAttribute("item") Item item) {
		itemService.save(item);
		return new ModelAndView("redirect:listitem");
	}

	@RequestMapping("listitem")
	public ModelAndView getList() {
		return new ModelAndView("listitem", "shoppingListTable",
				itemService.findAll());
	}

	@RequestMapping("delete")
	public ModelAndView deleteUser(@RequestParam Long id) {
		itemService.delete(id);
		return new ModelAndView("redirect:listitem");
	}

	@RequestMapping("edititem")
	public ModelAndView editUser(@RequestParam Long id,
			@ModelAttribute Item employee) {
		Item item = itemService.findById(id);
		return new ModelAndView("edititem", "item", item);
	}

	@RequestMapping("update")
	public ModelAndView updateUser(@ModelAttribute Item item) {
		itemService.save(item);
		return new ModelAndView("redirect:listitem");
	}
	//
	// @RequestMapping(value = "/listitem", method = RequestMethod.GET)
	// public ModelAndView renderTable() {
	// return new ModelAndView("listitem", "shoppingListTable",
	// itemService.findAll());
	// }
	//
	// @RequestMapping(value = "/delete", method = RequestMethod.GET)
	// public String deleteItem(
	// @RequestParam(value = "id", required = true) Long id) {
	// itemService.delete(id);
	// return "redirect:/listitem.html";
	// }
	//
	// @RequestMapping(value = "/edit", method = RequestMethod.GET)
	// public ModelAndView editItem(@RequestParam long id,
	// @ModelAttribute Item item) {
	// Item itemFind = itemService.findById(id);
	// return new ModelAndView("edititem", "item", itemFind);
	// }
	//
	// @RequestMapping(value = "/add", method = RequestMethod.GET)
	// public String addItem(@Valid @ModelAttribute("item") Item item,
	// BindingResult result, Model model) {
	// return "additem";
	// }
	//
	// @RequestMapping(value = "update", method = RequestMethod.POST)
	// public String updateItem(@Valid @ModelAttribute("item") Item item,
	// BindingResult result, Model model) {
	// if (result.hasErrors()) {
	// return "additem";
	// // } else if(itemService.find(item.getId()) != null) {
	// // model.addAttribute("message", "Item exists. Try another Item.");
	// // return "additem";
	// } else {
	// itemService.save(item);
	// model.addAttribute("message", "Update item completed.");
	// return "redirect:listitem.html";
	// }
	// }
}
