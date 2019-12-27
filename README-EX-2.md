# IA-PPGI-2019.2
## Universidade Federal de Alagoas - Campus A.C. Simões
### Lista de exercício 2

**1º**

Possuindo as regras, fatos e perguntas oferecidos na questão, abaixo temos a inferência seguindo o encadeamento para frente e o encademanto para trás.

Observe que cada nó contém a regra pela qual ele foi derivado e os possíveis fatos/metas concluídos atraves de MP, MT, SD ou SH.

<p align="center">
<img width="960" height="1280" src="https://user-images.githubusercontent.com/12295778/71487284-3a7f9080-27f9-11ea-98ec-87354c862807.jpeg"></img>
Resolução da questão um.
</p>

**2º**

Possuindo as regras, fatos e perguntas, abaixo temos o grafo completo da inferência utilizando encadeamento para frente.

Observe que cada nó contém a regra pela qual ele foi derivado e os possíveis fatos/metas concluídos atraves de MP, MT, SD ou SH.

<p align="center">
<img width="960" height="1280" src="https://user-images.githubusercontent.com/12295778/71487282-39e6fa00-27f9-11ea-89d6-a9eb01f75bd6.jpeg"></img>
Resolução da questão dois.
</p>
 
**3º**
 
Possuindo as regras, fatos e perguntas, abaixo temos o grafo completo da inferência utilizando encadeamento para frente.

Observe que cada nó contém a regra pela qual ele foi derivado e os possíveis fatos/metas concluídos atraves de MP, MT, SD ou SH.

<p align="center">
<img width="960" height="1280" src="https://user-images.githubusercontent.com/12295778/71487280-39e6fa00-27f9-11ea-95c3-cf4b0d66e719.jpeg"></img>
Resolução da questão três.
</p>

**4º**

Possuindo as regras, fatos e perguntas, abaixo temos o grafo completo da inferência utilizando encadeamento para trás.

Observe que cada nó contém a regra pela qual ele foi derivado e os possíveis fatos/metas concluídos atraves de MP, MT, SD ou SH. 

<p align="center">
<img width="960" height="1280" src="https://user-images.githubusercontent.com/12295778/71487279-39e6fa00-27f9-11ea-8e1f-97ff9d5d09b3.jpeg"></img>
Resolução da questão quatro.
</p>
 
**5º**

Possuindo as regras, fatos e perguntas, abaixo temos o grafo completo da inferência utilizando encadeamento para trás.

Observe que cada nó contém a regra pela qual ele foi derivado e os possíveis fatos/metas concluídos atraves de MP, MT, SD ou SH.

<p align="center">
<img width="960" height="1280" src="https://user-images.githubusercontent.com/12295778/71487278-39e6fa00-27f9-11ea-93b7-196779e53366.jpeg"></img>
Resolução da questão cinco.
</p>

**6º**


**7º**

Durante um trabalho relacionado a Inteligência Artificial junto com uma equipe foi montada uma base de sintomas relacionados a doenças. Esta base está disponível para visualização em [base de sintomas e doenças](https://docs.google.com/spreadsheets/d/1MO3kqm1mfq-SS3SPVLqaZ1TazMSHCDo4CjfnfxuJnGw/edit?usp=sharing). 

O objetivo neste trabalho, é modelar o conhecimento de um especialista médico no **diagnóstico** de doenças. Para isto, utilizando o software [Weka](https://waikato.github.io/weka-wiki/) e o algoritmo J48, montei uma árvore de decisão que modela o conhecimento presente na base de dados.
 
<p align="center">
<img width="400" height="400" src="https://user-images.githubusercontent.com/12295778/71516715-3c913000-2889-11ea-948b-f5c7dbaec859.png"></img>
<p align="center">
Árvore resultante da execução do algoritmo J48 na base de dados.
</p> 
</p>
 
Em seguida, utilizando o Software [Expert Sinta](https://iaexpert.com.br/index.php/2016/09/13/ferramentas-para-ia-expert-sinta/) modelei todas as regras em um especialista. Veja abaixo algumas imagens do processo.

<p align="center">
<img width="400" height="400" src="https://user-images.githubusercontent.com/12295778/71520618-cba74380-289b-11ea-92af-e90d62c1a047.png"></img>
<p align="center">
Parte das regras expressas no Software Expert Sinta.
</p>
</p>

<p align="center">
<img width="400" height="400" src="https://user-images.githubusercontent.com/12295778/71520619-cc3fda00-289b-11ea-9e3e-66bc951c5703.png"></img>
<p align="center">
Histórico de uma consulta realizada utilizando o modelo especificado.</p> 

**8º**


**Solução de engenho de inferência, baseado em regras SE ENTÃO.**

Um engenho de inferência baseado em regras SE ENTÃO deve se comportar da seguinte maneira:

* Ler as regras no formato SE ... ENTÃO ...  
  * Exemplo: Se P Então Q AND K
* Transformar as regras em expressões lógicas.
  * Exemplo: P -> Q ^ K
* Ler um conjunto de Fatos.
  * Exemplo: S, P, Q
* Ler uma expressão a ser inferida.
  * Exemplo: Q ^ K
  
 **Encadeamento para frente**

 No encadeamento para frente, partindo do conjunto de fatos:
 
 * Enquanto possível, aplicar em cada regra da base as seguinte substituições:
   * Modus Pones
   * Modus Tollens
   * Siloginsmo hipotético 
   * Silogismo dedutivo
   * Outras
 * Após a aplicação de cada substituição, verificar se os fatos subsidiam a resolução da questão.

 * Se nenhuma substituição é mais passível e a pergunta não é respondida, não é possível resolver a pergunta.
  
  **Encadeamento para trás**
  
  No encademento para trás, partindo do conjunto de objetivos.
  
 * Enquanto possível, aplicar em cada regra da base as seguinte substituições, buscando por novas metas que devem ser satisfeitas.
   * Modus Pones
   * Modus Tollens
   * Siloginsmo hipotético 
   * Silogismo dedutivo
   * Outras
 * Após a aplicação de cada substituição, verifica-se se o conjunto de fatos iniciais pertence a bases, se sim a pergunta pode ser respondida.
 
 * Se nenhuma substituição é mais possível e o conjunto de fatos inicias não pode ser observado, a pergunta não pode ser respondida. 

**Código**

O código disponível em [link](https://github.com/correiajoao/IA-PPGI-2019.2/tree/master/src/main/java/inferenceEngine) foi escrito em Java e simula um engenho de inferência que recebe expressões do tipo SE ... ENTÃO ... (P -> Q) que utilizando **encadeamento para frente**, realiza inferências.
