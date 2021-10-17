/*
Interface 1: "Abrível"
Objetos: Geladeira, Caixa, Estojo
Métodos: abrir(), fechar()
São apresentados objetos.
Ele retorna true ou false, dependendo da possibilidade
de serem abertos e fechados com sucesso.
*/

interface Openable{
	boolean abrir(boolean abriu);
	boolean fechar(boolean fechou);
}

class Refrigerator implements Openable{
    boolean abrir(boolean abre){
        ....
    }
    boolean fechar(boolean fecha){
        ...
    }
}

class Box implements Openable{
    boolean abrir(boolean abre){
        ....
    }
    boolean fechar(boolean fecha){
        ...
    }
}

class PencilCase implements Openable{
    boolean abrir(boolean abre){
        ....
    }
    boolean fechar(boolean fecha){
        ...
    }
}

-------------------------------------------

/*
Interface 2: "Montavel" ou "Juntavel"
Objetos: Móvel, Quebra-Cabeças, Grupo de Amigos  
Métodos: montar(), desmontar()
São apresentados objetos diversos.
O parâmetro é a quantidade de unidades,
sejam de peças ou pessoas.
*/  

interface Assemblable{
	void montar(int unidade);
	void desmontar (int unidade);
}

class Furniture implements Assemblable{
    void montar (int unidade){
        ....
    }
    void desmontar(int unidade){
        ...
    }
}


class Puzzle implements Assemblable{
    void montar (int unidade){
        ....
    }
    void desmontar(int unidade){
        ...
    }
}


class FriendsGroup implements Assemblable{
    void montar (int unidade){
        ....
    }
    void desmontar(int unidade){
        ...
    }
}
