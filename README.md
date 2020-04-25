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
