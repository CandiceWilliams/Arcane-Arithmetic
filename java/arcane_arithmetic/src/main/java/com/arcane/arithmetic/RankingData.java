package com.arcane.arithmetic;


/**
 * This is the Ranking Data class, used in updating leaderboard
 *
 */
public class RankingData {
	private int points;
	private int rank;
	private String username;

	/**
	 * Constructor for RankingData
	 * @param rank User's rank
	 * @param username User's name
	 * @param points Points gained in the last game
	 */
	public RankingData(int rank, String username, int points) {
		setRank(rank);
		setUsername(username);
		setPoints(points);
	}
	/**
	 * Setter for points
	 * @param points Points gained in the last game
	 */
	public void setPoints(int points){
		this.points = points;
	}
	/**
	 * Setter for ranks
	 * @param rank User's rank
	 */
	public void setRank(int rank){
		this.rank = rank;
	}
	/**
	 * Setter for username
	 * @param username User's name
	 */
	public void setUsername(String username){
		this.username = username;
	}
	/**
	 * Getter for points
	 * @return points
	 */
	public int getPoints(){
		return points;
	}
	/**
	 * Getter for rank
	 * @return rank
	 */
	public int getRank(){
		return rank;
	}
	/**
	 * Getter for username
	 * @return username
	 */
	public String getUsername(){
		return username;
	}
}
