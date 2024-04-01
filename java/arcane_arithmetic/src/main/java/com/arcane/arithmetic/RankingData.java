package com.arcane.arithmetic;

public class RankingData {
	private int points;
	private int rank;
	private String username;

	public RankingData(int rank, String username, int points) {
		setRank(rank);
		setUsername(username);
		setPoints(points);
	}
	public void setPoints(int points){
		this.points = points;
	}
	public void setRank(int rank){
		this.rank = rank;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public int getPoints(){
		return points;
	}
	public int getRank(){
		return rank;
	}
	public String getUsername(){
		return username;
	}
}
