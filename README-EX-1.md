# IA-PPGI-2019.2
## Universidade Federal de Alagoas - Campus A.C. Simões
### Lista de exercício 1

**1º**

  O Teste de Turing foi um mecanismo desenvolvido por Alan Turing, que tem como objetivo verificar se uma máquina pode agir indistintamente, da maneira que um ser pensante age. Os participantes do teste são: um computador, um humano e um juiz. O Juiz humano, pode conversar com o computador e o humano através de um terminal. Tanto o computador como o humano tentam convencer o juiz de que são humanos. Se o juiz não for capaz de dizer qual é qual, o computador ganha o jogo.
    Essencialmente, o Teste de Turing verifica se uma máquina consegue gerar a capacidade cognitiva humana. Passados todos estes anos, o teste ainda permanece importante pois o campo da Inteligência Artificial continua a evoluir, donde surgem novas técnicas (inclusive aprimorando chatterbots) que reforçam a questão sobre se as máquinas atingiram a carga cognitiva humana a ponto de passar com facilidade no Teste de Turing.

**2º**

  A sala chinesa é um experimento mental que descreve a seguinte situação. Suponha que uma pessoa que não conhece a língua inglesa esteja dentro de uma sala isolada, onde existem apenas caixas contendo símbolos chineses. Existe também na sala um manual completo de chinês, escrito em língua inglesa. Fora da sala existe uma pessoa conhecedora da língua chinesa, que organiza pergunta ou frases em chinês e repassa para dentro da sala. A pessoa que está dentro da sala deverá organizar os símbolos e utilizando o manual construir respostas coerentes em chinês. Considerando que o manual e os símbolos sejam bem completos, a pessoa de fora da sala irá pensar que se comunica com alguém que sabe chinês, quando na verdade esta pessoa não sabe nada. Esta ideia é utilizada para fazer uma crítica ao Teste de Turing, no momento em que dela podemos deduzir que uma máquina pode ser classificada como "pensante" mesmo sem saber nada sobre o universo da língua humana, tal qual a pessoa da sala chinesa.

**3º**

  O problema dos missionários e canibais, pode ser tratado como um Constraint Satisfaction Problem, facilmente solúvel através de um mecanismo de busca em grafo. A princípio a definição formal do problema, segue:

- Conjunto de variáveis: missionarios_direita, missionarios_esquerda, canibais_direita, canibais_esquerda.

- Domínio das variáveis: [0,3].

- Conjunto de restrições: missionarios_direita >= canibais_direita || missionarios_direita == 0, missionarios_esquerda >= canibais_esquerda || missionarios_esquerda == 0.
    
O problema possui um total de dezesseis estados possíveis, estes podem ser verificados na figura abaixo. 

<p align="center">
  <img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70076797-515a0b00-15de-11ea-8fd4-52e062e135e8.jpg"></img>
<p align="center">Espaço de estados total. Cada estado possui respectivamente o número de missionários e canibais do lado direito e esquerdo do rio.</p> 
</p>

  Sabendo do conjunto total de possíveis estados, abaixo temos a árvore na qual pode ser realizada uma **busca em profundidade** considerando as restrições, para solucionar o problema. A árvore contém apenas a expansão dos nós não ilegais. Observe que apenas uma solução pode ser encontrada, através de onze passos.

<p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70078505-8caa0900-15e1-11ea-8bc8-81631382b695.jpg"></img>
<p align="center">Árvore de busca com apenas os nós não ilegais expandidos.
</p>

  A solução do problema em java, pode ser encontrada no seguinte [pacote](https://github.com/correiajoao/IA-PPGI-2019.2/tree/master/src/main/java/cannibalsAndMissionaries).

**4º**

  **Busca em profundidade:** na teoria dos grafos, a busca em profundidade ou Depth First Search é um algoritmo utilizado para realizar busca em grafos. Este algoritmo inicia a busca através de um nó raiz, explorando tanto quanto possível cada um de seus ramos, da esquerda para a direita.
Exemplos de problemas solúveis com este algoritmo: resolução de labirintos, determinar se um grafo é conexo, determinar se um grafo é fortemente conexo, determinar ordenações topológicas.

  **Busca em largura:** na teoria dos grafos, busca em largura ou Breadth First Search é um algoritmo utilizado para realizar busca em grafos. Este algoritmo inicia a busca através de um nó raiz, explorando os vértices vizinhos, da esquerda para direita, antes de visitar seus respectivos filhos.
Exemplos de problemas solúveis com este algoritmo: determinar caminhos de custo mínimo, determinar componentes conectados, testar bipartição em grafos, determinar se todos os nós são conectados a um componente.

**5º**

  A busca em profundidade com Aprofundamento Iterativo une os principais benefícios da busca em largura e busca em profundidade. As principais vantagens deste algoritmo são: consumo reduzido de memória (característica da busca em profundidade), solução ótima encontrada (característica da busca em largura) e loops infinitos são evitados (característica da busca em largura). 
    Um exemplo claro em que é preferível o uso de busca em profundidade com aprofundamento iterativo a busca em profundidade, são os problemas de labirinto. Em um problema de labirinto, a busca em profundidade não encontra soluções ótimas. Além do mais, o algoritmo de busca em profundidade pode entrar em loop infinito, a depender da configuração do labirinto.

**6º**

  A implementação em Java dos jogos de oito e quinze números pode ser encontrada no seguinte [pacote](https://github.com/correiajoao/IA-PPGI-2019.2/tree/master/src/main/java/pluzze). A implementação está escalavél para rodar em tabuleiros de quaisquer tamanho.

  Nos testes executados, a busca em largura se apresenta com a melhor performance. Já a busca em profundidade tem a pior performance. O Algoritmo A* com a heurística de expandir sempre o nó mais próximo da vitória, apresenta desempenho pior que a busca em comprimento, mas consideravelmente melhor do que a busca em profundidade.
  
  Em breve será gravado um vídeo da execução e disponibilizado no YouTube.

**7º**

<p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70079277-2a520800-15e3-11ea-8d04-19ddc1ab0b95.jpg"></img>
<p align="center">Árvore de busca para o labirinto.
</p>

<p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70079074-bfa0cc80-15e2-11ea-94fb-ae52bb405a2f.jpg"></img>
<p align="center">Busca em largura.
</p>

<p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70079173-eced7a80-15e2-11ea-94ed-bc9942e84998.jpg"></img>
<p align="center">Busca em profundidade.
</p>

<p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70079277-2a520800-15e3-11ea-8d04-19ddc1ab0b95.jpg"></img>
<p align="center">Busca de custo uniforme.
</p>


<p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70079609-d4ca2b00-15e3-11ea-81b5-0c3e039e0274.jpg"></img>
<p align="center">Busca com aprofundamento iterativo. Ciclos de um a doze.
</p>

<p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70079628-e14e8380-15e3-11ea-8c19-4906d52b7819.jpg"></img>
<p align="center">Busca com aprofundamento iterativo. Ciclos de treze e quatorze.
</p>

**8º**

  Para a solução do problema, primeiro definimos a árvore de busca. A árvore foi definida de tal maneira que movimentos em loop são evitados.
   
<p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70079988-85d0c580-15e4-11ea-9718-3e720d4c39a9.jpg"></img>
<p align="center">Árvore de busca.
</p>

 <p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70080114-bdd80880-15e4-11ea-9118-8781918ecf62.jpg"></img>
<p align="center">Busca em profundidade.
</p>
   
  Observe que a busca em profundidade para a expansão da árvore, quando encontra o primeiro estado objetivo, este caracteriza um caminho de comprimento vinte e oito e consequentemente não ótimo.
  
 <p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70080225-ef50d400-15e4-11ea-96fe-6f63df6d4145.jpg"></img>
<p align="center">Busca em largura.
</p>
  
  A busca em largura para este problema, encontra todas as soluções possíveis, pois só é interrompida quando todos os nós são expandidos. Um total de seis soluções foram encontradas, sendo que o menor caminho possui tamanho **quatorze**, passando pelos vértices **{A, C, B, D, F}**.
  A resolução deste problema através do algoritmo A* e busca de custo uniforme pode ser verificada no exercício dez.  
  
 A implementação do problema em Java, está disponível neste [pacote](https://github.com/correiajoao/IA-PPGI-2019.2/tree/master/src/main/java/cannibalsAndMissionaries). As implementações estão escaláveis para lidar com a busca em qualquer grafo, porém a princípio estão definidas para executar no grafo do exercício.

**9º**

  Ambos os algoritmos, tanto A* quanto o algoritmo de Dijkstra são voltados para a busca do caminho de custo mínimo entre dois vértices. A principal diferença entre ambos os algoritmos é que o A* é um algoritmo informado, ou seja utiliza heurística para a escolha do próximo nó a explorar, essa vantagem faz este ser mais rápido na busca. Enquanto Dijkstra analisa todos os possíveis caminhos. No demais ambos são completos e ótimos.

**10º**

  A busca de custo uniforme, irá produzir a mesma árvore que a busca em largura vista no exercício nove, e segue abaixo. As únicas diferenças observáveis entre estas duas técnicas, seriam relacionadas a eficiência, já que a busca de custo uniforme expande primeiro nós com menor custo.
  
   <p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70080225-ef50d400-15e4-11ea-96fe-6f63df6d4145.jpg"></img>
<p align="center">Árvore obtida pela busca de custo uniforme. Observe que a árvore é idêntica à produzida por uma busca em largura.
</p>

Já a busca A* dependendo da heurística utilizada, pode resultar em diversas árvores. Para este problema, uma heurística aleatória foi definida e a árvore resultante da busca se encontra abaixo.

<p align="center">
<img width="600" height="400" src="https://user-images.githubusercontent.com/12295778/70080437-4ce52080-15e5-11ea-904a-a891b7359168.jpg"></img>
<p align="center">Busca utilizando A* e heurística aleatória.
</p>
