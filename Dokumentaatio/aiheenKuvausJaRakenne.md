# Aiheen kuvaus ja rakenne

**Aihe:** tetris. Toteutetaan ohjelma, jonka toimintatarkoitus on olla tuttu tetrispeli. Pelissä on tarkoitus järjestää putoavia erimuotoisia palikoita siten, että ne muodostavat täysiä rivejä ja katoavat. Mikäli yhdellä kerralla saa poistettua useita rivejä, pelaaja saa enemmän pisteitä. Mikäli alue jolle palikat putoavat täyttyy vähintään yhdestä rivistä täyteen peli loppuu. Tarkoituksena olisi pitää tallella 5 parasta suoritusta pelin päätyttyä.
	Kun peli etenee palikat putoavat nopeammin alas, ja täten myös yksittäisen poistetun rivin pistemäärä kasvaa. Tarkoituksena olisi voida valita eri vaikeusasteita, eli putoamisnopeuksia.

**Käyttäjät:** Pelaaja

**Toiminnot:** Pelaaja aloittaa pelin valitsemallaa vaikeusasteella. Voidaan myös selata huipputuloksia ja nollata ne haluttaessa.

**Luokkakaavio:** ![luokkakaavio](Luokkakaavio(1).png)
**Sekvenssikaavio pistetilastojen nollaamisesta:** ![Sekvenssikaavio1](Sekvenssikaavio_1.png)
**Sekvenssikaavio uuden pelin aloittamisesta:** ![Sekvenssikaavio2](Sekvenssikaavio_2.png)
**Sekvenssikaavio vaihtopalikoista sovelluslogiikassa:** ![Sekvenssikaavio2](vaihtopalikat sekvenssikaavio.png)