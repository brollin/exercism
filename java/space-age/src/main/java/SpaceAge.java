/*
    Earth: orbital period 365.25 Earth days, or 31557600 seconds
    Mercury: orbital period 0.2408467 Earth years
    Venus: orbital period 0.61519726 Earth years
    Mars: orbital period 1.8808158 Earth years
    Jupiter: orbital period 11.862615 Earth years
    Saturn: orbital period 29.447498 Earth years
    Uranus: orbital period 84.016846 Earth years
    Neptune: orbital period 164.79132 Earth years
*/

public class SpaceAge {
   
    private long seconds;
    private final double periodEarth = 365.25;          // days
    private final double periodEarthSeconds = 31557600; // seconds
    private final double periodMercury = 0.2408467;     // Earth years
    private final double periodVenus = 0.61519726;      // Earth years
    private final double periodMars = 1.8808158;        // Earth years
    private final double periodJupiter = 11.862615;     // Earth years
    private final double periodSaturn = 29.447498;      // Earth years
    private final double periodUranus = 84.016846;      // Earth years
    private final double periodNeptune = 164.79132;     // Earth years


    public SpaceAge(long seconds) {
        this.seconds = seconds;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public double onEarth() {
        return (double)this.seconds / periodEarthSeconds;
    }

    public double onMercury() {
        return this.seconds / (periodMercury * periodEarthSeconds);
    }

    public double onVenus() {
        return this.seconds / (periodVenus * periodEarthSeconds);
    }

    public double onMars() {
        return this.seconds / (periodMars * periodEarthSeconds);
    }

    public double onJupiter() {
        return this.seconds / (periodJupiter * periodEarthSeconds);
    }

    public double onSaturn() {
        return this.seconds / (periodSaturn * periodEarthSeconds);
    }

    public double onUranus() {
        return this.seconds / (periodUranus * periodEarthSeconds);
    }

    public double onNeptune() {
        return this.seconds / (periodNeptune * periodEarthSeconds);
    }
}

