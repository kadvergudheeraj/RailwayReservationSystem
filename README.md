# Railway Ticket Reservation System (Core Java)

A beginner-friendly, menu-driven console application that demonstrates train searching, seat availability, ticket booking, PNR lookup, and ticket cancellation using Core Java.

## Features

- View sample trains and routes
- Search trains by source and destination
- Check available seats
- Book a ticket for a passenger
- Generate a simple PNR reference
- View ticket details using PNR
- Cancel a confirmed ticket and release its seat
- View all bookings

## Technology

- Java (JDK 21 recommended; source is compatible with Java 15+)
- Core Java
- OOP (classes, objects, encapsulation)
- Collections Framework (`ArrayList`, `List`)
- `Scanner` for console input
- Exception handling

No database, JDBC, framework, or third-party dependency is used.

## Folder structure

```text
RailwayReservationSystem/
├── src/
│   └── railway/
│       ├── Main.java
│       ├── Train.java
│       ├── Booking.java
│       └── ReservationSystem.java
└── README.md
```

## Run the project

Open a terminal in the project root.

### Windows

```bat
javac -d out src\\railway\\*.java
java -cp out railway.Main
```

### macOS / Linux

```bash
javac -d out src/railway/*.java
java -cp out railway.Main
```

## Sample trains

| Train number | Train name | Source | Destination | Seats |
|---:|---|---|---|---:|
| 101 | Deccan Express | Hyderabad | Mumbai | 5 |
| 102 | Charminar Express | Hyderabad | Chennai | 5 |
| 103 | Godavari Express | Hyderabad | Visakhapatnam | 5 |
| 104 | Rajdhani Express | Delhi | Hyderabad | 5 |

## Menu

```text
1. View all trains
2. Search trains
3. Book ticket
4. Check ticket using PNR
5. Cancel ticket
6. View all bookings
0. Exit
```

## Business rules

- Passenger name cannot be blank.
- Passenger age must be between 1 and 120.
- A ticket cannot be booked if the selected train has no available seats.
- Every successful booking receives a simple sequential PNR.
- A ticket cannot be cancelled more than once.
- Cancelling a ticket releases its seat.
- Train and booking data are held in memory and reset when the application exits.

## Manual testing checklist

1. View all trains and confirm sample routes appear.
2. Search from `Hyderabad` to `Chennai`; confirm Charminar Express appears.
3. Search an unsupported route; confirm the no-trains message appears.
4. Book a ticket on train `101` for a passenger; note the PNR.
5. Check the ticket using that PNR; confirm passenger and seat details.
6. View trains and confirm available seats decreased by one.
7. Cancel the ticket using its PNR.
8. View trains and confirm the seat is available again.
9. Try cancelling the same PNR again; confirm an error is shown.
10. Try booking an unknown train number or entering an invalid age.

## Concepts demonstrated

- Encapsulation: fields are private and accessed through methods.
- Objects: each train and reservation is represented by an object.
- Collections: `ArrayList` stores trains and bookings.
- Separation of concerns: models, service logic, and console interface are in separate classes.
- Exception handling: invalid operations are reported without crashing the menu loop.

## Limitations and future improvements

This is a learning project, not a production railway booking platform. It does not connect to live railway schedules, payment gateways, or real reservation services. Data is not persisted after the program exits.

Possible improvements:
- Save bookings to a file
- Add source/destination station validation
- Add train schedules and ticket fares
- Add multiple passengers per booking
- Add waitlist functionality
- Add login and admin features
- Add automated unit tests
- Later create a JDBC + MySQL version

## GitHub upload

```bash
git init
git add .
git commit -m "Initial Railway Ticket Reservation System"
git branch -M main
git remote add origin YOUR_GITHUB_REPOSITORY_URL
git push -u origin main
```
