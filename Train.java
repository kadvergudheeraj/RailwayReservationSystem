package railway;

public class Train {
    private final int trainNumber;
    private final String trainName;
    private final String source;
    private final String destination;
    private final int totalSeats;
    private int availableSeats;

    public Train(int trainNumber, String trainName, String source,
                 String destination, int totalSeats) {
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public int getTrainNumber() { return trainNumber; }
    public String getTrainName() { return trainName; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }

    public boolean hasAvailableSeat() {
        return availableSeats > 0;
    }

    public int reserveSeat() {
        if (!hasAvailableSeat()) {
            throw new IllegalStateException("No seats are available on this train.");
        }
        availableSeats--;
        return totalSeats - availableSeats;
    }

    public void releaseSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }

    @Override
    public String toString() {
        return trainNumber + " | " + trainName + " | " + source + " -> "
                + destination + " | Available seats: " + availableSeats
                + "/" + totalSeats;
    }
}
