package com.spring.pds.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.menu.vo.MenusVo;
import com.spring.movie.vo.MovieVo;
import com.spring.movietime.vo.MovieTimeVo;
import com.spring.pds.dao.PdsDao;
import com.spring.pds.service.PdsService;
import com.spring.seats.vo.ScreensSeatsVo;

@Service("pdsService")
public class PdsServiceImpl implements PdsService {

	@Autowired
	private PdsDao pdsDao;
	
	@Override
	public List<MenusVo> getMenus() {
		List<MenusVo> menuList = pdsDao.getMenus();
		return menuList;
	}

	@Override
	public List<MovieVo> getMovie() {
		List<MovieVo> movieList = pdsDao.getMovie();
		return movieList;
	}

	@Override
	public List<MovieTimeVo> getMovieTime(HashMap<String, Object> map) {
		List<MovieTimeVo> timeList = pdsDao.getMovieTime(map);
		return timeList;
	}

/*	@Override
	public MovieTimeVo getMovieId(HashMap<String, Object> map) {
		MovieTimeVo timeVo = pdsDao.getMovieId(map);
		return timeVo;
	}*/

	@Override
	public List<ScreensSeatsVo> getSeats(HashMap<String, Object> map) {
		List<ScreensSeatsVo> seatsList = pdsDao.getSeats(map);
		return seatsList;
	}

}
