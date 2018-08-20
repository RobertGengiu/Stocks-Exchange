======================Filter-Tema 2================================

Am citit liniile in Reader si le-am pus intr-o coada implementata ca
Linked List, din care pe masura ce executam si stergeam. Observatorii
i-am facut cu factory pattern, care e instantiata o singura data.
Observatorii mai departe i-am pus intr-un hashmap in functie de nume.
In interiorul fiecarui observator am facut un hashmap de feeduri, tot 
pe baza numelui si care la printare l-am sortat intr-o lista.
Feedurile intra in hashmap daca respecta filtrul, altfel tot se numara.
In expresia filtrului am inlocuit fiecarea operatie cu valoarea de 
adevar 1 si 0, pentru a simplifica visitor calculator, unde am
implementat si si sau. Expresia cu paranteze si valori de 1 si 0, a 
fost modificata cu SYA si a ramas doar expresia care ne intereseaza.
Din expresie am bagat intr-o stiva toate operatile de "si" sau "sau",
iar in alta stiva valorile de adevar. Prima data am scos doua valori 
si o operatie si am facut nod intre ele, iar rezultatul l-am retinut.
La urmatorul pas, am scos cate o valoare si o operatie ,si am facut
nod intre fostul rezultat, valoare si operatie.

Operatorii au fost realizati tot cu Factory Pattern, precum si Reader.



Realizata de catre: Gengiu Robert
Grupa: 322 CB
