package ua.opnu;

public class TimeSpan {
    private static final int MINUTES_PER_HOUR = 60;

    private int hours;
    private int minutes;

    public TimeSpan() {
        this.hours = 0;
        this.minutes = 0;
    }

    public TimeSpan(int minutes) {
        this.hours = minutes / MINUTES_PER_HOUR;
        this.minutes = minutes % MINUTES_PER_HOUR;
    }

    public TimeSpan(int hours, int minutes) {
        this.hours = hours + minutes / MINUTES_PER_HOUR;
        this.minutes = minutes % MINUTES_PER_HOUR;
    }

    public TimeSpan(TimeSpan other) {
        this.hours = other.hours;
        this.minutes = other.minutes;
    }

    public int getHours() {
        return this.hours;
    }

    public int getMinutes() {
        return this.minutes;
    }
    public void add(int hours, int minutes) {
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }
    public void add(int minutes) {
        this.add(0, minutes);
    }
    public void add(TimeSpan other) {
        this.add(other.hours, other.minutes);
    }
    public void subtract(int hours, int minutes) {
        this.hours -= hours;
        this.minutes -= minutes;
        normalize();
    }
    public void subtract(int minutes) {
        this.subtract(0, minutes);
    }
    public void subtract(TimeSpan other) {
        this.subtract(other.hours, other.minutes);
    }

    private void normalize() {
        // Коригування хвилин і годин
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes %= 60;
        } else if (minutes < 0) {
            int borrow = (Math.abs(minutes) + 59) / 60;
            hours -= borrow;
            minutes += borrow * 60;
        }
        if (hours < 0) {
            hours = 0;
            minutes = 0;
        }
    }

    public int getTotalMinutes() {
        return hours * MINUTES_PER_HOUR + minutes;
    }

    public double getTotalHours() {
        return hours + minutes / 60.0;
    }

    @Override
    public String toString() {
        return String.format("%d год %d хв", hours, minutes);
    }
}

