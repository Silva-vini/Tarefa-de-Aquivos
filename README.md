# Tarefa de Arquivos em Java

Projeto de estudo em Java que lê um arquivo de texto com dados de produtos, converte cada linha em um objeto (POJO) e gera a representação desses objetos em XML, sem usar bibliotecas externas.

## O que o projeto faz

1. Guarda produtos em um arquivo de texto (`cliente.txt`), um por linha, com os campos separados por `|`.
2. Lê o arquivo linha a linha e separa os dados com `split`.
3. Converte cada linha em um objeto `Produtos`.
4. Gera um arquivo `produtos.xml` com todos os produtos, montando o XML manualmente.

## Formato do arquivo base

Cada linha representa um produto no formato `nome|quantidade|preco`:

```
caneta|2|2.5
lapis|3|1.5
```

## Estrutura do projeto

| Classe | Responsabilidade |
|---|---|
| `Produtos` | POJO com os atributos `nome`, `quantidade` e `preco`, construtor, getters/setters e `toString()` no formato do arquivo |
| `Arquivo` | Guarda o caminho do arquivo base (`CAMINHO_ARQUIVO`) |
| `Estoque` | Adiciona, busca e lista produtos no arquivo, convertendo as linhas em objetos |
| `ConverterParaXML` | Recebe a lista de produtos e grava o `produtos.xml` |
| `Caixa` | Classe principal, com o menu no console |

## Menu

```
1: Adicionar Produto
2: Buscar Produto
3: Listar todos os produtos
4: Gerar XML
Qualquer outro número: Sair
```

## Exemplo de saída (`produtos.xml`)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<produtos>
    <produto>
        <nome>caneta</nome>
        <quantidade>2</quantidade>
        <preco>2.5</preco>
    </produto>
    <produto>
        <nome>lapis</nome>
        <quantidade>3</quantidade>
        <preco>1.5</preco>
    </produto>
</produtos>
```

## Como executar

1. Tenha o JDK instalado (Java 17 ou superior).
2. Crie a pasta indicada em `CAMINHO_ARQUIVO`, na classe `Arquivo`, ou ajuste o caminho para uma pasta que exista na sua máquina. O arquivo `cliente.txt` é criado automaticamente na primeira vez que um produto é adicionado, mas a pasta precisa existir.
3. Compile e execute a classe `Caixa`:

```bash
javac *.java
java Caixa
```

4. Use a opção `4` do menu para gerar o `produtos.xml`. Ele é criado na pasta em que o programa é executado.

## Conceitos praticados

- Leitura e escrita de arquivos com `BufferedReader`, `BufferedWriter`, `FileReader` e `FileWriter`
- `try-with-resources`
- Separação de dados com `String.split` e conversão com `Integer.parseInt` e `Double.parseDouble`
- POJO e encapsulamento
- Coleções com `List` e `ArrayList`
- Montagem manual de XML

## Possíveis melhorias

- Aplicar `try-with-resources` também na classe `Estoque`
- Tratar linhas mal formatadas ou em branco no arquivo
- Escapar caracteres especiais do XML (`&`, `<`, `>`) nos nomes dos produtos
- Mover o nome do arquivo `produtos.xml` para a classe `Arquivo`
