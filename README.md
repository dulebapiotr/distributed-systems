# Distributed Systems
This repo provides my solutions to Distributed Systems laboratory exercises. 
For each lab there are two directories: one for exercises solved during labs, and one for home exercises.
## Lab 1 - TCP, UDP
### Home Project:
Napisać aplikację typu chat 
– Klienci łączą się serwerem przez protokół
TCP
– Serwer przyjmuje wiadomości od każdego
klienta i rozsyła je do pozostałych (wraz z
id/nickiem klienta)
– Serwer jest wielowątkowy – każde
połączenie od klienta powinno mieć swój
wątek
– Proszę zwrócić uwagę na poprawną obsługę
wątków

Dodać dodatkowy kanał UDP 
– Serwer oraz każdy klient otwierają dodatkowy
kanał UDP (ten sam numer portu jak przy TCP)
– Po wpisaniu komendy ‘U’ u klienta przesyłana
jest wiadomość przez UDP na serwer, który
rozsyła ją do pozostałych klientów
– Wiadomość symuluje dane multimedialne
(można np. wysłać ASCII Art)

Zaimplementować powyższy punkt w wersji
multicast 
– Nie zamiast, tylko jako alternatywna opcja do
wyboru (komenda ‘M’)
– Multicast przesyła bezpośrednio do wszystkich
przez adres grupowy (serwer może, ale nie
musi odbierać)
## Lab 2 - REST API
### Home Project:
Temat
Celem zadania jest napisanie prostej aplikacji webowej rozszerzającej funkcjonalność  wybranego otwartego serwisu udostępniającego REST API. Stworzyć macie Państwo serwis, który:

odbierze zapytanie od klienta (formularz na stronie),
odpyta serwis publiczny (lub kilka serwisów),
dokona odróbki otrzymanych danych (np.: wyciągnięcie średniej, znalezienie ekstremów, porównanie wartości z różnych serwisów itp.),
wygeneruje i wyśle odpowiedź do klienta (strona z wynikami).
Na przykład: klient podaje miasto i okres czasu ('daty od/do' lub 'ostatnie X dni'), serwer odpytuje serwis pogodowy o temperatury w poszczególne dni, oblicza średnią i znajduje ekstrema i wysyła do klienta wszystkie wartości (tzn. prostą stronę z tymi danymi). Albo odpytuje kilka serwisów i podaje różnice w prognozach. Serwer wykonać musi co najmniej 5 zapytań.
Wybranie serwisu i funkcjonalności pozostawiam Państwa wyobraźni, zainteresowaniom i rozsądkowi. Listę różnych publicznych API można znaleźć przykładowo na https://public-apis.xyz.

Wymagania
Klient (przeglądarka) ma wysyłać żądanie na podstawie danych z formularza (statyczny HTML) i otrzymać odpowiedź w formie prostej, wygenerowanej przez serwer strony www. Proszę użyć czystego HTML, bez stylizacji, bez dodatkowych bibliotek front-endowych. Nie musi być piękne, ma działać.
Odpowiedź dla klienta musi być generowana przez serwer na podstawie: 1) żądań REST do publicznych serwisów i 2) obróbki uzyskanych odpowiedzi.
Serwer ma być uruchomiony na własnym serwerze aplikacyjnym (lub analogicznej technologii), działającym poza IDE.
Sugerowanym językiem jest Java i JAX-RS. Dopuszczalna jest realizacja zadania w innym wybranym języku, pod warunkiem zachowania analogicznego poziomu abstrakcji (operowanie bezpośrednio na żądaniach/odpowiedziach HTTP oraz parsing przekazywanych danych).
Nie używamy gotowych frameworków. Chcę byście użyli Państwo rozwiązań nisko poziomowych i kodowali 'na poziomie' poszczególnych wywołań HTTP.
Nie implementujemy autoryzacji, kontroli sesji itp.! Wybieramy serwisy otwarte lub np.: używające kodów deweloperskich.
Dodatkowe wymagania
Konfiguracja własnego środowiska do rozwijania aplikacji internetowych z wykorzystaniem ulubionego IDE.
Prezentacja wykorzystywanych zapytań HTTP klient-serwer i serwer-serwis_publiczny z wykorzystaniem POSTMANa (do oddania proszę mieć je już zapisane).
## Lab 3 - RabbitMQ
### Home Project:
Zadanie polega na implementacji, z użyciem RabbitMQ, systemu pośredniczącego pomiędzy agencjami kosmicznymi (Agencja), a dostawcami usług transportu kosmicznego (Przewoźnik). Agencje kosmiczne zlecają wykonanie trzech typów usług: przewóz osób, przewóz ładunku, umieszczenie satelity na orbicie.

W związku z podpisanym porozumieniem, obowiązują następujące zasady współpracy:
- ceny poszczególnych usług są takie same u wszystkich Przewoźników, w związku z czym nie są uwzględniane w systemie
- każdy Przewoźnik świadczy dokładnie 2 z 3 typów usług - przystępując do współpracy określa które 2 typy usług świadczy
- konkretne zlecenie na wykonanie danej usługi powinno trafić do pierwszego wolnego Przewoźnika, który obsługuje ten typ zlecenia
- dane zlecenie nie może trafić do więcej niż jednego Przewoźnika
- zlecenia identyfikowane są przez nazwę Agencji oraz wewnętrzny numer zlecenia nadawany przez Agencję
- po wykonaniu usługi Przewoźnik wysyła potwierdzenie do Agencji

W wersji premium tworzonego systemu dostępny jest dodatkowy moduł administracyjny. Administrator dostaje kopię wszystkich wiadomości przesyłanych w systemie oraz ma możliwość wysłania wiadomości w trzech trybach:
- do wszystkich Agencji
- do wszystkich Przewoźników
- do wszystkich Agencji oraz Przewoźników

Dostosowanie się do unijnych wymagań w zakresie oprogramowania dla przemysłu kosmicznego wymaga, aby do projektu załączona została dokumentacja w postaci schematu działania systemu. Schemat powinien uwzględniać:
- użytkowników, exchange'e, kolejki, klucze użyte przy wiązaniach
- schemat musi mieć postać elektroniczną, nie może to być skan odręcznego rysunku
![alt text](https://github.com/dulebapiotr/distributed-systems/blob/master/home3/SystemDiagram.png "Schemat gotowego systemu.")

Scenariusz prezentacji zadania:
- 2 agencje kosmiczne
- 2 przewoźników, z których jeden obsługuje przewóz osób oraz ładunków, a drugi przewóz ładunków oraz umieszczenie satelity na orbicie
- 1 administrator
- w ramach testów systemu przyjmujemy, że zlecenia obsługiwane są natychmiast
## Lab 4 - Middleware
### Home Project:

Zadanie składa się z dwóch części.

Zadanie 4.1

Wynikiem prac ma być aplikacja klient-serwer, w której komunikacja rozproszona jest zrealizowana z wykorzystaniem technologii gRPC. Klient powinien dokonywać subskrypcji na zdarzenia. To, o czym mają one informować, jest w gestii Wykonawcy, np. o nadchodzącym wydarzeniu lub spotkaniu, którym jesteśmy zainteresowani, o osiągnięciu określonych w żądaniu warunków pogodowych w danym miejscu, itp. Na dane zdarzenie może się naraz zasubskrybować wielu odbiorców i może istnieć wiele niezależnych subskrypcji (tj. np. na wiele różnych instancji spotkań).  Należy odpowiednio wykorzystać mechanizm strumieniowania (stream). Wiadomości mogą przychodzić z dowolnymi odstępami czasowymi  (nawet bardzo długimi), jednak na potrzeby demonstracji rozwiązania należy przyjąć interwał rzędu pojedynczych sekund).

W definicji wiadomości przesyłanych do klienta należy wykorzystać pola enum, string, ew. message - wraz z co najmniej jednym modyfikatorem repeated. Etap subskrypcji powinien w jakiś sposób parametryzować otrzymywane wiadomości (np. obejmować wskazanie miasta, którego warunki pogodowe nas interesują_.

Dla uproszczenia realizacji zadania można (nie trzeba) pominąć funkcjonalność samego tworzenia instancji wydarzeń lub miejsc, których dotyczy subskrypcja i notyfikacja - może to być zawarte w pliku konfiguracyjnym, a nawet kodzie źródłowym strony serwerowej. Treść wysyłanych zdarzeń może być wynikiem działania bardzo prostego generatora.

W realizacji należy zadbać o odporność komunikacji na błędy sieciowe (które można symulować czasowym wyłączeniem klienta lub serwera lub włączeniem firewalla). Ustanie przerwy w łączności sieciowej musi pozwolić na ponowne ustanowienie komunikacji bez konieczności restartu procesu. Rozwiązanie musi być także "PAT-friendly" (tj. uwzględniać rozważane na laboratorium sytuacje). 

Zadanie 4.2

Wynikiem prac ma być aplikacja klient-serwer, w której komunikacja rozproszona jest realizowana w technologii ICE albo Thfitt (do wyboru). Aplikacja ma pozwalać na sterowanie urządzeniami tzw. inteligentnego domu, na którego wyposażeniu znajdują się różne urządzenia, np. czujniki temperatury czy zdalnie sterowane lodówki, piece, kamery monitoringu z opcją PTZ (pan/tilt/zoom), bulbulatory, itp. Każde z urządzeń może występować w kilku nieznacznie się różniących odmianach, a każda z nich w pewnej (niewielkiej) liczbie instancji. Dom ten nie oferuje obecnie możliwości budowania złożonych układów, pozwala użytkownikom jedynie na sterowanie pojedynczymi urządzeniami oraz odczytywanie ich stanu.

Dodatkowe informacje i wymagania:

Projektując interfejs urządzeń postaraj się użyć także typów bardziej złożonych niż string czy int/long. Pamiętaj o deklaracji wyjątków tam, gdzie to może mieć zastosowanie.
Wystarczająca jest obsługa dwóch-trzech typów urządzeń, jeden-dwa z nich mogą mieć dwa-trzy podtypy. 
Odwzoruj podane wymagania do cech wybranej technologii (ICE albo Thrift) w taki sposób, by jak najlepiej wykorzystać oferowane przez nią możliwości budowy takiej aplikacji i by osiągnąć jak najbardziej eleganckie rozwiązanie (gdyby żądanej funkcjonalności nie dało się wprost osiągnąć).
Zestaw urządzeń może być niezmienny w czasie życia serwera (tj. dodanie nowego urządzenia może wymagać modyfikacji kodu serwera i restartu procesu). 
Początkowy stan instancji obsługiwanego urządzenia może być zawarty w kodzie źródłowym strony serwerowej lub pliku konfiguracyjnym.
Dla chętnych: wielowątkowość strony serwerowej.
Aplikacja kliencka powinna pozwalać zademonstrować sterowanie różnymi urządzeniami bez konieczności restartu w celu przełączenia na inne urządzenie.
Serwer może zapewnić funkcjonalność wylistowania nazw (identyfikatorów) aktualnie dostępnych instancji urządzeń.
Realizując komunikację w ICE należy zaimplementować poszczególne urządzenia inteligentnego domu jako osobne obiekty middleware, do których dostęp jest możliwy po podaniu pewnego identyfikatora (znanego klientowi -> Joe) - nie należy projektować żadnego obiektu, który po nazwie urządzenia zwracałby jego referencję. Choć może nie ma to w tym zadaniu uzasadnienia, instancjonowanie serwantów skojarzonych z obiektem middleware powinno nastąpić dopiero w czasie pierwszyego odwołaniu do danego urządzenia (-> ServantLocator).

Realizując komunikację w Thrift należy dążyć do minimalizacji liczby instancji eksponowanych usług (ale bez ekstremizmu - lodówka i bulbulator nie mogą być opisane wspólnym interfejsem!). 

Uwagi wspólne (4.1+4.2):

Interfejs IDL powinien być prosty, ale zaprojektowany w sposób dojrzały (odpowiednie typy proste, właściwe wykorzystanie typów złożonych), uwzględniając możliwość wystąpienia różnego rodzaju błędów. Tam gdzie to możliwe i uzasadnione należy wykorzystać dziedziczenie interfejsów IDL.
Stan serwerów nie musi być persystowany (z zastrzeżeniem symulacji awarii w zadaniu 4.1).
Do realizacji zadania należy wykorzystać przynajmniej dwa różne języki programowania i w każdym z zadań klient i serwer muszą być w różnych językach programowania.
Działanie aplikacji może (nie musi) być demonstrowane na jednej maszynie.
Kod źródłowy zadania powinien być demonstrowany w IDE. 
Aktywność poszczególnych elementów aplikacji należy odpowiednio logować (wystarczy na konsolę) by móc sprawnie ocenić poprawność jej działania.
Aplikacja kliencka powinna mieć postać tekstową i może być minimalistyczna, lecz musi pozwalać na przetestowanie funkcjonalności aplikacji szybko i na różny sposób (musi więc być przynajmniej w części interaktywna).
Pliki generowane (stub, skeleton) powinny się znajdować w osobnym katalogu niż kod źródłowy klienta i serwera. Pliki stanowiące wynik kompilacji (.class, .o itp) powinny być w osobnych katalogach niż pliki źródłowe.
