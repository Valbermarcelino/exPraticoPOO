Exercício Prático - Projeto de Software Orientado a Objetos (2026-05-08) 

---

1. Descrição do Problema 

O objetivo do exercício é modelar e prototipar uma aplicação de **"Reserva de Salas de Estudo"** para um campus universitário. O sistema deve permitir que estudantes e professores consultem a disponibilidade, realizem reservas e recebam notificações sobre conflitos ou alterações.

Requisitos Funcionais 

* 
**RF-01:** Listar salas disponíveis em um intervalo de datas.


* 
**RF-02:** Permitir que um usuário crie, modifique ou cancele uma reserva.


* 
**RF-03:** Detectar e impedir colisões de horário.


* 
**RF-04:** Enviar notificação imediata aos envolvidos em caso de alteração ou cancelamento.


* 
**RF-05:** Disponibilizar relatório diário com as reservas confirmadas de cada sala.



A interface pode ser via linha de comando ou uma GUI simples, com foco principal na lógica de domínio e modelagem.

---

2. Padrões de Projeto a serem Aplicados 

A implementação deve obrigatoriamente utilizar os seguintes padrões:

| Padrão | Papel no Exercício | Pontos de Atenção |
| --- | --- | --- |
| **Factory Method** | Instanciar diferentes tipos de sala (individual, grupo, laboratório) sem acoplamento à classe concreta.

 | Criar ao menos três subclasses de sala.

 |
| **Strategy** | Selecionar a política de detecção de colisões (ex: "primeiro a reservar" vs. "prioridade para docente").

 | Possibilitar a troca em tempo de execução.

 |
| **Observer** | Propagar eventos de alteração de reserva para usuários ou serviços de relatório.

 | Implementar push e pull de dados.

 |
| **Singleton** | Gerenciar a instância de configuração ou repositório em memória e/ou arquivo.

 | Garantir thread-safety.

 |

> 
> **Extensão Opcional (Bônus):** Aplicar o padrão **Decorator** para adicionar funcionalidades extras às reservas, como equipamento multimídia ou serviço de limpeza.
> 
> 

---

3. Uso do GitHub 

O uso do GitHub é obrigatório para documentar o progresso, e o link deve ser disponibilizado imediatamente.

### Regras de Desenvolvimento

* 
**Commits:** Registre a evolução com múltiplos commits claros e descritivos ao longo da semana.


* 
**Volume:** Mínimo recomendado de 20 commits por dupla, refletindo o desenvolvimento incremental.


* 
Estrutura do Repositório:


* 
`src/`: Código-fonte principal.


* 
`docs/`: Diagramas e documentação complementar.


* 
`README.md`: Instruções de uso, visão geral e autores.





### Bonificações Adicionais

* 
**Bônus:** Utilizar branches separadas para funcionalidades e realizar o merge após a finalização.


* 
**Super Bônus:** Realizar integrações via **Pull Requests (PRs)** com breve revisão pelo parceiro antes do merge.
