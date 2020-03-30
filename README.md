# Distributed Systems
This repo provides my solutions to Distributed Systems laboratory exercises. 
For each lab there are two directories: one for exercises solved during labs, and one for home exercises.
## Lab 1 - TCP, UDP
### Project:
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
## Lab 3 - RabbitMQ
