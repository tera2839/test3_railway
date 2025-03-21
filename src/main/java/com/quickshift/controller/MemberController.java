//package com.quickshift.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.quickshift.Session.AdminSession;
//import com.quickshift.Session.MemberSession;
//import com.quickshift.entity.Shift;
//import com.quickshift.entity.Store;
//import com.quickshift.service.AdminService;
//
//import lombok.RequiredArgsConstructor;
//
//@Controller
//@RequiredArgsConstructor
//public class MemberController {
//	
//	private final MemberSession memberSession;
//	private final AdminSession session;
//	private final AdminService service;
//	private final AuthenticationManager authenticationManager; 
//
//	/*------------------------------------------------------------
//	メンバー
//	------------------------------------------------------------*/
//	
//	@GetMapping("/")
//	public String showMemberLogin(
//			@RequestParam("storeId") Long storeId,
//			Model model
//			) {
//		
//		Store store = service.findByStoreId(storeId);
//		session.setStore(store);
//		model.addAttribute("storeName",store.getName());
//		
//		return "memberLogin";
//		
//	}
//	
//	@PostMapping("/memberLogin")
//	public String completeMemberLogin(
//			BindingResult br		
//			) {
//		
//		long l = 1;
//		Long id = (Long)l ;
//		Store store = service.findByStoreId(id);
//		
//		if(store.getId() != id) {
//			br.rejectValue("error", "pass", "パスワードが違います");
//		}
//		if(br.hasErrors()) {
//			return "memberLogin";
//		}
//		
//		memberSession.setId(id);
//		
//		return "redirect:/memberSelectName";
//	}
//	
//	@GetMapping("/memberSelectName")
//	public String resultMemberselectName(
//			
//			) {
//		
//		
//		//List<Member> members = service.findMemberByStore();
//		return "memberSelectName";
//	}
//	
//	@PostMapping("/memberHome")
//	public String showMemberSelectName() {
//		
//		return "memberHome";
//	}
//	
//	/*------------------------------------------------------------
//	シフト確認
//	------------------------------------------------------------*/
//	
//	@GetMapping("/checkHome")
//	public String showCheckHome(
//			Model model
//			) {
//		
//		List<Shift> shifts = service.findShiftByStore(session.getStore());
//		List<String> months = new ArrayList<String>();
//		for(Shift shift : shifts) {
//			String str = shift.getCalendar().getCYear() + ":" + shift.getCalendar().getCMonth();
//			if(!months.contains(shift)) {
//				months.add(str);
//			}
//		}
//		
//		model.addAttribute("months", months);
//		
//		return "checkHome";
//	}
//	
//	@PostMapping("/checkShift")
//	public String showCheckShift(
//			Model model,
//			@RequestParam("month") String month
//			) {
//		
//		List<Shift> shifts = service.findByStoreId(session.getStore());
//		
//		model.addAttribute("shifts",shifts);
//		
//		return "checkShift";
//	}
//	
//	/*------------------------------------------------------------
//	シフト提出、編集
//	------------------------------------------------------------*/
//	
//	@GetMapping("/memberEditHome")
//	public String showMemberEditHome(
//			Model model
//			) {
//		
//		List<Shift> shifts = service.findByStoreId(session.getStore());
//		List<String> months = new ArrayList<String>();
//		for(Shift shift : shifts) {
//			String str = shift.getCalendar().getCYear() + ":" + shift.getCalendar().getCMonth();
//			if(!months.contains(shift))
//				months.add(str);
//		}
//		
//		model.addAttribute("months",months);
//		
//		return "memberEditHome";
//	}
//	
//	@GetMapping("/memberEdit")
//	public String showMemberEdit(
//			Model model
//			) {
//		
//		List<Shift> shifts = service.findByStoreId(session.getStore());
//		List<String> tmpshift = new ArrayList<>();
//		for(Shift shift : shifts) {
//			String str = shift.getCalendar().getCDate() + ";" + shift.getTimeplan() + ":" + shift.getMember();
//			tmpshift.add(str);
//		}
//		
//		model.addAttribute("tmpshift",tmpshift);
//		
//		return "memberEdit";
//	}
//	
//	@PostMapping("/confirmMemberEdit")
//	public String showConfirmMemberEdit(
//			Model model
//			) {
//		
//		List<Shift> shifts = service.findByStoreId(session.getStore());
//		
//		model.addAttribute("shifts",shifts);
//		
//		return "/confirmMemberEdit";
//	}
//	
//	@PostMapping("/completeMemberEdit")//データベースに保存するための操作 save
//	public String showCompleteMemberEdit(
//			
//			@RequestParam("Date") String Date,
//			@RequestParam("Timeplan") String Timeplan,
//			@RequestParam("Member") String Member,
//			Model model
//			) {
//		Shift shift = new Shift();
//		shift.setDate(Date);
//		shift.setTimeplan(Timeplan);
//		shift.setMember(Member);
//		
//		service.saveShift(Date,Timeplan,Member);
//		
//		return "redirect:/resultMemberEdit";
//	}
//	
//	@PostMapping("/resultMemberEdit")
//	public String showResultMemberEdit() {
//		return"/resultMemberEdit";
//	}
//	
//}
