 De acordo com o site devmedia.com.br, 

<b>"O Polimorfismo Dinâmico acontece na herança, quando a subclasse sobrepõe o método original. 
Agora o método escolhido se dá em tempo de execução e não mais em tempo de compilação. 
A escolha de qual método será chamado depende do tipo do objeto que recebe a mensagem." </b>

* fonte: https://www.devmedia.com.br/uso-de-polimorfismo-em-java/26140


Com base nisso, é possível relacionar o conceito com exercícios já feitos na disciplina
de Linguagem de Programação II. 

<b>Por exemplo,</b>

Dentro da pasta "figures", encontramos os arquivos <b>Rect.java</b> e <b>Ellipse.java</b>.
Em ambos os arquivos, possuímos o método <b>"print()"</b>, contudo, na execução do programa principal, 
<b>PackApp.java</b>, teremos retornos diferentes, por mais que a chamada seja a mesma.

Esses retornos se dão ao fato de que será criado um novo objeto RECT e um novo objeto ELLIPSE. Cada um 
deles terá seus valores, e o método <b>"print()"</b> irá então imprimir na tela os respectivos
valores diferentes quando chamados na aplicação principal por <b>r1.print();</b> e <b>e1.print();</b>. 

![alt text](https://i.imgur.com/oMoSPD9.png)

![alt text](https://i.imgur.com/vI3MXkK.png)

método <b> print() </b>. 
