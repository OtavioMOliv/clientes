# Clientes API

## Comandos docker
```

```

```
docker build -t clientes:1.0 .
```

```
docker run --rm -p 8080:8080 --name clientes clientes:1.0
```

```
$ docker logs clientes
```

```
docker run -p 8080:8080 --name clientes clientes:1.0
docker build -t clientes:1.0 .
```

## Controller

### Get by Id
#### PathVariable
 ```
    @GetMapping("/clientes/{id}")
    @PathVariable Long id
```

#### RequestParam
 ```
   @RequestParam(required = false, defaultValue = "false" ) boolean showAllFields 
```

### Get All
 ```
    // TODO: Implementar Paginaçâo e Ordenação
 ```

### Post
```
    curl -X POST "http://localhost:8080/clientes" \
         -H "Content-Type: application/json" \ 
         -d "{\"nome\":\"Andre\"}"
```

### Limpar tabela (Only in Dev)
```
    TRUNCATE table cliente;
```

### Lidando com listas (estudo de caso)
```
@GetMapping("/fors")
public List<ClienteDto> getAllFors(){

        List<ClienteDto> clientesDto = new ArrayList<>();

        List<Cliente> clientes = new ArrayList<>();
        clientes = clienteService.getAllClientes();
        System.out.println("Cliente Entidade " + clientes.size());

        for(int i=0; i<clientes.size(); i++){
            Cliente cliente = clientes.get(i);
            clientesDto.add(new ClienteDto(cliente));
        }

        for(Cliente c : clientes){
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.setId(c.getId());
            clienteDto.setNome(c.getNome());
            clientesDto.add(clienteDto);
        }


        for(Cliente c : clientes){
            clientesDto.add(new ClienteDto(c));
        }

        clientes.stream().forEach(c ->{ clientesDto.add(new ClienteDto(c));});

        //lambda
        clientes.stream().forEach(c -> clientesDto.add(new ClienteDto(c)));

        clientes.forEach(c -> clientesDto.add(new ClienteDto(c)));

        System.out.println("Cliente DTO " + clientesDto.size());

        return clientesDto;
    }
```

## Alguns comandos git bash

### Ir para pasta do projeto

```
cd repositories/
```

### Listar pasta / arquivos

```
 ls
```
### verifica a versão do java

```
java --version
```

### verifica o caminho da variavel de ambiente

```
echo $JAVA_HOME
```

### clean install maven

```
./mvnw clean install
```

### roda o spring-boot do projeto

```
./mvnw spring-boot:run
```
