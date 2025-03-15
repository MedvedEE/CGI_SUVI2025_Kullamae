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
2. **Paigalda sõltuvused**
   ```bash
   npm install
   ```
3. **Käivita rakendus**
   ```bash
   npm start
   ```
   Rakendus peaks avanema brauseris aadressil `http://localhost:3000`.

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

### **React paigaldamine**

**Windows ja Linux:**

```bash
npm install -g create-react-app
```

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


---

## **Kokkuvõte**

Selle projekti eesmärk oli luua lihtne ja kasutajasõbralik lennupiletite broneerimisrakendus. Kõige keerulisem koht oli minu jaoks frontendi loomine ja selle integreerimine backendiga.

