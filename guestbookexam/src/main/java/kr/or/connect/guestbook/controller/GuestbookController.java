package kr.or.connect.guestbook.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.guestbook.dto.Guestbook;
import kr.or.connect.guestbook.service.GuestbookService;

@Controller
public class GuestbookController {
	@Autowired
	GuestbookService guestbookService;

	@GetMapping(path = "/list")
	public String list(@RequestParam(name = "start", required = false, defaultValue = "0") int start, ModelMap model,
			HttpServletRequest request, HttpServletResponse response) {

		String value = null;
		boolean find = false;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("count".equals(cookie.getName())) {
					value = cookie.getValue();
					find = true;
				}
			}
		}

		if (!find) {
			value = "1";
		} else {
			try {
				int i = Integer.valueOf(value);
				value = Integer.toString(i + 1);
			} catch (Exception e) {
				value = "1";
			}
		}
		
		Cookie cookie = new Cookie("count", value);
		cookie.setMaxAge(60 * 60 * 24 * 365);
		cookie.setPath("/"); // 적용 범위(경로)를 지정하는 것은 상상도 못했다. 
		response.addCookie(cookie);

		List<Guestbook> list = guestbookService.getGuestbooks(start);

		int count = guestbookService.getCount();
		int pageCount = count / GuestbookService.LIMIT;
		if (count % GuestbookService.LIMIT > 0)
			pageCount++;

		List<Integer> pageStartList = new ArrayList<Integer>();
		for (int i = 0; i < pageCount; i++) {
			pageStartList.add(i * GuestbookService.LIMIT);
		}

		model.addAttribute("list", list);
		model.addAttribute("count", count);
		model.addAttribute("pageStartList", pageStartList);
		model.addAttribute("cookieCount", value);
		return "list";
	}

	@PostMapping("/write")
	public String write(@ModelAttribute Guestbook guestbook, HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		System.out.println("clientIp : " + clientIp);
		guestbookService.addGuestbook(guestbook, clientIp);
		return "redirect:list";

	}

}
