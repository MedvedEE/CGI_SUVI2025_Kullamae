import React, { useState, useEffect } from "react";
import axios from "axios";

const API_URL = "http://localhost:8080/flights";

function App() {
  const [flights, setFlights] = useState([]);
  const [selectedFlight, setSelectedFlight] = useState(null);
  const [preferences, setPreferences] = useState({
    window: false,
    extraLegroom: false,
    nearExit: false,
  });
  const [recommendedSeat, setRecommendedSeat] = useState(null);
  const [reservationMessage, setReservationMessage] = useState("");

  useEffect(() => {
    axios.get(API_URL)
      .then(response => setFlights(response.data))
      .catch(error => console.error("Error fetching flights:", error));
  }, []);

  const recommendSeat = () => {
    if (!selectedFlight) {
      alert("Palun vali lend enne istekoha soovitamist.");
      return;
    }

    const seats = [
      { number: "1A", window: true, extraLegroom: false, nearExit: false },
      { number: "2B", window: false, extraLegroom: true, nearExit: false },
      { number: "3C", window: false, extraLegroom: false, nearExit: true },
      { number: "4D", window: false, extraLegroom: true, nearExit: true }
    ];

    const bestSeat = seats.find(seat =>
      (preferences.window && seat.window) ||
      (preferences.extraLegroom && seat.extraLegroom) ||
      (preferences.nearExit && seat.nearExit)
    );

    setRecommendedSeat(bestSeat || seats[0]);
  };

  const bookSeat = () => {
    if (!selectedFlight || !recommendedSeat) {
      alert("Palun vali lend ja istekoht enne broneerimist.");
      return;
    }

    axios.post(`${API_URL}/reserve`, {
      flightId: selectedFlight.id,
      seat: recommendedSeat.number
    })
    .then(response => setReservationMessage(response.data))
    .catch(error => setReservationMessage("Broneerimine ebaõnnestus"));
  };

  return (
    <div style={{ padding: "20px", maxWidth: "600px", margin: "auto" }}>
      <h1 style={{ fontSize: "24px", fontWeight: "bold" }}>Lennuplaan</h1>

      <h2 style={{ fontSize: "18px", marginTop: "20px" }}>Lennud:</h2>
      <ul>
        {flights.map(flight => (
          <li key={flight.id} style={{ marginBottom: "10px" }}>
            {flight.origin} → {flight.destination} ({flight.date} {flight.time}) - {flight.price}€
            <button 
              onClick={() => setSelectedFlight(flight)}
              style={{
                marginLeft: "10px",
                backgroundColor: selectedFlight?.id === flight.id ? "gray" : "blue",
                color: "white",
                padding: "5px 10px",
                borderRadius: "5px",
                cursor: "pointer"
              }}
            >
              {selectedFlight?.id === flight.id ? "Valitud" : "Vali"}
            </button>
          </li>
        ))}
      </ul>

      {selectedFlight && (
        <>
          <h2 style={{ fontSize: "18px", marginTop: "20px" }}>Istekoha eelistused:</h2>
          <div style={{ display: "flex", gap: "10px", marginTop: "10px" }}>
            <label>
              <input
                type="checkbox"
                checked={preferences.window}
                onChange={() => setPreferences({ ...preferences, window: !preferences.window })}
              /> Aknakoht
            </label>
            <label>
              <input
                type="checkbox"
                checked={preferences.extraLegroom}
                onChange={() => setPreferences({ ...preferences, extraLegroom: !preferences.extraLegroom })}
              /> Rohkem jalaruumi
            </label>
            <label>
              <input
                type="checkbox"
                checked={preferences.nearExit}
                onChange={() => setPreferences({ ...preferences, nearExit: !preferences.nearExit })}
              /> Lähemal väljapääsule
            </label>
          </div>

          <button
            onClick={recommendSeat}
            style={{
              marginTop: "10px",
              backgroundColor: "blue",
              color: "white",
              padding: "8px 12px",
              borderRadius: "5px",
              cursor: "pointer"
            }}
          >
            Soovita istekohta
          </button>

          {recommendedSeat && (
            <p style={{ marginTop: "10px", fontSize: "16px" }}>
              Soovitatud istekoht: <strong>{recommendedSeat.number}</strong>
            </p>
          )}

          <button
            onClick={bookSeat}
            style={{
              marginTop: "10px",
              backgroundColor: "green",
              color: "white",
              padding: "8px 12px",
              borderRadius: "5px",
              cursor: "pointer"
            }}
          >
            Broneeri istekoht
          </button>

          {reservationMessage && (
            <p style={{ marginTop: "10px", fontSize: "16px", fontWeight: "bold" }}>
              {reservationMessage}
            </p>
          )}
        </>
      )}
    </div>
  );
}

export default App;
