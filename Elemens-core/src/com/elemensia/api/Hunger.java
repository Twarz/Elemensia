package com.elemensia.api;

public class Hunger {

	private float max;
	private float current;
	private float starvation;

	private final float hpLost = (float) 0.25;

	public Hunger(int max, float starvation) {
		this.max = (float) max;
		this.current = this.max;
		this.starvation = starvation;
	}

	public int getRatio() {
		return (int) (this.max / this.current * 100);
	}

	public int increase(float value) {
		if (this.current > this.max) {
			this.current = this.max;
		}
		this.current += value;
		return this.getRatio();
	}

	public int increase(int value) {
		return this.increase((float) value);
	}

	// Return the amount of life lost if hunger reaches 0
	public float decrease(float value) {
		float hpLost = 0;
		this.current -= value;
		if (this.current <= 0) {
			hpLost = this.hpLost;
		}
		return hpLost;
	}
	
	public float decrease(int value) {
		return this.decrease((float) value);
	}

	public int getMax() {
		return (int) max;
	}

	public int getCurrent() {
		return (int) current;
	}

	public float getStarvation() {
		return starvation;
	}

	@Override
	public String toString() {
		return "Hunger [max=" + max + ", current=" + current + ", starvation=" + starvation + "]";
	}

}
