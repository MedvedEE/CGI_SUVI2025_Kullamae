import axios from 'axios';
import { useEffect, useState } from 'react';

function FlightList({ onSelectFlight }) {
  const [flights, setFlights] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/flights")
      .then(response => setFlights(response.data))
      .catch(error => console.error("Viga lendude laadimisel:", error));
  }, []);

  return (
    <div>
      <h2>Saadaval lennud</h2>
      <ul>
        {flights.map(f => (
          <li key={f.id}>
            {f.origin} → {f.destination} ({f.date} {f.time}) - {f.price}€
            <button onClick={() => onSelectFlight(f)}>Vali</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default FlightList;
