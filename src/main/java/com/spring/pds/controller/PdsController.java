package com.spring.pds.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.menu.vo.MenusVo;
import com.spring.movie.vo.MovieVo;
import com.spring.movietime.vo.MovieTimeVo;
import com.spring.pds.service.PdsService;
import com.spring.seats.vo.ScreensSeatsVo;

@Controller
public class PdsController {
	
	@Autowired
	private PdsService pdsService;

	@RequestMapping("/")
	public String home(Model model) {
		model.addAttribute("number", 26);
		return "home";
	}
	
	@RequestMapping("/MovieHome")
	public ModelAndView movieHome() {
		//메뉴불러와야함
		List<MenusVo> menuList = pdsService.getMenus();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/movie/mainPage");
		mv.addObject("menuList", menuList);
		
		return mv;
	}
	
	@RequestMapping("/Movie/Reservation")
	public ModelAndView reservation(@RequestParam HashMap<String,Object> map) {
		//메뉴불러와야함
		List<MenusVo> menuList = pdsService.getMenus();
		
		
		String menuName = (String) map.get("menu_name");
		
		ModelAndView mv = new ModelAndView();
		
		if(menuName.equals("영화")) {			
			mv.setViewName("/movie/movieMain");				
		}
		else if(menuName.equals("예매")) {
			
			//영화
			List<MovieVo> movieList = pdsService.getMovie();
						
			mv.addObject("movieList", movieList);
			mv.setViewName("/movie/reservationMain");				
		}else{
			mv.setViewName("/movie/theaterMain");				
		}
		
		mv.addObject("menuList", menuList);
		return mv;
	}
	
	
	//영화시간 들고오기
	@RequestMapping(value ="/Movie/MovieTime", method=RequestMethod.POST)
	public @ResponseBody List<MovieTimeVo> time(@RequestParam HashMap<String,Object> map) {

		
		List<MovieTimeVo> timeList = pdsService.getMovieTime(map);
		System.out.println(timeList);
		return timeList;
	}
	
	//좌석 선택 페이지 이동하기 /Movie/ChoiceSeat

	@RequestMapping("/Movie/ChoiceSeat")
	public ModelAndView choiceSeat(@RequestParam HashMap<String,Object> map) {
		//메뉴불러와야함
		List<MenusVo> menuList = pdsService.getMenus();
		
		//넘어온 movie_id=MOVIE02&sc_id=&sc_num=&r_num=1 값으로 movie_time_tbl에서 time_id찾기....
		//time_id 찾아서 screens_seats 테이블에서 테이블 예약유무 찾기
		//MovieTimeVo timeVo = pdsService.getMovieId(map);
		List<ScreensSeatsVo> seatsList = pdsService.getSeats(map);
		System.out.println("seatsList:" + seatsList);
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("movie_id",map.get("movie_id"));
		mv.addObject("sc_id",map.get("sc_id"));
		mv.addObject("sc_num",map.get("sc_num"));
		mv.addObject("r_num",map.get("r_num"));
		mv.addObject("movie_id",map.get("movie_id"));
		mv.addObject("menuList", menuList);
		mv.addObject("seatsList", seatsList);
		mv.setViewName("/movie/reservationMain2");
		return mv;
	}


}
