package com.medvedee.lennuplaan;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seats")
public class SeatController {
    private final List<Seat> seats;
    private final Random random = new Random();

    public SeatController() {
        seats = generateSeatPlan();
    }
    /**
     * Loob lennuki isteplaani koos juhuslike broneeringutega.
     * @return - istekohtade nimekiri
     */
    private List<Seat> generateSeatPlan() {
        List<Seat> seatList = new ArrayList<>();
        String[] seatLetters = {"A", "B", "C", "D", "E", "F"};

        for (int row = 1; row <= 10; row++) {
            for (String letter : seatLetters) {
                boolean isWindowSeat = letter.equals("A") || letter.equals("F");
                boolean hasExtraLegroom = row == 1 || row == 10;
                boolean isNearExit = row == 1 || row == 10;
                boolean isOccupied = random.nextDouble() < 0.3;

                Seat seat = new Seat(row + letter, isWindowSeat, hasExtraLegroom, isNearExit);
                if (isOccupied) {
                    seat.occupy();
                }
                seatList.add(seat);
            }
        }
        return seatList;
    }
    /**
     * Soovitab kasutajale istekohti vastavalt eelistustele.
     * @param count - soovitud kohtade arv
     * @param window - kas eelistada aknaäärset kohta (valikuline)
     * @param extraLegroom - kas eelistada lisajalaruumiga kohta (valikuline)
     * @param nearExit - kas eelistada väljapääsu lähedal olevat kohta (valikuline)
     * @return - soovitatud vabad istekoha(d)
     */
    @GetMapping("/recommend")
    public List<Seat> recommendSeats(@RequestParam int count,
                                     @RequestParam(required = false) Boolean window,
                                     @RequestParam(required = false) Boolean extraLegroom,
                                     @RequestParam(required = false) Boolean nearExit) {
        List<Seat> availableSeats = seats.stream()
                .filter(seat -> !seat.isOccupied())
                .filter(seat -> window == null || seat.isWindowSeat() == window)
                .filter(seat -> extraLegroom == null || seat.hasExtraLegroom() == extraLegroom)
                .filter(seat -> nearExit == null || seat.isNearExit() == nearExit)
                .collect(Collectors.toList());

        if (availableSeats.size() < count) {
            return availableSeats; // Kui pole piisavalt istekohti, tagasta olemasolevad.
        }

        return availableSeats.subList(0, count); // Tagasta soovitud arv istekohti.
    }
}