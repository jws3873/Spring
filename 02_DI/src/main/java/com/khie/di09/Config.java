package com.khie.di09;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
	

@Configuration
public class Config {
	
	@Bean
	public Player player1() {
		
		ArrayList<String> position = new ArrayList<String>();
		
		position.add("4번타자");
		position.add("1루수");
		
		Player player = new Player("추신수", 38, position);
		
		player.setWeight(100);
		player.setHeight(188);
		
		return player;
		
	}
	
	@Bean
	public Player player2() {
		
		ArrayList<String> position = new ArrayList<String>();
		
		position.add("9번타자");
		position.add("투수");
		
		Player player = new Player("류현진", 33, position);
		
		player.setWeight(110);
		player.setHeight(190);
		
		return player;
	}
	
	public Player player3() {
		ArrayList<String> position = new ArrayList<String>();
		position.add("1번타자");
		position.add("2루수");
		
		Player player = new Player("정원석", 29, position);
		
		player.setWeight(89);
		player.setHeight(180);
		
		return player;
	}
}
