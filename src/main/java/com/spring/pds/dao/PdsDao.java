package com.spring.pds.dao;

import java.util.HashMap;
import java.util.List;

import com.spring.menu.vo.MenusVo;
import com.spring.movie.vo.MovieVo;
import com.spring.movietime.vo.MovieTimeVo;
import com.spring.seats.vo.ScreensSeatsVo;

public interface PdsDao {

	List<MenusVo> getMenus();

	List<MovieVo> getMovie();

	List<MovieTimeVo> getMovieTime(HashMap<String, Object> map);


	List<ScreensSeatsVo> getSeats(HashMap<String, Object> map);

}
