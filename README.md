# JavaQuiz

Java Swing quiz projectAplicatia a fost create utilizand Java Swing si Eclipse IDE ca si code editor.

In proiect se pot observa diferite frame-uri pentru fiecare fereastra a aplicatiei:

LoginFrame este prima fereastra a aplicatiei ce ii cere userului un username si parola pentru a accesa 
MainMenu, meniul aplicatiei folosit pentru selectarea categoriilor.

Dupa selectarea unei categorii din MainMenu o noua fereastra se va deschide, Test, Test1 sau Test2 in 
functie de categoria selectata. Ferestrele de test prezinta user-ului numarul intrebarii la care se afla, un 
cronometru sub forma unui JProgressBar, butoanele pentru raspunsurile posibile si intrebarea in sine.

Dupa selectarea unui raspuns, textul butoanelor cu raspunsurile gresite este colorat in rosu iar textul 
butonului cu raspunsul corect ramane verde si cronometrul este oprit pana la generarea urmatoarei 
intrebari cand este reluat de la inceput.

Metodele folosite:

getContentPane().add(…) pentru a adauga componentele in frame

setSize(…) pentru a seta marimile componentelor
setLayout(..) pentru a seta layout-ul componentelor
setVisible(boolean b) seteaza vizibilitatea componentului (pentru a afisa urmatoarea fereastra)
Structura aplicatiei:

Aplicatia este structurata in diferite clase pentru fiecare fereastra
-Main pentru rularea ferestrei de login
-LoginFrame pentru introducerea userului si parolei
-MainMenu meniul pentru selectarea categoriei testului
-Test, Test1 si Test2 cate o clasa pentru fiecare categorie de test

Descriere cod:

Pentru test:

-public Test() este folosit pentru setarea componentelor si afisarea acestora in frame
-public void actionPerformed(ActionEvent e) (de la inceputul codului) este folosit pentru cronometrare
-public void nextQuestion() selecteaza si afiseaza intrebarile plus raspunsurile aferente acestora
-public void actionPerformed(ActionEvent e) (de la mijlocul codului) verifica corectitudinea raspunsului 
si creste valoarea scorului total cu 1
-public void displayAnswer() dezactiveaza butoanele de raspuns, opreste temporar cronometrul, seteaza 
culoarea textului pentru raspunsurilor gresite in rosu
-public void actionPerformed(ActionEvent e) (de la finalul codului) genereaza urmatoarea inrebare,
reactiveaza butoanele de raspuns, reseteaza raspunsul corect, reseteaza cronometrul
-public void results() afiseaza rezultatul testului sub forma de percentage si numarul de raspunsuri 
corecte versus numarul de intrebari totale (acest component este afisat doar la finalul testului)
-public void setVisible(boolean b) permite setarea ferestrei ca vizibila din fereastra meniului
*Test/Test1/Test2 au acelasi cod, singura diferenta fiind lista de intrebari si raspunsuri*

Pentru MainMenu:

-public MainMenu este folosit pentru setarea componentelor si afisarea acestora in frame
-public void actionPerformed(ActionEvent ae) verifica apasarea butoanelor de categorie, dupa care sunt 
dezactivate unul cate unul iar fereastra testului selecta teste afisata. Butoanele se pot reactiva folosind 
butonul Reset.
-public static void main(String args[]) pentru pornirea independenta a meniului (pentru testarea 
functionarii codului)
-public void setVisible(boolean b) ) permite setarea ferestrei ca vizibila din fereastra de login

Pentru LoginFrame:

-public LoginFrame este folosit pentru setarea componentelor si afisarea acestora in frame
-public void actionPerformed(ActionEvent e) pentru verificarea userului si parolei introduse de utilizator 
In cazul in care acestea corespund, este deschis un MessageDialog cu textul “Login Successful” dupa care
fereastra meniului este deschisa, altfel este deschis un MessageDialog cu textul Invalit “Username or 
Password” si utilizatorul ramane la fereastra de login. De asemenea exista un buton de reset, ce goleste 
field-urile de user si parola, si un check box ce face parola vizibila.

Pentru Main:

-permite rularea ferestrei de login
