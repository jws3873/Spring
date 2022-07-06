package com.khie.di06;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BaseBallTeam {
	private String manager;
	private String battingCoach;
	private String picherCoach;
	private String hitter;
	private String pitcher;
	
	public BaseBallTeam(String manager, String battingCoach, String picherCoach) {
		this.manager = manager;
		this.battingCoach = battingCoach;
		this.picherCoach = picherCoach;
	}// 인자생성자
}
