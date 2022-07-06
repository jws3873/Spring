package com.khie.di06;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class playerInfo {
	private Player player;
	
	public void getPlayerInfo() {
		System.out.println("선수 이름 >>> "+player.getName());
		System.out.println("선수 나이 >>> "+player.getAge());
		System.out.println("선수 포지션 >>> "+player.getPosition());
		System.out.println("선수 체중 >>> "+player.getWeight());
		System.out.println("선수 신장 >>> "+player.getHeight());
	}
}
