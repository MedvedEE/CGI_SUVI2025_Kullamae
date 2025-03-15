import axios from 'axios';
import { useState } from 'react';

function SeatSelection({ flight, onCancel }) {
  const [seat, setSeat] = useState("");
  const [message, setMessage] = useState("");

  const reserveSeat = () => {
    axios.post("http://localhost:8080/flights/reserve", {
      flightId: flight.id,
      seat: seat
    })
      .then(response => setMessage(response.data))
      .catch(error => setMessage("Broneerimine ebaõnnestus"));
  };

  return (
    <div>
      <h2>Vali istekoht lennule {flight.origin} → {flight.destination}</h2>
      <input type="text" placeholder="Sisesta istekoht (nt. 12A)" value={seat} onChange={e => setSeat(e.target.value)} />
      <button onClick={reserveSeat}>Broneeri</button>
      <button onClick={onCancel}>Tagasi</button>
      {message && <p>{message}</p>}
    </div>
  );
}

export default SeatSelection;
