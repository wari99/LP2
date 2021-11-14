## Editor Gráfico Vetorial - Linguagem de Programação II ##
Nesse primeiro projeto da disciplina, foi criado um editor gráfico no qual é possível a criação
de quatro figuras através do teclado: Retangulos, Elipses, Triangulos e Arcos. O local exato onde
elas aparecerão é determinado pela posição do cursor do mouse no momento em que as teclas de comando
são pressionadas. 

É possível excluir figuras e movê-las pelo espaço tanto através do teclado quanto através do mouse, 
assim como aumentar e diminuir o tamanho de todas que forem criadas. As figuras em foco serão 
contornadas por um retângulo vermelho para uma melhor visualização do usuário. Por fim, todas as 
figuras do projeto possuirão as mais variadas cores, uma vez que, estão sujeitas a aleatoriedade da
tabela de cores RGB. As cores mutáveis são as de contorno e as de fundo. Ambas são geradas aleatoriamente.
Abaixo estão as teclas que ativarão comandos durante a execução do programa.

Todas as alterações feitas no espaço de criação serão salvas em um arquivo chamado proj.bin, onde ao 
executar novamente o programa, todas as alterações e criações feitas anteriormente estarão lá salvas.
Existe um menu de botões para criar o Retangulo, Triangulo, Arco e Elipse, alternativamente. 

## Lista de Comandos

***CRIAÇÃO DE FIGURAS:***
```diff
@@   ATRAVES DO MENU DE BOTOES AO LADO ESQUERDO     @@
@@   E : CRIA UMA NOVA ELIPSE NO LOCAL DO CURSOR    @@
@@   R : CRIA UM NOVO RETANGULO NO LOCAL DO CURSOR  @@
@@   T : CRIA UM NOVO TRIANGULO NO LOCAL DO CURSOR  @@
@@   Y : CRIA UM NOVO ARCO NO LOCAL DO CURSOR       @@
```

***MUDANÇA DE COR:***
```diff
#@   Z : MUDA A COR DE FUNDO DA FIGURA SELECIONADA  @@
#@   X : MUDA A COR DE FUNDO DA FIGURA SELECIONADA  @@
```

***FIGURA ATUAL:***
```diff
@@   F : LIMPA O FOCO DA FIGURA SELECIONADA         @@
@@   DELETE : DELETA A FIGURA SELECIONADA           @@
```

***TAMANHO DA FIGURA:***
```diff
#@   + : AUMENTA A FIGURA EM FOCO ATUALMENTE        @@
#@   - : DIMINUI A FIGURA EM FOCO ATUALMENTE        @@
```
***MOVIMENTACAO FIGURAS NO PLANO (SETAS DO TECLADO):***
```diff
@@   ↑ : MOVIMENTA A FIGURA PARA CIMA               @@
@@   ↓ : MOVIMENTA A FIGURA PARA BAIXO              @@
@@   ← : MOVIMENTA A FIGURA PARA A ESQUERDA         @@
@@   → : MOVIMENTA A FIGURA PARA DIREITA            @@

```
***MOVIMENTACAO FIGURAS NO PLANO (MOUSE):***
```diff
#@   BOTÃO ESQUERDO     : SELECIONA A FIGURA        @@
#@   SEGURAR BOTÃO ESQ. : MOVIMENTA A FIGURA        @@

```

