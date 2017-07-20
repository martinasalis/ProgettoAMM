<%-- 
    Document   : descrizione
    Created on : 8-lug-2017, 11.10.48
    Author     : martinasalis
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>NerdBook - Descrizione del sito</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="widt=device-width, initial-scale=1.0">
        <meta name="author" content="Martina Salis">
        <meta name="keywords" content="Cerca amici">
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>
    
    <body>
        <!--header contenente in titolo della pagina-->
        <header class="titleLeft">
            <div id="title">
                <h1>NerdBook</h1>
            </div>
        </header>    
        
        <!--Barra di navigazione-->
        <nav>
            <ul>
                <li><a href="Login">Login</a></li>
            </ul>
        </nav>
        
        <!--Barra di navigazione tra le sezioni della pagina-->
        <div id="divNavSez">
            <ol>
                <li><a href="#destinatari">A chi è rivolto?</a>
                <ol>
                    <li><a href="#piccoli">Troppo piccoli?</a></li>
                    <li><a href="#liberta">La rete è per tutti!!</a></li>
                </ol>
                </li>
                <li><a href="#iscrizione">Come iscriversi?</a>
                <ol>
                    <li><a href="#senzaIscrizione">Navigazione senza Iscrizione</a></li>
                </ol>
                </li>
                <li><a href="#costo">Quanto costa?</a>
                <ol>
                    <li><a href="#personale">Profilo Personale</a></li>
                    <li><a href="#paginaPubblica">Pagina Pubblica</a></li>
                </ol>
                </li>
            </ol>
        </div>
        
        <!--Contenuti della pagina-->
        <article>
            <div id="destinatari">
                <h2>A chi è rivolto?</h2>
                <p>
                    I 13 anni richiesti dalle policies di utilizzo di Nerdbook sono la risposta più ovvia, ma la risposta più sensata è la valutazione da parte degli educatori della maturità del figlio, che presenta nell’adolescenza molte sfumature.
                    Si aprono quindi due correnti di pensiero: coloro che pensano che l'età sia rilevante e coloro che pensano che chiunque, sia grandi che piccoli possano usare il social network.
                </p>
                <div id="piccoli">
                    <h3>Troppo piccoli?</h3>
                        <p>
                            In linea di massima i 13 anni sono l’età in cui il pensiero astratto è avviato e dunque potenzialmente esiste un’embrionale capacità di filtrare criticamente le informazioni. 
                            In tal caso si può consentire un accesso regolamentato ai social network come Nerdbook.
                            Tuttavia, la richiesta che arriva dai ragazzi parte molto prima dei 13 anni e già a 9 i bambini si affacciano su NB indicando, per iscriversi, un’età falsa. 
                            Educatori attenti possono valutare positivamente questa spinta alla conoscenza e considerare che, se guidato, preoccupa meno un ragazzino curioso che mente sulla sua data di nascita per vedere com’è fatto Nerdbook, piuttosto che un bambino che non ha alcun interesse per un fenomeno di cui tutti parlano.
                            Quanto al controllo, un modo efficace per verificare la vera età di chi si registra non esiste e non è detto che un ragazzino che non usa il computer in casa non lo faccia poi altrove, per esempio a casa di amici, a scuola o con gli smartphone.
                        </p>
                </div>
                
                <div id="liberta">
                    <h3>La rete è per tutti!!</h3>
                        <p>
                            Sono moltissime le persone che utilizzano Nerdbook ogni giorno: il famoso social network è infatti secondo solo a Google in quanto a visite giornaliere.
                            Seguito da circa un miliardo di utenti in tutto il mondo, Nerdbook è disponibile in ben 70 lingue diverse così da poter essere utilizzato in tutto il mondo senza problemi di barriere linguistiche!
                            Ma in quanto a numeri, Nerdbook vanta anche un altro primato: il social network è infatti primo tra le reti sociali per numero di utenti attivi; sono infatti circa un miliardo gli utenti che effettuano l'accesso a Nerdbook almeno una volta al mese!
                            Sempre parlando di numeri e primati, sono gli Stati Uniti ad essere il paese con più iscritti su Nerdbook: al famoso social network, infatti, è iscritta ben il 51% della popolazione, ovvero 157 milioni di persone circa.
                        </p>
                </div>
            </div>
            
            <div id="iscrizione">
                <h2>Come iscriversi?</h2>
                <p>
                    Se non hai un account Nerdbook, puoi crearne uno in pochi passaggi:<br/>
                    1) Accedi a www.nerdbook.com. <br/>
                    2) Se visualizzi il modulo di iscrizione, inserisci il nome, cognome, immagine del profilo,, una breve presentazione di te, la data di nascita ed infine la password. 
                    Se non vedi il modulo, clicca su Iscriviti, quindi completa il modulo.<br/>
                    3) Clicca su Iscriviti.<br/>
                </p>
                <div id="senzaIscrizione">
                    <h3>Navigazione senza Iscrizione</h3>
                    <p>
                        Se vuoi sapere come navigare su Nerdbook senza registrarsi per verificare se uno dei tuoi amici è iscritto al social network, 
                        non devi far altro che collegarti alla pagina principale del sito e cliccare sulla voce Persone collocata in fondo allo schermo (in piccolo). 
                        Nella pagina che si apre, puoi scegliere se sfogliare tutte le persone iscritte a Nerdbook in ordine alfabetico – ma sarebbe una follia – 
                        oppure se effettuare una ricerca diretta usando l’apposita barra collocata in alto a destra.
                    </p>
                </div>
            </div>
            
            <div id="costo">
                <h2>Quanto costa?</h2>
                <p>
                    Il servizio è gratuito per gli utenti e trae guadagno dalla pubblicità, inclusi i banner. Molti analisti invece sostengono che i ricavi monetari di Nerdbook non siano così elevati rispetto alle potenzialità di un servizio di rete sociale, aggirandosi intorno ai 230 milioni di dollari nel 2009. 
                    I ricavi commerciali derivanti dalla pubblicità riescono a coprire solo in parte i costi fissi di gestione del sito (archiviazione, server, ecc.) tanto da rendere necessario l'apporto dei soci. Per migliorare la raccolta pubblicitaria Nerdbook aveva implementato Beacon, un sistema in grado di tracciare l'attività degli utenti su siti esterni convenzionati, in particolare le loro abitudini di acquisto online, consentendo pubblicità mirate e permettendo agli utenti di condividere tali attività sul News Feed dei propri amici. 
                    Beacon fu lanciato il 6 novembre 2007 con 44 siti partner. Il servizio divenne oggetto di una class action per la sua natura invasiva per la privacy, e venne perciò sospeso a settembre del 2009.
                    Nerdbook dispone di due tipologie di servizio social con finalità nettamente distinte: 
                    - profilo personale; <br/>
                    - pagina pubblica . <br/>
                    Il profilo è un servizio utilizzabile unicamente da persone fisiche per interessi privati ovvero all'infuori di qualsiasi attività pubblica, anche se non a scopo di lucro. Per Nerdbook la finalità commerciale è qualsiasi attività rivolta al pubblico, anche fosse volontariato o utilità sociale o una piccola associazione. 
                    I due servizi funzionano in modo diverso e hanno strumenti/peculiarità distinti.
                </p>
                <div id="personale">
                    <h3>Profilo Personale</h3>
                    <p>
                        Il profilo Nerdbook si chiama semplicemente "profilo". Gli utenti creano profili che solitamente contengono fotografie e liste di interessi personali, scambiano messaggi privati o pubblici. 
                        Possono creare e prendere parte a "Gruppi", in cui si condividono interessi, e a "Pagine" legate a cose o persone di loro gradimento. Secondo Chris Hughes, il portavoce per Nerdbook, "Le persone passano circa 19 minuti al giorno su Nerdbook".
                        Gli iscritti a Nerdbook possono scegliere di aggregarsi a una o più reti, organizzate per città, posto di lavoro, scuola e religione.
                        È severamente proibito dal regolamento di Nerdbook utilizzare un profilo come pagina: il regolamento recita "non usare il proprio diario personale principalmente per ottenere profitti commerciali, ma usare piuttosto una Pagina Nerdbook a tale scopo".
                    </p>
                </div>
                    
                <div id="paginaPubblica">
                    <h3>Pagina Pubblica</h3>
                    <p>
                        La pagina (pubblica) o pagina fan è un servizio di Nerdbook usufruibile, gratuitamente e con servizi aggiuntivi a pagamento, da utilizzare per pubblicizzare le seguenti macro-categorie di entità: imprese, luoghi, aziende, organizzazioni, istituzioni, marchi o prodotti, artisti, gruppi, personaggi pubblici, intrattenimento, cause e comunità. 
                        Ciascuna di queste macro-tipologie di pagina contiene molte categorie che vanno prescelte in fase di apertura.
                        La pagina è utilizzabile da aziende, enti, lavoratori autonomi, associazioni, organizzazioni in genere per promuovere la loro impresa (prodotti e servizi) o una finalità pubblica. 
                        Il regolamento di Nerdbook vieta di utilizzare un profilo per scopi commerciali o comunque pubblici in quanto si utilizza un servizio che è nato per una finalità diversa. 
                        Nerdbook chiude regolarmente profili utilizzati fraudolentemente come pagine. Invece, si può convertire in pagina un profilo erroneamente o illegittimamente aperto ma impiegato come una pagina pubblica (prima che sia stata chiusa per violazione del regolamento) attraverso una procedura.
                        Grazie alla pagina si possono informare i clienti (ma anche i fornitori) o gli utenti (detti "fan" termine distinto da "amici" che si usa solo per il profilo), fare pubblicità diretta (attraverso lo strumento denominato "inserzioni"), postare le novità, e tante altre cose. 
                        Ad ogni modo la pagina la si utilizza anche per enti e istituzioni pubbliche, associazioni di varia natura, località, personaggi pubblici, cause sociali e benefiche, ecc. Mediante lo strumento "Business manager" si possono creare account pubblicitari distinti e avere la reportistica per il monitoraggio degli obiettivi dell'inserzione e del budget.
                    </p>
                </div>
            </div>
        </article>
        
    </body>
</html>


