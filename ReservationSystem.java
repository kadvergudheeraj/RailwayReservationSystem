package railway;

import java.util.ArrayList;
import java.util.List;

public class ReservationSystem {
    private final List<Train> trains = new ArrayList<>();
    private final List<Booking> bookings = new ArrayList<>();
    private int nextPnr = 1001;

    public ReservationSystem() {
        // Sample trains are loaded when the application starts.
        trains.add(new Train(101, "Deccan Express", "Hyderabad", "Mumbai", 5));
        trains.add(new Train(102, "Charminar Express", "Hyderabad", "Chennai", 5));
        trains.add(new Train(103, "Godavari Express", "Hyderabad", "Visakhapatnam", 5));
        trains.add(new Train(104, "Rajdhani Express", "Delhi", "Hyderabad", 5));
    }

    public List<Train> getAllTrains() {
        return new ArrayList<>(trains);
    }

    public List<Train> searchTrains(String source, String destination) {
        List<Train> results = new ArrayList<>();
        for (Train train : trains) {
            if (train.getSource().equalsIgnoreCase(source.trim())
                    && train.getDestination().equalsIgnoreCase(destination.trim())) {
                results.add(train);
            }
        }
        return results;
    }

    public Booking bookTicket(int trainNumber, String passengerName, int age) {
        if (passengerName == null || passengerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Passenger name cannot be empty.");
        }
        if (age <= 0 || age > 120) {
            throw new IllegalArgumentException("Enter a valid passenger age.");
        }

        Train train = findTrain(trainNumber);
        int seatNumber = train.reserveSeat();
        String pnr = "PNR" + nextPnr++;

        Booking booking = new Booking(pnr, trainNumber,
                passengerName.trim(), age, seatNumber);
        bookings.add(booking);
        return booking;
    }

    public Booking getBookingByPnr(String pnr) {
        for (Booking booking : bookings) {
            if (booking.getPnr().equalsIgnoreCase(pnr.trim())) {
                return booking;
            }
        }
        return null;
    }

    public boolean cancelTicket(String pnr) {
        Booking booking = getBookingByPnr(pnr);
        if (booking == null) {
            throw new IllegalArgumentException("PNR not found.");
        }
        if (booking.isCancelled()) {
            throw new IllegalStateException("This ticket is already cancelled.");
        }

        booking.cancel();
        findTrain(booking.getTrainNumber()).releaseSeat();
        return true;
    }

    public List<Booking> getAllBookings() {
        return new ArrayList<>(bookings);
    }

    private Train findTrain(int trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber() == trainNumber) {
                return train;
            }
        }
        throw new IllegalArgumentException("Train number not found.");
    }
}
