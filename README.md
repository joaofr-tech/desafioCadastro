## Dificuldades

### 1.1
nao tinha realmente entendido buffer, quando fiz a comparacao com scanner fez total sentido, 
ate me ajudou a entender melhor objeto. A gente usa bufferReader pra instanciar um objeto pra 
poder usar o metodo dele, o metodo é a leitura e nao o objeto em si.

### 1.2
Tive dificuldade na hora de fazer a logica de ler o formulario e pegar o input do usuario. Muito
por causa dos diferentes tipos de dados do objeto pet.

### 1.3
fato engracado, pesquisei no google, porque tinha colocado masculino e feminino em sexo do pet. Joguei
na pesquisa: "sexo de pet" na inocencia de aparecer macho e femea, veio a pior coisa.

### 1.4
quando fui criar a pasta e mexer com os aquivos, criei a pasta petsCadastro manualmente. Dai vi que nao
era uma boa abordagem porque o path fica muito longo e é o exemplo PRATICO de so funciona na minha maquina
porque tipo, o path tava sendo o do meu computador, se qualquer um tentasse rodar esse codigo, falharia, pelo
menos é o que acredito kkkk. Mas e muito bom ver os erros e exemplos do que voce via na teoria, so que agora
na pratica, da uma sensacao foda de aprendizado, tipo: to passando pelas dificuldades e acumulando historias 
pra contar, no final evoluir na carreira é ter um repertorio de historias de erros kkkk

### 1.5
codigo que funciona nao mexe. Eu tinha usado scan como global pra ler, e scanner como locar no case 1. Pra
padronizar fui tentar trocar o nome e deixar so a instancia global. Massss quando tirava a instancia local o 
codigo todo simplesmente parava.. deixa como ta entao

### 1.6
Essa linha simples deu um erro do cacete. 
```Java            
    System.out.print("Criterio(s): ");
    int criterioDeEscolha = scan.nextInt();
    
    System.out.print("Tipo: ");
    String criterioTipo = scan.nextLine();
```
Eu nao conseguia descobrir porque tava pulando a leitura do tipo. Dai quando fui pesquisar era porque o \n tinha "sobrado"
da leitura anterior, ja que eu so queria um int. Dai o segondo scanner lia esse \n. Solucao: colocar mais um scanner pra 
"capturar" esse \n, e assim poder ler o tipo. Esse bug era uma coisa que eu nunca ia descobrir se nao tivesse pesquisado, 
porque tipo, nao era algo que tava no meu repertorio de possiveis causas do problema.. mas agora nunca mais esse bug me pega

## Perguntas que me fiz

### qual diferenca de tipos para wrappers?

### qual diferenca de execoes automaticas para execoes manuais?

### percebi porque e importante um codigo bem escrito
porra, um bagulho simples desse, escrito 100% por mim e eu me perdendo pra cacete

### tinha esquecido como usar regex
olha isso: ^[a-zA-Z][" "][a-zA-Z]$ 

### meu processo de desenvolvimento 
quando to fazendo um primeiro projeto com aquele ferramental, eu abro claude, passo um prompt padrao de me 
explicar como um professor, mas sem dar codigo. Pra nao atrapalhar o contexto, coisas soltas como: como 
fazer tal regex ou como passar string pra integer, eu jogo no google. No chat da claude pergunto mais
decisao logica, qual melhor e coisa tipo: qual metodo de java faz tal coisa.

### Factory Method

### o que o printstacktrace faz?
