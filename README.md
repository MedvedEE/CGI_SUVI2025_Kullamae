# Lennupiletite broneerimisrakenduse dokumentatsioon

## **Projekti ülevaade**

See projekt on lihtne lennupiletite broneerimisrakendus, mis võimaldab kasutajal:

- Vaadata saadaolevaid lende
- Valida lendu
- Seada istekoha eelistusi
- Saada soovitatud istekoht
- Broneerida istekoht

## **Käivitamise juhend**

### **Nõuded**

- Node.js peab olema paigaldatud
- Backend peab olema käivitatud aadressil `http://localhost:8080`.

### **Installimine ja käivitamine**

1. **Klooni repositoorium**

   ```bash
   git clone https://github.com/MedvedEE/CGI_SUVI2025_Kullamae
   cd CGI_SUVI2025_Kullamae
   ```
2. **NodeJS paigaldus**

1. Laadi alla ja paigalda(Windows/Linux) [Node.js](https://nodejs.org/en/download)


3. **Paigalda sõltuvused**

   ```bash
   cd frontend
   npm install
   ```


### **Java 21 paigaldamine**

**Windows:**

1. Laadi alla ja paigalda [Java 21](https://www.oracle.com/java/technologies/downloads/)
2. Kontrolli installi:

   ```bash
   java -version
   ```

**Linux:**

```bash
sudo apt update
sudo apt install openjdk-21-jdk
java -version
```

Viimane käsk võiks tagastada versiooni "21.0.6" või sarnast.

### **Gradle paigaldamine**

**Windows:**

1. Laadi alla Gradle [ametlikult veebisaidilt](https://gradle.org/install/)
2. Lisa Gradle PATH-i
3. Kontrolli installi:

   ```bash
   gradle -v
   ```

**Linux:**

```bash
sudo apt update
sudo apt install gradle
gradle -v
```


**NB!** Linuxis võib apt-ga installimine tekitada probleeme!
Kui käivitamisel viskab gradle veateate, siis lahendus on allpool.

## Käivitamine

Programmi jooksutamiseks on vaja kahte eraldi terminali.

Esimeses terminalis tuleks jooksutada järgnevaid käske:

```bash
cd <repo_asukoht>/CGI_SUVI2025_Kullamae/lennuplaan
gradle bootRun
```

Antud käsk paneb backendi tööle.

Seejärel, et programmi kasutada, tuleb teises terminal jooksutada järgneviad käske:

```bash
cd <repo_asukoht>/CGI_SUVI2025_Kullamae/frontend

npm start
```

Seejärel avaneb veebilehitsejas aken ja saab rakendust proovida.

---

## **Arenduse logi ja märkmed**

### **Tööks kulunud aeg**

| **Tööetapp**                            | **Aeg (h)** |
| --------------------------------------- | ----------- |
| Andmete pärimine ja kuvamine            | 2           |
| Lennu valiku ja nuppude funktsionaalsus | 1.5         |
| Istekoha soovitamine ja broneerimine    | 4           |
| Testimine ja veaparandused              | 1.5         |
| Dokumentatsiooni kirjutamine            | 1           |

### **Keerulised kohad**


1. **Istekoha soovitamine**

   - Alguses ei nullitud soovitatud istekohta uue lennu valimisel.
   - Lahendus: Seadistasin `recommendedSeat` väärtuseks `null`, kui lend muutub.

2. **Broneerimise API kutse**

   - Alguses oli vale API päringu URL, mis põhjustas vea.
   - Lahendus: Kontrollisin backend’i dokumentatsiooni ja muutsin päringu õigeks.

3. **Frontendi kogenematus**

   - Läks natukene rohkem aega frontendi(reacti) tegemiseks, pole varasemalt nii palju kogemust olnud

### **Abiallikad**

- React ametlik dokumentatsioon: [React Docs](https://react.dev)
- Spring Booti dokumentatsioon: [Spring Docs](https://docs.spring.io/spring-boot/documentation.html)

### **Lahendamata probleemid ja eeldused**

- **Puudub autentimine** – eeldasin, et kasutajad saavad lende broneerida ilma sisse logimata.
- **Lennupiletite andmeid ei salvestata lokaalselt**

### **Probleemid installimisel**

Kui operatsioonisüsteemiks on Linux(Ubuntu24.04.02), siis apt installib väga vana gradle alla.
Selle jaoks on lahendus: Installida teistmoodi gradle.

Kui pole arvutis paigaldatud "sdkman!", siis seda saab paigaldada järgneva käsuga:

```bash
curl -s "https://get.sdkman.io" | bash
```

Kui käsk on oma töö ära lõpetanud, siis tuleb terminalile restarti teha.

Seejärel saab uuema gradle paigaldada käsuga:

```bash
sdk install gradle 8.13
```

Antud käsk installib kõige uuema gradle versiooni.

---

## **Kokkuvõte**

Selle projekti eesmärk oli luua lihtne ja kasutajasõbralik lennupiletite broneerimisrakendus. Kõige keerulisem koht oli minu jaoks frontendi loomine ja selle integreerimine backendiga.
