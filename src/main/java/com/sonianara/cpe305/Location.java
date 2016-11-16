package com.sonianara.cpe305;

public class Location {
	
	private int[] coords = new int[2];

	public Location() {
		coords = this.coords;
	}

	public int getXLocation() {
		return coords[0];
	}
	
	public int getYLocation() {
		return coords[1];
	}

	public void setLocation(int x, int y) {
		coords[0] = x;
		coords[1] = y;
	}
}