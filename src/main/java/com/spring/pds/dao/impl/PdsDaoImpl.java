package com.spring.pds.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.menu.vo.MenusVo;
import com.spring.movie.vo.MovieVo;
import com.spring.movietime.vo.MovieTimeVo;
import com.spring.pds.dao.PdsDao;
import com.spring.seats.vo.ScreensSeatsVo;

@Repository("pdsDao")
public class PdsDaoImpl implements PdsDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<MenusVo> getMenus() {
		HashMap<String, Object> map = new HashMap<>();
		sqlSession.selectList("Menus.MenuList",map);
		List<MenusVo> menuList = (List<MenusVo>) map.get("result");
		return menuList;
	}

	@Override
	public List<MovieVo> getMovie() {
		HashMap<String, Object> map = new HashMap<>();
		sqlSession.selectList("Movie.MovieList", map);
		List<MovieVo> movieList = (List<MovieVo>) map.get("result");
		return movieList;
	}


	@Override
	public List<MovieTimeVo> getMovieTime(HashMap<String, Object> map) {
		
		sqlSession.selectList("Movie.MovieTimeList", map);
		System.out.println("map.get(\"result\"):" + map.get("result"));
		List<MovieTimeVo> timeList = (List<MovieTimeVo>) map.get("result");
		System.out.println(timeList);
		return timeList;
	}


	@Override
	public List<ScreensSeatsVo> getSeats(HashMap<String, Object> map) {
		sqlSession.selectList("Screen.SeatsList", map);
		System.out.println(map.get("result"));
		List<ScreensSeatsVo> seatsList = (List<ScreensSeatsVo>) map.get("result");
		System.out.println("seatsList:" + seatsList);
		return seatsList;
	}


}
