package com.khie.di10;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
	

@Configuration
@ImportResource("classpath:baseball4.xml") //자원을 읽어들이겠다.
// 그러면 여기에 bean player3가 등록된다?
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
	
}
