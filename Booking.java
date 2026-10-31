package railway;

public class Booking {
    private final String pnr;
    private final int trainNumber;
    private final String passengerName;
    private final int passengerAge;
    private final int seatNumber;
    private boolean cancelled;

    public Booking(String pnr, int trainNumber, String passengerName,
                   int passengerAge, int seatNumber) {
        this.pnr = pnr;
        this.trainNumber = trainNumber;
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.seatNumber = seatNumber;
        this.cancelled = false;
    }

    public String getPnr() { return pnr; }
    public int getTrainNumber() { return trainNumber; }
    public String getPassengerName() { return passengerName; }
    public int getPassengerAge() { return passengerAge; }
    public int getSeatNumber() { return seatNumber; }
    public boolean isCancelled() { return cancelled; }

    public void cancel() {
        cancelled = true;
    }

    @Override
    public String toString() {
        return "PNR: " + pnr
                + "\nTrain Number: " + trainNumber
                + "\nPassenger: " + passengerName
                + "\nAge: " + passengerAge
                + "\nSeat Number: " + seatNumber
                + "\nStatus: " + (cancelled ? "CANCELLED" : "CONFIRMED");
    }
}
