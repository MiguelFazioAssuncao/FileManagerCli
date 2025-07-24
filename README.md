# FileManagerCLI

CLI simples para criar e escrever arquivos de texto, com suporte a várias extensões e formatação automática de JSON.

---

## Como compilar
### 1. Compilando com Maven

Compile com:

```
mvn clean package
```

## Como usar

### 1. Usando `run.bat` no Windows

Esse script `.bat` facilita rodar os comandos no Windows.

**Exemplo:**

```powershell
.\run.bat create arquivo.txt
.\run.bat create dados.json
.\run.bat write arquivo.txt "Arquivo de texto"
.\run.bat write dados.json '{"nome":"Miguel","idade":17}'
```

### 2. Usando o comando Java diretamente

Se preferir, pode rodar a CLI diretamente com o comando Java.

Supondo que seu `.class` ou `.jar` esteja compilado:

```powershell
java -cp path/to/classes cli.Main create arquivo.txt
java -cp path/to/classes cli.Main create dados.json
java -cp path/to/classes cli.Main write arquivo.txt "Conteúdo do arquivo"
java -cp path/to/classes cli.Main write dados.json '{"nome":"Miguel"}'
```

## Detalhes importantes

- **Extensões suportadas:**  
  `.txt`, `.json`, `.xml`, `.csv`, `.md`, `.html`, `.java`, `.js`, `.log`, `.yaml`, `.yml`, `.ini`, `.properties`, `.cfg`, `.conf`.


- O conteúdo JSON é automaticamente validado e formatado.

- Conteúdos que não são JSON válidos são gravados como texto simples.

- Para passar JSON no terminal, use aspas simples externas para evitar conflito com aspas internas do JSON:

```powershell
.\run.bat write dados.json '{"chave": "valor"}'
```
- Para conteúdo texto simples, use aspas normais:

```powershell
.\run.bat write arquivo.txt "Texto simples aqui"
