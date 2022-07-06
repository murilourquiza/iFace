# Projeto_iFace

Projeto de uma rede social, feito na Linguagem Java com aplicações e conceitos de Programação Orientada a Objetos: <br />
-> Sobrecarga nos construtores; <br />
-> Encapsulamento ; <br />
-> Enumeração (para definir a configuração do feed "Publico" ou "Privado"); <br />
-> Composição; <br />
-> Herança  (sobre a classe de mensagens); <br />
-> Classe Abstrata (sobre mensagens para usuários e para comunidades, caso alguma mude sua forma no futuro) <br />
-> entre outros conceitos básicos.
<br /> <br />
Os Tratamento de Exceções foram feitos em dois casos de inputs: <br />
  i) Quando a entrada pede um número inteiro e só aceita aqueles valores dados como possíveis, quaisquer outros símbolos digitados ou números fora do intervalo não são considerados como válidos.<br />
  ii) Quando pede-de para configurar o feed (Publico ou Privado) como foi feito em um 'enum' só aceita exatamente essas duas strings nesse formato, quaisquer outros não são aceitos. <br /> <br />
O Projeto também já acopla todas as possíveis variações de respostas, no caso de duplicação de usuários, usuários não existentes e diversas outras funcionalidade já previstas de antimão, conselho ler o pdf publicado para melhor compreensão.<br /> <br />
Por fim, foram implementados os seguintes Padrões de Projeto para consertar os Code Smells: Extract Method, Replace Conditional with Polymorphism, Replace Inheritance, Move Method e Extract Method, Collapse Hierarchy; pode-se verificar a descrição deles no pdf acima.<br /> <br />
Abaixo pode-se verificar de modo simplicado os Code Smells e os respectivos Padrões de Projeto utilzados para consertá-los:<br />

1.	Long Method <br />
    1.1) Encontrado na classe BandoDados.java	no método cancelaConta(linha 92) e no método addListAmi(linha 384) -> Extract Method (linha 404).<br />
    1.2) Encontrado em algumas partes da classe Main.java -> Extract Method (linha 30, 38, 53).<br />
    1.3) Encontrado com switch e if-else na parte de menu de login, quando entra do IFace e mostra as opções de ações -> Replace Conditional with Polymorphism (linha 101 da ‘Class Main’) + (‘Package options’).<br />
2.	Refused Bequest: encontrado na classe Mensagem (herança desnecessária) -> Replace Inheritance (herança desfeita).<br />
    Observação: Como as classes filhas funcionavam do mesmo modo, não era necessário ter duas classes separadas, tendo apenas uma e chamando duas vezes a mesma classe ‘Mensagens’, uma vez para ‘Usuário’ e outra para ‘Comunidade’.
3.	Data Class: encontrado nas classes MensagemComunidade e MensagemUsuario (classes apenas com atributos) -> Move Method e Extract Method (classes desfeitas pelo motivo já explicado anteriormente).<br />
4.	Duplicated Code<br />
    4.1) Encontrado duplicação dos mesmos conjuntos de println’s na classe Main.java: início nas linhas 30 e 496; início nas linhas 76 e 441; início nas linhas 193 e 231 -> Foi usado “Do While”.<br />
    4.2) Encontrado duplicação nos atributos das classes MensagemComunidade e MensagemUsuario -> Move Method e Extract Method (classes desfeitas pelo motivo já explicado anteriormente).<br />
5.	Lazy Class: encontrado na classe Mensagem (essa classe pode fazer além do seu papel, o das classes InformacaoMensagem, MensagemComunidade e MensagemUsuario) -> Collapse Hierarchy.<br />
6.	Speculative Generality: encontrado nas classes MensagemComunidade e MensagemUsuario (separação de classes visando possíveis mudanças futuras) -> Collapse Hierarchy.<br />

Atenciosamento, <br /> <br />
Murilo Ribeiro!
